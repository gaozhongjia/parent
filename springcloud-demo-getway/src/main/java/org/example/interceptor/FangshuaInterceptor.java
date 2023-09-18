package org.example.interceptor;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @author gaozhongjia
 */
@Component
public class FangshuaInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断请求是否属于方法的请求
        if(handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler;
            //获取方法中的注解,看是否有该注解
            ControllerLimit controllerLimit = hm.getMethodAnnotation(ControllerLimit.class);
            if(controllerLimit == null){
                return true;
            }
            int seconds = controllerLimit.seconds();
            int maxCount = controllerLimit.maxCount();
            boolean login = controllerLimit.needLogin();
            String key = request.getRequestURI();
            //如果需要登录
            if (login){
                //获取登录的session进行判断
                //.....
                key+=""+"1";  //这里假设用户是1,项目中是动态获取的userId
            }

            //从redis中获取用户访问的次数
            Integer count = (int)redisTemplate.opsForValue().get(key);
            if (count == null){
                //第一次访问
                redisTemplate.opsForValue().set(key,1);
            } else if (count < maxCount){
                //加1
                redisTemplate.opsForValue().increment(key);
            } else {
                //超出访问次数
                render(response); //这里的CodeMsg是一个返回参数
                return false;
            }
        }
        return true;
    }

    private void render(HttpServletResponse response)throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String str  = JSON.toJSONString("");
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }

}
