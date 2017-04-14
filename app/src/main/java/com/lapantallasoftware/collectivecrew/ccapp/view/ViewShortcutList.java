package com.lapantallasoftware.collectivecrew.ccapp.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lapantallasoftware.collectivecrew.R;


public class ViewShortcutList extends ViewCommon {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.view_shortcut_list, container, false);
        return rootView;
    }
}
