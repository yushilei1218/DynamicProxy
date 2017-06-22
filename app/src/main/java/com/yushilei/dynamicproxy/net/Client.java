package com.yushilei.dynamicproxy.net;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @auther by yushilei.
 * @time 2017/6/22-11:35
 * @desc
 */

/**
 * OkHttpClient
 */
public class Client {
    private Client() {
    }

    private static OkHttpClient client;

    public static synchronized OkHttpClient getClient() {
        if (client == null)
            //为OkHttpClient添加拦截器 增加自定义的Header
            client = new OkHttpClient.Builder()
                    .addInterceptor(new RequestInterceptor())
                    .build();
        return client;
    }

    /**
     * Request 拦截器
     */
    private static class RequestInterceptor implements Interceptor {
        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            //拦截Request 可以从建构建request 从而增加必要的header
            Request newRequest = chain.request().newBuilder()
                    .addHeader("test", "testHeader")
                    .build();

            return chain.proceed(newRequest);
        }
    }
}
