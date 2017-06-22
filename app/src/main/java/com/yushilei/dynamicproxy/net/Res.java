package com.yushilei.dynamicproxy.net;

/**
 * @auther by yushilei.
 * @time 2017/6/22-11:46
 * @desc 网络请求反序列化 基础类
 */

/**
 * 代表一个Json反序列化后的描述类
 */
public class Res<T> {
    private int ret;
    private String msg;
    private T tabs;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getTabs() {
        return tabs;
    }

    public void setTabs(T tabs) {
        this.tabs = tabs;
    }
}
