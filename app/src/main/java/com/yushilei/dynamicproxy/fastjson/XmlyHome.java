package com.yushilei.dynamicproxy.fastjson;

import java.util.List;

/**
 * @auther by yushilei.
 * @time 2017/6/29-10:48
 * @desc
 */

public class XmlyHome {
    private int ret;
    private long responseId;
    private List<Bean> data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public long getResponseId() {
        return responseId;
    }

    public void setResponseId(long responseId) {
        this.responseId = responseId;
    }

    public List<Bean> getData() {
        return data;
    }

    public void setData(List<Bean> data) {
        this.data = data;
    }
}
