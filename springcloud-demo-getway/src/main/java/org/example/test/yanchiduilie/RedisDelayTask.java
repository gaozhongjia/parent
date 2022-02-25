package org.example.test.yanchiduilie;

/**
 * 延迟任务对象定义
 */
public interface RedisDelayTask {
    /**
     *  任务ID
     * @return
     */
    String getId();

    /**
     *  队列中的值
     * @return
     */
    String getValue();

    /**
     *  延迟时间（单位：s）
     * @return
     */
    long getDelayTime();

    /**
     *  任务执行
     */
    void execute();
}