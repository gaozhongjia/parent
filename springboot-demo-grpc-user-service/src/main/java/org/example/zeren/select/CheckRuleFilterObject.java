package org.example.zeren.select;

import org.example.zeren.AbstractHandler;
import org.omg.CORBA.Request;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.xml.ws.Response;

/**
 *  规则拦截对象
 * @author gaozj
 */
@Component
@Order(4) //校验顺序排第4
public class CheckRuleFilterObject extends AbstractHandler {

    @Override
    public void doFilter(Request request, Response response) {
        System.out.println("规则拦截对象");
    }
}