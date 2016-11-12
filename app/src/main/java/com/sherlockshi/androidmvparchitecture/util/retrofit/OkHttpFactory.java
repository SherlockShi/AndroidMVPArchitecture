package com.sherlockshi.androidmvparchitecture.util.retrofit;

import com.sherlockshi.androidmvparchitecture.global.App;
import com.sherlockshi.androidmvparchitecture.util.retrofit.interceptor.UserAgentInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author: SherlockShi
 * Date:   2016-10-26 10:44
 * Description: OkHttpClient工厂类
 */

public enum OkHttpFactory {
    INSTANCE;

    private final OkHttpClient okHttpClient;
    private static final int TIMEOUT_READ = 20;
    private static final int TIMEOUT_CONNECTION = 20;

    OkHttpFactory() {
        // 打印请求Log
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 缓存目录
        Cache cache = new Cache(App.mContext.getCacheDir(), 10 * 1024 * 1024);

        okHttpClient = new OkHttpClient.Builder()
                //打印请求log
                .addInterceptor(httpLoggingInterceptor)

                //stetho,可以在chrome中查看请求
                //.addNetworkInterceptor(new StethoInterceptor())

                //添加UA
                .addInterceptor(new UserAgentInterceptor(HttpHelper.getUserAgent()))

                //必须是设置Cache目录
                //.cache(cache)

                //走缓存
                //.addInterceptor(new OnOffLineCachedInterceptor())
                //.addNetworkInterceptor(new OnOffLineCachedInterceptor())

                //失败重连
                .retryOnConnectionFailure(true)

                //time out
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)

                .build();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
