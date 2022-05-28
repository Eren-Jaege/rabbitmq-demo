package com.example.rabbitmqconsumer.demo;

import com.hello.world.config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 吴文涛
 * @ClassName HeadExxchangeConsumer
 * @date 2022.05.16 17:08
 */
@Component
public class HeadExchangeConsumerB {
    @RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.HEADER_EXCHANGE_QUEUE_B))
    public void process(Message message) throws Exception {
        MessageProperties messageProperties = message.getMessageProperties();
        String contentType = messageProperties.getContentType();
        System.out.println("队列[" + RabbitMQConfig.HEADER_EXCHANGE_QUEUE_B + "]收到消息：" + new String(message.getBody(), contentType));
    }

}
