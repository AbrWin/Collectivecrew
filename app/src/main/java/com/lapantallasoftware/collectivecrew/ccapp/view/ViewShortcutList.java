package com.lapantallasoftware.collectivecrew.ccapp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lapantallasoftware.collectivecrew.R;
import com.lapantallasoftware.collectivecrew.ccapp.model.Team;
import com.lapantallasoftware.collectivecrew.ccapp.view.shortcutlist.ListShortcutMVP;
import com.lapantallasoftware.collectivecrew.ccapp.view.shortcutlist.ListShortcutPresenterImp;
import java.util.List;


public class ViewShortcutList extends ViewCommon implements ListShortcutMVP.View {

    private ListShortcutPresenterImp presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.view_shortcut_list, container, false);
        presenter = new ListShortcutPresenterImp(this);
        presenter.onCreate();
        presenter.getListValues();
        return rootView;
    }

    @Override
    public void showloading() {

    }

    @Override
    public void showEmptylist() {

    }

    @Override
    public void showGooglePlayServicesError() {

    }

    @Override
    public void showGooglePlayServicesDialog(int statusCode) {

    }

    @Override
    public void getListValues(List<Team> values) {
        Log.d("VALUE-->2", values.get(1).getTeam().getProducer());
    }
}
