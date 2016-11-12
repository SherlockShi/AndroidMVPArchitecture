package com.sherlockshi.androidmvparchitecture.global;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogTool;
import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Author: SherlockShi
 * Date:   2016-10-26 10:59
 * Description:
 */

public class App extends Application {

    public static Context mContext;

    @Override public void onCreate() {
        super.onCreate();

        mContext = this;

        //Stetho.initializeWithDefaults(this);

        initLogger();
    }

    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Logger.init("AndroidMVPArchitecture")   // default PRETTYLOGGER or use just init()
                    .methodCount(3)                 // default 2
                    .hideThreadInfo()               // default shown
                    .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                    .methodOffset(0)                // default 0
                    .logTool(new AndroidLogTool()); // custom log tool, optional
        } else {
            Logger.init("AndroidMVPArchitecture")   // default PRETTYLOGGER or use just init()
                    .methodCount(3)                 // default 2
                    .hideThreadInfo()               // default shown
                    .logLevel(LogLevel.NONE)        // default LogLevel.FULL
                    .methodOffset(0)                // default 0
                    .logTool(new AndroidLogTool()); // custom log tool, optional
        }
    }
}
