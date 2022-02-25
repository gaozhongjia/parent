package org.example.demo;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    public void test(){
        long endTime = System.currentTimeMillis();
        LogObject logObject = new LogObject();
        logObject.setEventName("name");
        log.info(JSONObject.toJSONString(logObject));
    }
}
