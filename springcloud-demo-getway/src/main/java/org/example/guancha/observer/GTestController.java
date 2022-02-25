package org.example.guancha.observer;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaozj
 * @date 2021年12月15日 16:28
 */
@RestController
public class GTestController {

    public void register() {
        //  User user = new User();
        //  insertRegisterUser（user）;
        //  sendMobileMessage（）;
        //  sendEmail()；
        //  sendMobileMessage2();
        //如果调发短信的接口失败 了，是不是又影响到用户注册了？！这时候，是不是得加个异步方法给通知消息 才好
        //实际上，我们可以使用观察者模式优化

        // 观察者模式属于行为模式，一个对象（被观察者）的状态发生改变，
        // 所有的依赖对象（观察者对象）都将得到通知，
        // 进行广播通知。它的主要成员就是观察者和被观察者 。

        // 使用场景： 完成某件事情后，异步通知场景。如，登陆成功 发送消息

        //一个被观察者的类Observerable ;
        //多个观察者Observer ；
        //观察者的差异化实现
        //经典观察者模式封装：EventBus实战
    }

    public static void main(String[] args) {
        EventListener eventListener = new EventListener();
        EventListener2 eventListener2 = new EventListener2();
        EventListener3 eventListener3 = new EventListener3();
        EventBusCenter.register(eventListener);
        EventBusCenter.register(eventListener2);
        EventBusCenter.register(eventListener3);
        EventBusCenter.post(new NotifyEvent("13372817283", "123@qq.com", "666"));
    }
}
