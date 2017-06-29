package com.yushilei.dynamicproxy.util;

import com.alibaba.fastjson.JSON;

/**
 * @auther by yushilei.
 * @time 2017/6/29-10:43
 * @desc
 */

public class FastJsonUtil {
    public static String toJson(Object obj){
        return JSON.toJSONString(obj);
    }
}
