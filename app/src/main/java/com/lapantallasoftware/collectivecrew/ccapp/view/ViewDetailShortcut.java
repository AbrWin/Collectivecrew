package com.lapantallasoftware.collectivecrew.ccapp.view;


import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.lapantallasoftware.collectivecrew.R;
import com.lapantallasoftware.collectivecrew.activity.MainActivity;
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

    @Nullable
    @BindView(R.id.director_name)
    public TextView directorName;

    @Nullable
    @BindView(R.id.producer_name)
    public TextView producerName;

    @Nullable
    @BindView(R.id.photo_name)
    public TextView photoName;

    @Nullable
    @BindView(R.id.sound_name)
    public TextView soungName;

    @Nullable
    @BindView(R.id.edition_name)
    public TextView editionName;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.view_detail_shortcut, container, false);
        String reference = getString(R.string.bucket);
        ((MainActivity)getActivity()).setTitleToolbar("");
        ((MainActivity)getActivity()).showBackBtn(true);
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ButterKnife.bind(this, rootView);
        if (getArguments() != null) {
            //Text
            Team teamElement = (Team) getArguments().getSerializable("teamValue");
            title_detail.setText(getInfoText(teamElement.getTitle()));
            subtitle_detail.setText(getInfoText(teamElement.getTeam_name()));
            synopsis_content.setText(getInfoText(teamElement.getSynopsis()));
            like_txt.setText(getInfoText(String.valueOf(teamElement.getLike())));
            deslike_txt.setText(getInfoText(String.valueOf(teamElement.getDislike())));
            views_txt.setText(getInfoText(String.valueOf(teamElement.getView())));
            directorName.setText(getInfoText(teamElement.getTeam().getDirector()));
            producerName.setText(getInfoText(teamElement.getTeam().getPhotographer()));
            photoName.setText(getInfoText(teamElement.getTeam().getPhotographer()));
            soungName.setText(getInfoText(teamElement.getTeam().getSound()));
            editionName.setText(getInfoText(teamElement.getTeam().getEdition()));

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

    private String getInfoText(String infoText) {
        return !TextUtils.isEmpty(infoText) ? infoText : "";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
