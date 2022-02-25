package org.example.zeren;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

/**
 * @author gaozj
 */
@RestController
public class TestController {

    @Autowired
    private demo demo;

    @GetMapping("/test")
    public void test(Request request, Response response){
        demo.exec(request,response);
    }
}
