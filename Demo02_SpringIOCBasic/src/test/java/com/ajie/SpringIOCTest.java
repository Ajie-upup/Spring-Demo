package com.ajie;

import com.ajie.dao.UserDao;
import com.ajie.service.UserService;
import com.ajie.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ajie
 * @date 2023/5/25
 * @description:
 */
public class SpringIOCTest {

    @Test
    public void test1() {
        // 读取并解析配置文件
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取 bean 对象
        UserDao userDao = (UserDao) classPathXmlApplicationContext.getBean("userDao");

        userDao.save();
    }

    /**
     * 测试单例，多例
     */
    @Test
    public void test2() {
        // 读取并解析配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取 bean 对象
        UserDao userDao = (UserDao) classPathXmlApplicationContext.getBean("userDao");
        UserDao userDao2 = (UserDao) classPathXmlApplicationContext.getBean("userDao");

        System.out.println(userDao);
        System.out.println(userDao2);

        // 测试销毁方法
        classPathXmlApplicationContext.close();
    }

    /**
     * 测试静态工厂创建 bean 对象
     */
    @Test
    public void test3() {
        // 读取并解析配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取 bean 对象
        UserDao userDao2 = (UserDao) classPathXmlApplicationContext.getBean("userDao2");

        userDao2.save();
    }

    /**
     * 测试普通工厂创建 bean 对象
     */
    @Test
    public void test4() {
        // 读取并解析配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 获取 bean 对象
        UserDao userDao3 = (UserDao) classPathXmlApplicationContext.getBean("userDao3");

        userDao3.save();
    }

    @Test
    public void test5() {
        // 读取并解析配置文件
        // 可以并列导入多个配置文件
        ApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext("applicationContext.xml", "applicationContext-service.xml");

        UserService userService = (UserService) classPathXmlApplicationContext.getBean("userService2");

        userService.save();
    }
}
