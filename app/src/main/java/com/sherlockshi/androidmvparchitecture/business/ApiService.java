package com.sherlockshi.androidmvparchitecture.business;


import com.sherlockshi.androidmvparchitecture.business.entity.CookDetail;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author: SherlockShi
 * Date:   2016-10-26 11:11
 * Description:
 */

public interface ApiService {

    // 菜谱详情
    @GET("show")
    Observable<CookDetail> getCookDetail(@Header("apikey") String apikey,
                                       @Query("id")  String id);

}
