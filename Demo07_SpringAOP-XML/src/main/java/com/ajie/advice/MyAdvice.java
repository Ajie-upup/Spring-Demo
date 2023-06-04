package com.ajie.advice;

/**
 * @author ajie
 * @date 2023/6/4
 * @description:
 */
public class MyAdvice {

    public void before() {
        System.out.println("前置通知...");
    }

    public void after() {
        System.out.println("后置通知...");
    }

}
