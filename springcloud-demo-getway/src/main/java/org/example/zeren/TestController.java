package org.example.zeren;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author gaozj
 */
@RestController
public class TestController {

    @Autowired
    private ChainPatternDemo demo;

    @GetMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response){


        //一个接口或者抽象类，里面两个方法（一个匹配类型，一个逻辑实现）
        // 不同策略的实现类
        // 使用策略模式
        demo.exec(request,response);
    }
}
