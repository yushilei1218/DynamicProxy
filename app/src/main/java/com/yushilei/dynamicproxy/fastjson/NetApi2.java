package com.yushilei.dynamicproxy.fastjson;

import com.yushilei.dynamicproxy.bean.Tabs;
import com.yushilei.dynamicproxy.bean.User;
import com.yushilei.dynamicproxy.net.Client;
import com.yushilei.dynamicproxy.net.Req;
import com.yushilei.dynamicproxy.net.Res;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @auther by yushilei.
 * @time 2017/6/29-10:44
 * @desc
 */


public class NetApi2 {
    private NetApi2() {
    }

    //喜马拉雅听书网络接口
    //http://mobile.ximalaya.com/mobile/discovery/v2/tabs?device=android&version=6.3.6
//http://adse.ximalaya.com/ting/home?device=android&name=titlebar_middle_bottom&version=6.3.6&xt=1498704428922
    private static final String BASE_URL = "http://adse.ximalaya.com";

    public static Api api;

    static {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(FastJsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(Client.getClient())
                .build();

        //这里用到了接口动态代理实现技术
        api = retrofit.create(Api.class);
    }

    /**
     * 网络请求方法封装
     */
    public interface Api {
        @GET("/ting/home?device=android&name=titlebar_middle_bottom&version=6.3.6&xt=1498704428922")
        Call<XmlyHome> getHome();
    }
}

