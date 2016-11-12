package com.sherlockshi.androidmvparchitecture.business.cook_detail;

import android.content.Context;

import com.sherlockshi.androidmvparchitecture.base.callback.Callback;
import com.sherlockshi.androidmvparchitecture.business.entity.CookDetail;
import com.sherlockshi.androidmvparchitecture.util.ErrorUtil;

/**
 * Author: SherlockShi
 * Date:   2016-11-02 21:02
 * Description:
 */

public class CookDetailPresenter implements CookDetailContract.IPresenter {

    private Context mContext;
    private CookDetailContract.IView mView;
    private CookDetailManager mCookDetailManager = CookDetailManager.getInstance();

    public CookDetailPresenter(Context context, CookDetailContract.IView view) {
        this.mContext = context;
        this.mView = view;
    }

    @Override
    public void getCookDetail(String apikey, String id) {
        mView.showLoading();

        mCookDetailManager.getCookDetail(apikey, id, new Callback<CookDetail>() {
            @Override
            public void onSuccess(CookDetail object) {
                mView.updateCookDetail(object);
                mView.hideLoading();
            }

            @Override
            public void onFail(int errorNo, String errorMsg) {
                ErrorUtil.processErrorMessage(mContext, errorNo, errorMsg, mView);
                mView.hideLoading();
            }
        });
    }
}
