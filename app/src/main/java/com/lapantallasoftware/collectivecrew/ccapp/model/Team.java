package com.lapantallasoftware.collectivecrew.ccapp.model;

/**
 * Created by AbrWin on 15/04/17.
 */

public class Team {
    private String title;
    private String synopsis;
    private int dislike;
    private int like;
    private Producction team;
    private int view;
    private String url_video;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public Producction getTeam() {
        return team;
    }

    public void setTeam(Producction team) {
        this.team = team;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public String getUrl_video() {
        return url_video;
    }

    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }
}
