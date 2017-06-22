package com.yushilei.dynamicproxy.proxy;

import com.yushilei.dynamicproxy.bean.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther by yushilei.
 * @time 2017/6/22-16:07
 * @desc
 */

public class Proxy implements Service {
    /**
     * 接口方法的真正实现对象
     */
    InvocationHandler h;

    public Proxy(InvocationHandler h) {
        this.h = h;
    }

    /**
     * Proxy 这个类仅仅是提供了接口的实现的方法体，
     * 而真正的实现实际上是调用的InvocationHandler h.invoke()方法
     * Proxy 利用InvocationHandler 间接的实现了addUser 也就是代理模式
     */
    @Override
    public User addUser(String name, String psw) {
        try {
            Method method1 = Service.class.getDeclaredMethod("addUser", String.class, String.class);

            Object proxy = this;

            return (User) h.invoke(proxy, method1, new Object[]{name, psw});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyProxy.class";
    }
}
