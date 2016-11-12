package com.sherlockshi.androidmvparchitecture.business.cook_detail;

import com.sherlockshi.androidmvparchitecture.base.presenter.IBasePresenter;
import com.sherlockshi.androidmvparchitecture.base.view.IBaseView;
import com.sherlockshi.androidmvparchitecture.business.entity.CookDetail;

/**
 * Author: SherlockShi
 * Date:   2016-11-02 20:45
 * Description:
 */

public interface CookDetailContract {

    interface IView extends IBaseView {
        void updateCookDetail(CookDetail cookDetail);
    }

    interface IPresenter extends IBasePresenter {
        void getCookDetail(String apikey, String id);
    }
}
