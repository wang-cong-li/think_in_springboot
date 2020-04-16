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

    private Long userId;

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
        this.userId = userId;
        ONLINE_COUNT.incrementAndGet();
        session.getBasicRemote().sendText("欢迎来到XXX聊天室~~~");
    }

    @OnClose
    public void onClose() {
        Long userId = this.userId;
        if (sessionMap.containsKey(userId)) {
            sessionMap.remove(userId);
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        if (!StringUtils.hasText(message)) {
            session.getBasicRemote().sendText("不要发送空消息");
            return;
        }
        JSONObject msgBody = JSON.parseObject(message);
        msgBody.put("content",message);
        msgBody.put("fromUser", this.userId);
        String toUserId = msgBody.getString("toUserId");
        Long userId = Long.parseLong(toUserId);
        if (this.userId.equals(userId)) {
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

        System.out.println("error:" + error.getMessage());
        Long userId = this.userId;
        System.out.println("OnError::userId:" + userId);
        if (null == userId) {
            return;
        }
        sessionMap.remove(userId);
        session.close();
    }

}
