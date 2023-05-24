package com.ajie.dao.impl;

import com.ajie.dao.IUserDao;

/**
 * @author ajie
 * @date 2023/5/24
 * @description:
 */
public class UserDaoImpl implements IUserDao {
    @Override
    public void save() {
        System.out.println("Dao 实现类被调用。。。");
        System.out.println("方法执行成功！");
    }
}
