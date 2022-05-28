package com.example.rabbitmqconsumer.demo;

import com.hello.world.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * @author 吴文涛
 * @ClassName RabbitDemoConsumer
 * @date 2022.05.16 15:41
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC))
public class RabbitDemoConsumer {
    @RabbitHandler
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(name = ""),
//            exchange = @Exchange(name = "",type = ExchangeTypes.DIRECT),
//            key = {"red","blue"}
//    ))
    public void process(Map map) {
        System.out.println("消费者RabbitDemoConsumer从RabbitMQ服务端消费消息" + map.toString());
    }
}
