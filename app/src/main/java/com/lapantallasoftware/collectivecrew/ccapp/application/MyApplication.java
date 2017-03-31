package com.lapantallasoftware.collectivecrew.ccapp.application;

import android.app.Application;

import com.lapantallasoftware.collectivecrew.ccapp.utils.GeneralLog;

/**
 * Created by AbrWin on 30/03/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GeneralLog.initLog();
    }
}
