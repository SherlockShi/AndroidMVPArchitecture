package com.sherlockshi.androidmvparchitecture.util.retrofit;

import com.sherlockshi.androidmvparchitecture.global.Config;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: SherlockShi
 * Date:   2016-10-26 11:08
 * Description:
 */

public enum RetrofitClient {

    INSTANCE;

    private final Retrofit retrofit;

    RetrofitClient() {
        retrofit = new Retrofit.Builder()
                //设置OKHttpClient
                .client(OkHttpFactory.INSTANCE.getOkHttpClient())
                //baseUrl
                .baseUrl(Config.BASE_URL)
                //gson转化器
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
