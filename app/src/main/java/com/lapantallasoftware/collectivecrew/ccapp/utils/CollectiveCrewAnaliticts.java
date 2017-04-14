package com.lapantallasoftware.collectivecrew.ccapp.utils;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.lapantallasoftware.collectivecrew.ccapp.application.MyApplication;

import static android.R.attr.id;

/**
 * Created by AbrWin on 02/04/17.
 */

public class CollectiveCrewAnaliticts {
    private static FirebaseAnalytics mFirebaseAnalytics;

    public static void sendAnaliticsEvent(String id, String name, String type){
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(MyApplication.getCtx());
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, type);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

}
