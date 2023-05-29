package com.ajie.domain;

/**
 * @author ajie
 * @date 2023/5/25
 * @description:
 */
public class User {

    private String name;

    private Integer age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
