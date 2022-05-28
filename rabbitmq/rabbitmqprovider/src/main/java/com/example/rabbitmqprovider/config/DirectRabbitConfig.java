package com.example.rabbitmqprovider.config;

import com.hello.world.config.RabbitMQConfig;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;


/**
 * @author 吴文涛
 * @ClassName DirectRabbitConfig
 * @date 2022.05.16 15:20
 */
@Configuration
public class DirectRabbitConfig {
    ///////////////////////////////////////////////直连交换机////////////////////////////////////////////////////

    @Bean
    public DirectExchange rabbitmqDemoDirectExchange() {
        //Direct交换机
        return new DirectExchange(RabbitMQConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE, true, false);
    }

    @Bean
    public Queue rabbitmqDemoDirectQueue() {
        return new Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC, true, false, false);
    }

    @Bean
    public Binding bindDirect() {
        //链式写法，绑定交换机和队列，并设置匹配键
        return BindingBuilder
                //绑定队列
                .bind(rabbitmqDemoDirectQueue())
                //到交换机
                .to(rabbitmqDemoDirectExchange())
                //并设置匹配键
                .with(RabbitMQConfig.RABBITMQ_DEMO_DIRECT_ROUTING);
    }

    ////////////////////////////////////////////////////发布订阅交换机////////////////////////////////////////////////////////
    @Bean
    public FanoutExchange rabbitmqDemoFanoutExchange() {
        //创建FanoutExchange类型交换机
        return new FanoutExchange(RabbitMQConfig.FANOUT_EXCHANGE_DEMO_NAME, true, false);
    }

    @Bean
    public Queue fanoutExchangeQueueA() {
        //队列A
        return new Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_A, true, false, false);
    }

    @Bean
    public Queue fanoutExchangeQueueB() {
        //队列B
        return new Queue(RabbitMQConfig.FANOUT_EXCHANGE_QUEUE_TOPIC_B, true, false, false);
    }

    @Bean
    public Binding bindFanoutA() {
        //队列A绑定到FanoutExchange交换机
        return BindingBuilder.bind(fanoutExchangeQueueA()).to(rabbitmqDemoFanoutExchange());
    }

    @Bean
    public Binding bindFanoutB() {
        //队列B绑定到FanoutExchange交换机
        return BindingBuilder.bind(fanoutExchangeQueueB()).to(rabbitmqDemoFanoutExchange());
    }

    //////////////////////////////////////////////TopicExchange交换机//////////////////////////////////////////////////////////
    @Bean
    public TopicExchange rabbitmqDemoTopicExchange() {
        //配置TopicExchange交换机
        return new TopicExchange(RabbitMQConfig.TOPIC_EXCHANGE_DEMO_NAME, true, false);
    }

    @Bean
    public Queue topicExchangeQueueA() {
        //创建队列1
        return new Queue(RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_A, true, false, false);
    }

    @Bean
    public Queue topicExchangeQueueB() {
        //创建队列2
        return new Queue(RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_B, true, false, false);
    }

    @Bean
    public Queue topicExchangeQueueC() {
        //创建队列3
        return new Queue(RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_C, true, false, false);
    }

    @Bean
    public Binding bindTopicA() {
        //队列A绑定到FanoutExchange交换机
        return BindingBuilder.bind(topicExchangeQueueB())
                .to(rabbitmqDemoTopicExchange())
                .with("a.*");
    }

    @Bean
    public Binding bindTopicB() {
        //队列A绑定到FanoutExchange交换机
        return BindingBuilder.bind(topicExchangeQueueC())
                .to(rabbitmqDemoTopicExchange())
                .with("a.*");
    }

    @Bean
    public Binding bindTopicC() {
        //队列A绑定到FanoutExchange交换机
        return BindingBuilder.bind(topicExchangeQueueA())
                .to(rabbitmqDemoTopicExchange())
                .with("rabbit.#");
    }
////////////////////////////////////////////////HEADEREXCHANGE交换机////////////////////////////////////////////////

    @Bean
    public HeadersExchange rabbitmqDemoHeaderExchange() {
        return new HeadersExchange(RabbitMQConfig.HEADER_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Queue headerExchangeQueueA() {
        return new Queue(RabbitMQConfig.HEADER_EXCHANGE_QUEUE_A, true, false, false);
    }

    @Bean
    public Queue headerExchangeQueueB() {
        return new Queue(RabbitMQConfig.HEADER_EXCHANGE_QUEUE_B, true, false, false);
    }

    @Bean
    public Binding bindHeadA() {
        Map<String, Object> map = new HashMap<>();
        map.put("key_one", "java");
        map.put("key_two", "rabbit");
        return BindingBuilder.bind(headerExchangeQueueA())
                .to(rabbitmqDemoHeaderExchange())
                .whereAll(map).match();
    }

    @Bean
    public Binding bindHeadB() {
        Map<String, Object> map = new HashMap<>();
        map.put("headers_A", "coke");
        map.put("headers_B", "sky");
        return BindingBuilder.bind(headerExchangeQueueB())
                .to(rabbitmqDemoHeaderExchange())
                .whereAny(map).match();

    }
}
