package com.sherlockshi.androidmvparchitecture.util;

import android.content.Context;

import com.sherlockshi.androidmvparchitecture.R;
import com.sherlockshi.androidmvparchitecture.base.view.IBaseView;
import com.sherlockshi.androidmvparchitecture.global.Constants;

/**
 * Author: SherlockShi
 * Date:   2016-10-30 22:46
 * Description:
 */

public class ErrorUtil {

    public static void processErrorMessage(Context context, int errorNo, String errorMsg, IBaseView view) {
        if (view == null) {
            return;
        }

        if (Constants.ErrorNo.ServerError == errorNo) {
            view.showMessage(context.getString(R.string.server_error_request_fail_please_retry_later));
        } else if (Constants.ErrorNo.ServerReturnErrorMsg == errorNo) {
            view.showMessage(errorMsg);
        }
    }
}
