package org.example.test.yanchiduilie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author gaozj
 * @date 2022年01月24日 11:13
 */
@RestController
public class TsetYcdlController {

    @Autowired
    private RedisDelayQueueManager redisDelayQueueManager;

    @GetMapping("/tset")
    public void addTask() throws IOException {
        NoticeTask task = new NoticeTask("notice-task", "notice-task-value", 300);
        redisDelayQueueManager.addTask(task);
        NoticeTask task2 = new NoticeTask("notice-task2", "notice-task-value2", 10);
        redisDelayQueueManager.addTask(task2);
       // System.in.read();
    }
}
