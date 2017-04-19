package com.lapantallasoftware.collectivecrew.ccapp.view;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.lapantallasoftware.collectivecrew.R;
import com.lapantallasoftware.collectivecrew.ccapp.helper.FirebaseHelper;
import com.lapantallasoftware.collectivecrew.ccapp.model.Team;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Create by AbrWind =D
 */
public class ViewDetailShortcut extends ViewCommon {

    @Nullable
    @BindView(R.id.title_detail)
    public TextView title_detail;

    @Nullable
    @BindView(R.id.subtitle_detail)
    public TextView subtitle_detail;

    @Nullable
    @BindView(R.id.synopsis_content)
    public TextView synopsis_content;

    @Nullable
    @BindView(R.id.like_txt)
    public TextView like_txt;

    @Nullable
    @BindView(R.id.deslike_txt)
    public TextView deslike_txt;

    @Nullable
    @BindView(R.id.views_txt)
    public TextView views_txt;

    @Nullable
    @BindView(R.id.video_view)
    public VideoView videoView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.view_detail_shortcut, container, false);
        String reference = getString(R.string.bucket);

        ButterKnife.bind(this, rootView);
        if (getArguments() != null) {
            //Text
            Team teamElement = (Team) getArguments().getSerializable("teamValue");
            title_detail.setText(teamElement.getTitle());
            subtitle_detail.setText(teamElement.getTeam_name());
            synopsis_content.setText(teamElement.getSynopsis());
            like_txt.setText(String.valueOf(teamElement.getLike()));
            deslike_txt.setText(String.valueOf(teamElement.getDislike()));
            views_txt.setText(String.valueOf(teamElement.getView()));

            //Video
            FirebaseHelper.getInstance().getDataStorageRefecence().getReferenceFromUrl(reference).child(teamElement.getUrl_video()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    MediaController mediaController = new MediaController(getContext());
                    mediaController.setAnchorView(videoView);
                    videoView.setMediaController(mediaController);
                    videoView.setVideoURI(uri);
                    videoView.start();
                }
            });
        }
        return rootView;
    }

}
