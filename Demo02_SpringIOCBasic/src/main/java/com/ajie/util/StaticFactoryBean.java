package com.ajie.util;

import com.ajie.dao.UserDao;
import com.ajie.dao.impl.UserDaoImpl;

/**
 * @author ajie
 * @date 2023/5/25
 * @description:
 */
public class StaticFactoryBean {

    public static UserDao createUserDao() {
        System.out.println("静态工厂创建 bean 对象！");
        return new UserDaoImpl();
    }
}
