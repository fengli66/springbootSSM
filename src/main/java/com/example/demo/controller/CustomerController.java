package com.example.demo.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.annotation.JmsListeners;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户控制器
 *
 * @author fengli
 * @version 1.0
 * @date 2020/12/09
 */
@RestController
@Component
public class CustomerController {
    private String msg;
    /**
     * 监听和读取消息
     * @param msg
     */
    @JmsListener(destination = "active.queue")
    @SendTo(value = "msg")
    public String readActiveQueue(String msg) {
        this.msg=msg;
        System.out.println("接收到：" + msg);
        return msg;

    }

    @RequestMapping("/getmsg")
//    @JmsListener(destination = "active.queue")
    public String getActiveQueue(){
        return msg;
    }

}
