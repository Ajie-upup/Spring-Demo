package com.ajie;

import com.ajie.service.IUserService;
import com.ajie.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author ajie
 * @date 2023/5/24
 * @description:
 */
public class IOCTest {
    /**
     * 测试 new 关键字创建容器对象
     */
    @Test
    public void testNew() {
        IUserService userService = new UserServiceImpl();
        userService.save1();
    }

    /**
     * 测试 反射 创建容器对象
     */
    @Test
    public void testClass() {
        IUserService userService = new UserServiceImpl();
        userService.save2();
    }

    /**
     * 测试 xml + 反射 创建容器对象
     */
    @Test
    public void testXml() {
        IUserService userService = new UserServiceImpl();
        userService.save3();
    }

}
