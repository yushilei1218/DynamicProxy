package com.yushilei.dynamicproxy.bean;

/**
 * @auther by yushilei.
 * @time 2017/6/22-11:40
 * @desc
 */

public class User {
    public User() {
    }

    public User(String name, String psw) {
        this.name = name;
        this.psw = psw;
    }

    private String name;
    private String psw;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", psw='" + psw + '\'' +
                '}';
    }
}
