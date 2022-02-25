package org.example.test.yanchiduilie;

/**
 * 抽象任务
 */
public abstract class AbstractRedisDelayTask implements RedisDelayTask {

    protected String id;
    protected String value;
    private long delayTime;

    public AbstractRedisDelayTask(String id, String value, long delayTime) {
        this.id = id;
        this.value = value;
        this.delayTime = delayTime;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public long getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(long delayTime) {
        this.delayTime = delayTime;
    }

    @Override
    public String toString() {
        return "RedisDelayTask{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                ", delayTime=" + delayTime +
                '}';
    }
}