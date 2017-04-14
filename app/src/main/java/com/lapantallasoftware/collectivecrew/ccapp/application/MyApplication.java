package com.lapantallasoftware.collectivecrew.ccapp.application;

import android.app.Application;
import android.content.Context;

import com.lapantallasoftware.collectivecrew.ccapp.utils.GeneralLog;

/**
 * Created by AbrWin on 30/03/17.
 */

public class MyApplication extends Application {
    private static Context ctx;

    @Override
    public void onCreate() {
        super.onCreate();
        GeneralLog.initLog();
        this.setCtx(getApplicationContext());
    }

    public static Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }
}
