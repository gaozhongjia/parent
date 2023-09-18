package org.example.feign;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public class zl {

    public static void main(String[] args) {
         DynamicClient dynamicClient = new DynamicClient();
        Object result = dynamicClient.executePostApi("system", "/system/test", new HashMap<>());
        System.out.println("==========>"+ JSONObject.toJSONString(result));
    }
}
