package com.lapantallasoftware.collectivecrew.ccapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.lapantallasoftware.collectivecrew.R;
import com.lapantallasoftware.collectivecrew.ccapp.helper.FirebaseHelper;
import com.lapantallasoftware.collectivecrew.ccapp.model.Team;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by AbrWin on 16/04/17.
 */

public class ShortcutAdapter extends RecyclerView.Adapter<ShortcutAdapter.ShortListholder> {
    private List<Team> teamList;
    private onItemClickListener listener;

    public ShortcutAdapter(List<Team> teamList, onItemClickListener listener) {
        this.teamList = teamList;
        this.listener = listener;
    }

    @Override
    public ShortListholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shortcut, parent, false);
        return new ShortListholder(view);
    }

    @Override
    public void onBindViewHolder(final ShortListholder holder, int position) {
        holder.team = teamList.get(position);
        final Context context = holder.itemView.getContext();
        holder.title_short.setText(getInfoText(holder.team.getTitle()));
        holder.subtitle_short.setText(getInfoText(holder.team.getTeam_name()));
        holder.synopsis.setText(getInfoText(holder.team.getSynopsis()));

        String reference = context.getString(R.string.bucket);
        FirebaseHelper.getInstance().getDataStorageRefecence().getReferenceFromUrl(reference).child(getInfoText(holder.team.getUrl_img())).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                if (!TextUtils.isEmpty(uri.toString())) {
                    Picasso.with(context).load(uri.toString()).into(holder.img_video);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamList != null && teamList.size() > 0 ? teamList.size() : 0;
    }

    public class ShortListholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Nullable
        @BindView(R.id.title_short)
        public TextView title_short;

        @Nullable
        @BindView(R.id.subtitle_short)
        public TextView subtitle_short;

        @Nullable
        @BindView(R.id.synopsis)
        public TextView synopsis;

        @BindView(R.id.img_video)
        public ImageView img_video;

        public Team team;

        public ShortListholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(this);
        }
    }

    public interface onItemClickListener {
        void onClick(ShortListholder shortListholder);
    }

    private String getInfoText(String infoText) {
        return !TextUtils.isEmpty(infoText) ? infoText : "";
    }
}
