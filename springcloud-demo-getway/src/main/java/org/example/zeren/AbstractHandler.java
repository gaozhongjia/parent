package org.example.zeren;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public abstract class AbstractHandler {


    private AbstractHandler nextHandler;

    /**
     * 责任链的下一个对象
     */
    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * 具体参数拦截逻辑,给子类去实现
     */
    public void filter(HttpServletRequest request, HttpServletResponse response) {
        doFilter(request, response);
        if (getNextHandler() != null) {
            getNextHandler().filter(request, response);
        }
    }

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    protected abstract void doFilter(HttpServletRequest filterRequest, HttpServletResponse response);

}