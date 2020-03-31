package com.wcl.play.websocket.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebsocketConfigration {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        System.out.println("create exporter!!");
        return new ServerEndpointExporter();
    }
}
