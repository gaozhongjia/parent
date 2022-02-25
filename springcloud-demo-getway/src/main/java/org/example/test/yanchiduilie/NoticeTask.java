package org.example.test.yanchiduilie;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 通知类任务定义
 */
public class NoticeTask extends AbstractRedisDelayTask {

    private final static Logger LOGGER = LoggerFactory.getLogger(NoticeTask.class);

    public NoticeTask(String id, String value, long delayTime) {
        super(id, value, delayTime);
    }

    @Override
    public void execute() {
        LOGGER.info("task execute, {}", this);
    }
}