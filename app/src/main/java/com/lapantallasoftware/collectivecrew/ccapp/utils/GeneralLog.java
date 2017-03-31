package com.lapantallasoftware.collectivecrew.ccapp.utils;

import com.lapantallasoftware.collectivecrew.BuildConfig;

/**
 * Created by AbrWin on 30/03/17.
 */

public class GeneralLog {
    private String LOG_TAG = "Collective Crew";
    private static boolean LOG_ENABLED = false;

    public static void initLog(){
        LOG_ENABLED = BuildConfig.DEBUG;
    }

    public GeneralLog() {
    }
}
