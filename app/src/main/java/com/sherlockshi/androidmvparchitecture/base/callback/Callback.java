package com.sherlockshi.androidmvparchitecture.base.callback;

/**
 * Author: SherlockShi
 * Date:   2016-11-07 22:41
 * Description:
 */
public interface Callback<T> {

    // 失败回调
    void onFail(int errorNo, String errorMsg);

    // 成功回调
    void onSuccess(T t);
}
