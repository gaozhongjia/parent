package org.example.zeren.select;
import org.example.zeren.AbstractHandler;
import org.omg.CORBA.Request;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.xml.ws.Response;
/**
 *  安全校验对象
 * @author gaozj
 */
@Component
@Order(2) //校验顺序排第2
public class CheckSecurityFilterObject extends AbstractHandler {

    @Override
    public void doFilter(Request request, Response response) {
        //invoke Security check
        System.out.println("安全调用校验");
    }
}