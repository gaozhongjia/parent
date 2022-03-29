package org.example.test.objectTo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public class ChatDTO {
 
    private String userId;
 
    private String message;
 
    private String createDate;
 
    private String createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }


    public static void main(String[] args) {
        String json = "{userId:'1',message:'2',create_time:'2020-03-28 20:58:11',create_date:'2020-03-28'}";
        String a = "[{userId: '1'},{message:'2'}]";
        JSONObject object = JSONObject.parseObject(json); //先转成json对象
       System.out.println(ReflectUtil.reflect(object));
    }
}