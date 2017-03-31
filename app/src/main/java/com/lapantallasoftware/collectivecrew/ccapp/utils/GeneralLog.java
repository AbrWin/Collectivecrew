package com.lapantallasoftware.collectivecrew.ccapp.utils;
import android.text.TextUtils;
import android.util.Log;

import com.lapantallasoftware.collectivecrew.BuildConfig;

/**
 * Created by AbrWin on 30/03/17.
 */

public class GeneralLog {
    private static final String LOG_FORMAT = "%1$s\n%2$s";
    private static String LOG_TAG = "Collective Crew";
    private static boolean LOG_ENABLED = false;

    public static void initLog(){
        LOG_ENABLED = BuildConfig.DEBUG;
    }

    public static void d(String TAG, String message, Object... args) {
        log(TAG, Log.DEBUG, null, message, args);
    }

    public static void i(String TAG, String message, Object... args) {
        log(TAG, Log.INFO, null, message, args);
    }

    public static void w(String TAG, String message, Object... args) {
        log(TAG, Log.WARN, null, message, args);
    }

    public static void e(String TAG, String message, Object... args) {
        log(TAG, Log.ERROR, null, message, args);
    }

    /**
     * General call
     * @param tag
     * @param priority
     * @param ex
     * @param message
     * @param args
     */
    private static void log(String tag, int priority, Throwable ex, String message, Object... args){
        if(LOG_ENABLED){
            if(TextUtils.isEmpty(tag)){
                tag = LOG_TAG;
            }

            if(args != null && args.length > 0){
                message = String.format(message, args);
            }
            String log;
            if (ex == null) {
                log = message;
            } else {
                String logMessage = message == null ? ex.getMessage() : message;
                String logBody = Log.getStackTraceString(ex);
                log = String.format(LOG_FORMAT, logMessage, logBody);
            }
            Log.println(priority, tag, log);

        }
    }
}
