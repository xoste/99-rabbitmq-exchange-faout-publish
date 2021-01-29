package com.xoste.rabbitmqexchangefaoutpublish.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * @author Leon
 */
@Component
public class Publisher {
    @Autowired
    private AmqpTemplate rabbitmqAmqTemplate;
    @Value("${rabbitmq.config.exchange}")
    private String exchange;

    public void publish(String msg) {
        this.rabbitmqAmqTemplate.convertAndSend(this.exchange, "", msg);
    }
}
