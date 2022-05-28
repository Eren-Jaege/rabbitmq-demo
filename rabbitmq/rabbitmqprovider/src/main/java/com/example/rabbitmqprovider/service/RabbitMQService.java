package com.example.rabbitmqprovider.service;

import java.util.Map;

/**
 * @author 吴文涛
 * @ClassName RabbitMQService
 * @date 2022.05.16 15:33
 */
public interface RabbitMQService {
    String sendMsg(String msg) throws Exception;
    String sendMsgByFanoutExchange(String msg) throws Exception;
    String sendMsgByTopicExchange(String msg, String routingKey) throws Exception;
    String sendMsgByHeadersExchange(String msg, Map<String, Object> map) throws Exception;
}
