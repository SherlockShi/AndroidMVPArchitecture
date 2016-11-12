package com.sherlockshi.androidmvparchitecture.business.cook_detail;

import com.sherlockshi.androidmvparchitecture.base.callback.Callback;
import com.sherlockshi.androidmvparchitecture.util.retrofit.RetrofitClient;
import com.sherlockshi.androidmvparchitecture.business.ApiService;
import com.sherlockshi.androidmvparchitecture.business.entity.CookDetail;
import com.sherlockshi.androidmvparchitecture.global.Constants;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author: SherlockShi
 * Date:   2016-11-02 20:47
 * Description:
 */

public class CookDetailManager {

    private volatile static CookDetailManager instance;

    private CookDetailManager() {
    }

    public static CookDetailManager getInstance() {
        if (instance == null) {
            synchronized (CookDetailManager.class) {
                if (instance == null) {
                    instance = new CookDetailManager();
                }
            }
        }
        return instance;
    }
    
    public void getCookDetail(String apikey, String id, final Callback<CookDetail> callback) {
        if (callback == null) {
            return;
        }

        Retrofit retrofit = RetrofitClient.INSTANCE.getRetrofit();
        ApiService apiService = retrofit.create(ApiService.class);

        Observable<CookDetail> observable = apiService.getCookDetail(apikey, id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CookDetail>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFail(Constants.ErrorNo.ServerError, "");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CookDetail respEntity) {
                        callback.onSuccess(respEntity);
                    }
                });
    }
}
