package com.example.rabbitmqprovider;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@ComponentScan(basePackages = {"com.example.rabbitmqprovider.aspect"})
@SpringBootApplication
@EnableAspectJAutoProxy
public class RabbitmqproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqproviderApplication.class, args);
    }

}


