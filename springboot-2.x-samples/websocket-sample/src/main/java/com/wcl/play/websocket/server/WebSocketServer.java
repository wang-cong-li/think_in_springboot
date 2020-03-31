package com.wcl.play.websocket.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@ServerEndpoint(value = "/websocket/{userId}")
public class WebSocketServer {

    private AtomicInteger ONLINE_COUNT = new AtomicInteger();

    private Map<Long, Session> sessionMap = new ConcurrentHashMap<>();

    ThreadLocal<Long>  userIdTL = new ThreadLocal<>();

    public void sendInfo(String message, String toUserId) throws IOException {
        System.out.println("发送消息到:"+toUserId+"，报文:"+message);
        if(StringUtils.hasText(toUserId)&&sessionMap.containsKey(toUserId)){
            sessionMap.get(toUserId).getBasicRemote().sendText(message);
        }else{
            System.out.println("用户"+toUserId+",不在线！");
        }
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") Long userId) throws IOException {
        System.out.println("有新链接啦");
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
        }
        sessionMap.put(userId, session);
        userIdTL.set(userId);
        ONLINE_COUNT.incrementAndGet();
        session.getBasicRemote().sendText("欢迎来到XXX聊天室~~~");
    }

    @OnClose
    public void onClose() {
        Long userId = userIdTL.get();
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
        }
        userIdTL.remove();
    }

    @OnMessage(maxMessageSize = 10000)
    public void onMessage(String message, Session session) throws IOException {
        if (!StringUtils.hasText(message)) {
            session.getBasicRemote().sendText("不要发送空消息");
            return;
        }
        JSONObject msgBody = JSON.parseObject(message);
        msgBody.put("content",message);
        msgBody.put("fromUser", userIdTL.get());
        String toUserId = msgBody.getString("toUser");
        Long userId = Long.parseLong(toUserId);
        if (userIdTL.get().equals(userId)) {
            session.getBasicRemote().sendText("不要发送消息给自己哦");
            return;
        }
        Session sessionTo = sessionMap.get(userId);
        if (Objects.isNull(sessionTo)) {
            session.getBasicRemote().sendText("这个老哥还未上线");
            return;
        }
        sessionTo.getBasicRemote().sendText(msgBody.toJSONString());
    }

    @OnError()
    public void onError(Session session, Throwable error) throws IOException {
        sessionMap.remove(userIdTL.get());
        session.close();
        userIdTL.remove();
        System.out.println("error:" + error.getMessage());
    }

}
