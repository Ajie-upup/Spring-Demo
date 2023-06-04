package com.ajie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author ajie
 * @date 2023/6/4
 * @description:
 */
@Configuration
@ComponentScan("com.ajie")
@EnableAspectJAutoProxy  // 开启 AOP 自动代理
public class SpringConfig {
}
