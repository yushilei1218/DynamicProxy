package com.yushilei.dynamicproxy.fastjson;

import java.util.Date;
import java.util.List;

/**
 * @auther by yushilei.
 * @time 2017/6/29-10:49
 * @desc
 */

public class Bean {
    private List<String> showTokens;
    private Date startAt;
    private Date endAt;
    private boolean isShareFlag;

    public List<String> getShowTokens() {
        return showTokens;
    }

    public void setShowTokens(List<String> showTokens) {
        this.showTokens = showTokens;
    }

    public Date getStartAt() {
        return startAt;
    }

    public void setStartAt(Date startAt) {
        this.startAt = startAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public boolean isShareFlag() {
        return isShareFlag;
    }

    public void setShareFlag(boolean shareFlag) {
        isShareFlag = shareFlag;
    }
}
