package com.ajie.util;

import com.ajie.dao.UserDao;
import com.ajie.dao.impl.UserDaoImpl;

/**
 * @author ajie
 * @date 2023/5/25
 * @description:
 */
public class DynamicFactoryBean {
    public UserDao createUserDao() {
        System.out.println("普通工厂创建对象！");
        return new UserDaoImpl();
    }
}
