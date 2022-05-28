package com.example.rabbitmqconsumer.demo;

import com.hello.world.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author 吴文涛
 * @ClassName FanoutExchangeConsumerA
 * @date 2022.05.16 16:26
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_B))
public class FanoutExchangeConsumerB {
    @RabbitHandler
    public void process(Map<String, Object> map) {
        System.out.println("队列B收到消息：" + map.toString());
    }
}
