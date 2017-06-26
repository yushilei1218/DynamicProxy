package com.yushilei.dynamicproxy.net;

import com.yushilei.dynamicproxy.bean.Tabs;
import com.yushilei.dynamicproxy.bean.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @auther by yushilei.
 * @time 2017/6/22-11:34
 * @desc API
 */

/**
 * Retrofit2 网络封装
 */
public class NetApi {
    private NetApi() {
    }
    //喜马拉雅听书网络接口
    //http://mobile.ximalaya.com/mobile/discovery/v2/tabs?device=android&version=6.3.6

    private static final String BASE_URL = "http://mobile.ximalaya.com";

    public static Api api;

    static {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
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
        @GET("/mobile/discovery/v2/tabs")
        Call<Res<Tabs>> getTabs(@Query("device") String device, @Query("version") String version);

        @POST("/path")
        Call<Res<User>> getUser(@Body Req req);
    }
    /**
     *    下面是一些例子
     @GET("users/{username}")
     Call<User> getUser(@Path("username") String username,@Header("Cache-Control") int maxAge);

     @Headers({"Cache-Control: max-age=640000", "User-Agent: My-App-Name"})//note2
     @POST("users/new")
     Call<User> createUser(@Body User user,@Query("sort") String sort);  //user支持被gson序列化的一个类，如JavaBean

     @FormUrlEncoded
     @POST("some/endpoint")
     Call<SomeResponse> someEndpoint(@FieldMap Map<String, String> names);

     @POST("https://blog.csdn.net/") //note3
     Call<Response<User>> getUser(@Query("name") String name);

     @Multipart  //note4
     @POST("some/endpoint")
     Call<Response> uploadImage(@Part("description") String description, @Part("image") RequestBody image)

     @GET("users/{username}") //note5
     void getUser(@Path("username") String username, Callback<User> cb);
     */

}
