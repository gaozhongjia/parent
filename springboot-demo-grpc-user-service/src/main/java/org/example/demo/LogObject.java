package org.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LogObject {
    @JsonProperty(index = 1)
    //
    private String eventName;

    @JsonProperty(index = 2)
   // 调用链id
    private String traceId;

    @JsonProperty(index = 3)
    // 结果消息
    private String msg;

    @JsonProperty(index = 4)
    // 接口响应时间
    private long costTime;

    @JsonProperty(index = 6)
    // C端用户id
    private Integer userId;

    @JsonProperty(index = 7)
    // 其他业务参数
    private Object others;

    @JsonProperty(index = 8)
    // 接口请求入参
    private Object request;

    @JsonProperty(index = 9)
    // 接口返回值
    private Object response;


    public LogObject() {
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCostTime() {
        return costTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Object getOthers() {
        return others;
    }

    public void setOthers(Object others) {
        this.others = others;
    }

    public Object getRequest() {
        return request;
    }

    public void setRequest(Object request) {
        this.request = request;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}