package com.lapantallasoftware.collectivecrew.ccapp.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.GoogleApiAvailability;
import com.lapantallasoftware.collectivecrew.R;
import com.lapantallasoftware.collectivecrew.ccapp.adapter.ShortcutAdapter;
import com.lapantallasoftware.collectivecrew.ccapp.model.Team;
import com.lapantallasoftware.collectivecrew.ccapp.view.shortcutlist.ListShortcutMVP;
import com.lapantallasoftware.collectivecrew.ccapp.view.shortcutlist.ListShortcutPresenterImp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ViewShortcutList extends ViewCommon implements ListShortcutMVP.View, ShortcutAdapter.onItemClickListener {
    private ListShortcutPresenterImp presenter;
    private ShortcutAdapter shortcutAdapter;
    public final int REQUEST_GOOGLE_PLAY_SERVICES = 1;

    @Nullable
    @BindView(R.id.recyclerShortCut)
    public RecyclerView recyclerListShortcut;

    @Nullable
    @BindView(R.id.progressBar)
    public ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.view_shortcut_list, container, false);
        ButterKnife.bind(this, rootView);
        presenter = new ListShortcutPresenterImp(this);
        presenter.onCreate();
        presenter.getListValues();
        return rootView;
    }

    @Override
    public void showToastErrr(String error) {
        showToastError(error);
    }

    @Override
    public void showloading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showEmptylist() {

    }

    @Override
    public void showGooglePlayServicesError() {
        showToastError(getString(R.string.error_playservices));
    }

    @Override
    public void showGooglePlayServicesDialog(int statusCode) {
        showPlayServicesErrorDialog(statusCode);
    }

    @Override
    public void getListValues(List<Team> values) {
        if (values != null & values.size() > 0) {
            recyclerListShortcut.setVisibility(View.VISIBLE);
            shortcutAdapter = new ShortcutAdapter(values, this);
            recyclerListShortcut.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerListShortcut.setAdapter(shortcutAdapter);
            shortcutAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(ShortcutAdapter.ShortListholder shortListholder) {
        Log.d("VALUE-->", String.valueOf(shortListholder.getAdapterPosition()));
    }

    private void showToastError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    private void showPlayServicesErrorDialog(int codeError) {
        if (GoogleApiAvailability.getInstance().getErrorDialog(activity, codeError, REQUEST_GOOGLE_PLAY_SERVICES) != null) {
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(activity, codeError, REQUEST_GOOGLE_PLAY_SERVICES);
            dialog.show();
        }
    }
}
