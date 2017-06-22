package com.yushilei.dynamicproxy.bean;

/**
 * @auther by yushilei.
 * @time 2017/6/22-15:14
 * @desc
 */
//"title": "精品",
//        "contentType": "paid",
//        "url": "",
//        "unactiveCoverPath": "http://fdfs.xmcdn.com/group28/M02/7F/7B/wKgJSFlHUtjCxWjJAAAShv6_Qe4949.jpg",
//        "activeCoverPath": "http://fdfs.xmcdn.com/group28/M02/81/30/wKgJXFlHUt6hPCA0AAAShv6_Qe4365.jpg",
//        "categoryId": 33
public class Tab {
    private String title;
    private String contentType;
    private String url;
    private String unactiveCoverPath;
    private String activeCoverPath;
    private int categoryId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUnactiveCoverPath() {
        return unactiveCoverPath;
    }

    public void setUnactiveCoverPath(String unactiveCoverPath) {
        this.unactiveCoverPath = unactiveCoverPath;
    }

    public String getActiveCoverPath() {
        return activeCoverPath;
    }

    public void setActiveCoverPath(String activeCoverPath) {
        this.activeCoverPath = activeCoverPath;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
