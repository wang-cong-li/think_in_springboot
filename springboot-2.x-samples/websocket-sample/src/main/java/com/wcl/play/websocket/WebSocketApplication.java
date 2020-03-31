package com.wcl.play.websocket;

import com.wcl.play.websocket.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import java.io.IOException;

@SpringBootApplication
@Controller
public class WebSocketApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }

    @GetMapping("index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("page")
    public ModelAndView page(){
        return new ModelAndView("ws");
    }
}
