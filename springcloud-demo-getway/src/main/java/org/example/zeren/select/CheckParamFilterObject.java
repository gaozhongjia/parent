package org.example.zeren.select;


import org.example.zeren.AbstractHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 参数校验对象
 * @author gaozj*/
@Component
@Order(1) //顺序排第1，最先校验
public class CheckParamFilterObject extends AbstractHandler {

    @Override
    protected void doFilter(HttpServletRequest filterRequest, HttpServletResponse response) {
        System.out.println("非空参数检查");
    }
}