package org.example.yudao.WebSocket.lian;// WebsocketServerEndpoint.java

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;

@Controller
@ServerEndpoint("/")
public class WebsocketServerEndpoint {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        logger.info("[onOpen][session({}) 接入]", session);
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        logger.info("[onOpen][session({}) 接收到一条消息({})]", session, message); // 生产环境下，请设置成 debug 级别
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info("[onClose][session({}) 连接关闭。关闭原因是({})}]", session, closeReason);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        logger.info("[onClose][session({}) 发生异常]", session, throwable);
    }

    private static final Map<String, MessageHandler> HANDLERS = new HashMap<>();

    @Autowired
    private ApplicationContext applicationContext;


    public void afterPropertiesSet() throws Exception {
        // 通过 ApplicationContext 获得所有 MessageHandler Bean
        applicationContext.getBeansOfType(MessageHandler.class).values() // 获得所有 MessageHandler Bean
                .forEach(messageHandler -> HANDLERS.put(messageHandler.getType(), messageHandler)); // 添加到 handlers 中
        logger.info("[afterPropertiesSet][消息处理器数量：{}]", HANDLERS.size());
    }

}