package com.ajie.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ajie
 * @date 2023/6/4
 * @description:
 */
@Component
@Aspect
public class MyAdvice {
    /**
     * 切点表达式
     */
    @Pointcut("execution(* com.ajie.service..*.*(..))")
    public void pointcut() {
    }


    /**
     * 前置通知
     */
    @Before("pointcut()")
    //@Before("MyAdvice.pointcut()")
    public void before() {
        System.out.println("前置通知...");
    }

    /**
     * 后置通知
     */
    @After("pointcut()")
    //@After("MyAdvice.pointcut()")
    public void after() {
        System.out.println("后置通知...");
    }

}
