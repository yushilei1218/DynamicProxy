package com.yushilei.dynamicproxy.proxy;

import com.yushilei.dynamicproxy.bean.User;

import java.lang.annotation.Inherited;

import retrofit2.http.POST;

/**
 * @auther by yushilei.
 * @time 2017/6/22-16:06
 * @desc
 */

public interface Service {
    @MyAnnotation("测试")
    User addUser(String name, String psw);
}
