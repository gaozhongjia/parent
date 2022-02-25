package org.example.guancha.observer;

import com.google.common.eventbus.EventBus;

public class EventBusCenter {

    // 自己搞一套观察者模式的代码，还是有点小麻烦。这里使用了Guava EventBus就封装好了，Guava提供一套基于注解的事件总线，api可以灵活的使用。

    private static EventBus eventBus = new EventBus();

    private EventBusCenter() {
    }

    public static EventBus getInstance() {
        return eventBus;
    }
     //添加观察者
    public static void register(Object obj) {
        eventBus.register(obj);
    }
    //移除观察者
    public static void unregister(Object obj) {
        eventBus.unregister(obj);
    }
    //把消息推给观察者
    public static void post(Object obj) {
        eventBus.post(obj);
    }
}