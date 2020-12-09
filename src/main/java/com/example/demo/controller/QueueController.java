package com.example.demo.controller;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * 队列消息控制器
 *
 * @author fengli
 * @version 1.0
 * @date 2020/12/09
 */
@RestController
@EnableScheduling
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    /**
     * 消息产生者
     */
    @RequestMapping("/send")
    @Scheduled(fixedDelay = 5000)
    public void send() {
        //指定消息发送的目的地及内容
        this.jmsMessagingTemplate.convertAndSend(this.queue, "新发送的消息");
    }
}
