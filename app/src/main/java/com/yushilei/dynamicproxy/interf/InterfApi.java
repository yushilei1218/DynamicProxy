package com.yushilei.dynamicproxy.interf;

import com.yushilei.dynamicproxy.bean.User;

import retrofit2.http.POST;

/**
 * @auther by yushilei.
 * @time 2017/6/22-13:08
 * @desc
 */

public interface InterfApi {
    @POST
    User getUser(String name, String psw);
}
