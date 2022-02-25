package org.example.test.yanchiduilie;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Component
public class RedisDelayQueueManager implements InitializingBean {

    @Autowired
    private StringRedisTemplate redisTemplate;
    /**
     *  任务列表
     */
    private Map<String, RedisDelayTask> tasks = new ConcurrentHashMap<>();


    /**
     *  添加延迟任务到队列
     * @param task
     */
    public void addTask(RedisDelayTask task) {
        long delayedTime = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(task.getDelayTime(), TimeUnit.SECONDS);
        boolean r = redisTemplate.opsForZSet().add(task.getId(), task.getValue(), delayedTime);
        if (r) {
            tasks.put(task.getId(), task);
        }
    }

    /**
     *  检查并执行任务
     */
    private void checkAndExecuteTask() {
        while (true) {
            Set<String> taskIds = tasks.keySet();
            for (String taskId : taskIds) {
                // score就是任务要执行的时间点，如果<=当前时间，说明任务该执行了
                Set<ZSetOperations.TypedTuple<String>> tuples = redisTemplate.opsForZSet().rangeByScoreWithScores(taskId, 0, System.currentTimeMillis());
                if (!CollectionUtils.isEmpty(tuples)) {
                    for (ZSetOperations.TypedTuple<String> tuple : tuples) {
                        // 移除并执行任务
                        RedisDelayTask task = tasks.remove(taskId);
                        if (task != null) {
                            task.execute();
                            // 从队列中删除
                            System.out.println("删除成功");
                            redisTemplate.opsForZSet().remove(taskId, tuple.getValue());
                        }
                    }
                }
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 新起一个线程执行任务
        new Thread(() -> {
            checkAndExecuteTask();
        }, "redis-delay-task").start();
    }
}