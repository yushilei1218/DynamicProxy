package com.yushilei.dynamicproxy.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @auther by yushilei.
 * @time 2017/6/22-15:20
 * @desc Json 反系列化
 */

public class JsonUtil {
    public static String toJson(Object obj) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(obj);
    }
}
