package com.yushilei.dynamicproxy;


import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yushilei.dynamicproxy.bean.Tabs;
import com.yushilei.dynamicproxy.bean.User;
import com.yushilei.dynamicproxy.interf.InterfApi;
import com.yushilei.dynamicproxy.net.NetApi;
import com.yushilei.dynamicproxy.net.Res;
import com.yushilei.dynamicproxy.proxy.MyAnnotation;
import com.yushilei.dynamicproxy.util.JsonUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

    }

    /**
     * Android 接口动态代理实现
     * <p>
     * 借助Android 提供的Proxy 和InvocationHandler 类来实现动态代理
     *
     * @param view
     */
    public void androidProxy(View view) {

        InterfApi api = (InterfApi) Proxy.newProxyInstance(this.getClassLoader()
                , new Class[]{InterfApi.class}
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        Log.i(TAG, "Method name=" + name);
                        POST annotation = method.getAnnotation(POST.class);

                        Object user = User.class.getDeclaredConstructors()[0].newInstance();

                        Field name1 = User.class.getDeclaredField("name");
                        name1.setAccessible(true);
                        name1.set(user, args[0]);

                        Field psw = User.class.getDeclaredField("psw");
                        psw.setAccessible(true);
                        psw.set(user, args[1]);

                        return user;
                    }
                });
        User user = api.getUser("yushilei", "psw");
        Log.i(TAG, user.toString());

    }

    /**
     * 请求喜马拉雅网络接口 btn 事件处理
     */
    public void netRequest(View view) {
        //创建网络请求的 retrofit2 call
        Call<Res<Tabs>> call = NetApi.api.getTabs("android", "6.3.6");

        //发起异步网络请求 callback回调方法运行在主线程
        call.enqueue(new Callback<Res<Tabs>>() {
            @Override
            public void onResponse(@NonNull Call<Res<Tabs>> call, @NonNull Response<Res<Tabs>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    tv.setText(JsonUtil.toJson(response.body()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Res<Tabs>> call, @NonNull Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 普通的代理模式
     */
    public void normalProxy(View view) {
        com.yushilei.dynamicproxy.proxy.Proxy proxy = new com.yushilei.dynamicproxy.proxy.Proxy(
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String name = method.getName();
                        Annotation[] annotations = method.getAnnotations();
                        Log.i(TAG, "proxy =" + proxy.toString());
                        Log.i(TAG, "method =" + name);
                        for (Annotation a : annotations) {
                            if (a instanceof MyAnnotation) {
                                Log.i(TAG, "Annotation =" + a.toString());
                                Log.i(TAG, "Annotation value=" + ((MyAnnotation) a).value());
                            }
                        }
                        for (Object obj : args) {
                            Log.i(TAG, "args =" + obj.toString());
                        }
                        return new User((String) args[0], (String) args[1]);
                    }
                });

        User user = proxy.addUser("普通代理name", "普通代理psw");
        Log.i(TAG, user.toString());
    }
}
