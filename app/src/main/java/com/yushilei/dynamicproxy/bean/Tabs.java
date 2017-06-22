package com.yushilei.dynamicproxy.bean;

import java.util.List;

/**
 * @auther by yushilei.
 * @time 2017/6/22-15:14
 * @desc
 */

public class Tabs {
    private int count;
    private int first;
    private List<Tab> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public List<Tab> getList() {
        return list;
    }

    public void setList(List<Tab> list) {
        this.list = list;
    }
}
