package com.yushilei.dynamicproxy.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/7/8.
 */

public class BaseApp extends Application {
    public static Context AppContext;

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext = this;
    }
}
