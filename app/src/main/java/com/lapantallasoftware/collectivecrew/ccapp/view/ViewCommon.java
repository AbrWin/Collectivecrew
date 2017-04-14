package com.lapantallasoftware.collectivecrew.ccapp.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.lapantallasoftware.collectivecrew.activity.MainActivity;

/**
 * Created by AbrWin on 14/04/17.
 */

public abstract class ViewCommon extends Fragment {

    protected Context context;
    protected Activity activity;
    public View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
        this.context = activity.getApplicationContext();
        ((MainActivity)this.activity).setActualFragment(this);
    }

    public View getRootView() {
        return rootView;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    public void getFragment(){
        ((MainActivity)this.activity).getActualFragment();
    }
}
