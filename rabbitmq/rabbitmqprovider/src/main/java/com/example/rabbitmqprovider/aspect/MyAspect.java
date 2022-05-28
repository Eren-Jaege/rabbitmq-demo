package com.example.rabbitmqprovider.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 吴文涛
 * @ClassName MyAspect
 * @date 2022.05.19 11:09
 */

@Component
@Aspect
public class MyAspect {
    @Before("execution(* com.example.rabbitmqprovider.controller.RabbitMQController.sendMsg(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("我要发信息了！！！"+joinPoint);
    }
}
