package com.yushilei.dynamicproxy.net;

import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.yushilei.dynamicproxy.base.AppStack;
import com.yushilei.dynamicproxy.base.BaseActivity;
import com.yushilei.dynamicproxy.base.BaseApp;
import com.yushilei.dynamicproxy.base.DialogUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Retrofit2 Callback 保证类
 * <p>
 * 代理实现网络请求公共部分操作处理
 * 部分代理，关注公共处理
 */

public class CallBackProxy<T> implements Callback<T> {
    private Callback<T> callback;

    public CallBackProxy(Callback<T> callback) {
        this.callback = callback;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        //这里来处理网络请求公共部分
        if (response.code() > 1000 && response.code() < 1010) {
            //强制APP退出
            BaseActivity topActivity = AppStack.getTopActivity();
            if (topActivity != null && topActivity.isResume()) {
                topActivity.showDialog(DialogUtil.getForceQuitDialog(topActivity));
            }
            return;
        }
        if (response.isSuccessful()) {
            callback.onResponse(call, response);
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        t.printStackTrace();
        if (t instanceof SocketTimeoutException) {
            //指的是服务器响应超时
            Toast.makeText(BaseApp.AppContext, "网络连接超时！", Toast.LENGTH_SHORT).show();
        }
        if (t instanceof UnknownHostException) {
            //网站关闭、域名解析失败
            Toast.makeText(BaseApp.AppContext, "未知Host！", Toast.LENGTH_SHORT).show();
        }
        if (t instanceof ConnectException) {
            //指的是服务器请求超时
            Toast.makeText(BaseApp.AppContext, "连接服务器异常,请重试！", Toast.LENGTH_SHORT).show();
        }
        callback.onFailure(call, t);
    }
}
