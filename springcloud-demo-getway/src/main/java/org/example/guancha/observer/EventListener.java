package org.example.guancha.observer;

import com.google.common.eventbus.Subscribe;

public class EventListener {

    @Subscribe //加了订阅，这里标记这个方法是事件处理方法
    public void handle(NotifyEvent notifyEvent) {
        System.out.println("发送IM消息" + notifyEvent.getImNo());

    }
}

