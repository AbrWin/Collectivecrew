package com.lapantallasoftware.collectivecrew.ccapp.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lapantallasoftware.collectivecrew.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewDetailShortcut extends Fragment {


    public ViewDetailShortcut() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.view_detail_shortcut, container, false);
    }

}
