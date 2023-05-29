package com.ajie.service.impl;

import com.ajie.dao.UserDao;
import com.ajie.domain.User;
import com.ajie.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author ajie
 * @date 2023/5/25
 * @description:
 */
public class UserServiceImpl2 implements UserService {
    private UserDao userDao;

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    private List<Object> list;

    private Set<Object> set;

    private Object[] array;

    private Map<String, Object> map;

    private Properties properties;


    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setSet(Set<Object> set) {
        this.set = set;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {

        System.out.println("进入 service 层，使用 set 方式注入");
        System.out.println("set 方式注入 user：" + user);
        System.out.println("set 方式注入 list：" + list);
        System.out.println("set 方式注入 set：" + set);
        System.out.println("set 方式注入 array：" + array);
        System.out.println("set 方式注入 map：" + map);
        System.out.println("set 方式注入 properties：" + properties);
        userDao.save();
    }
}
