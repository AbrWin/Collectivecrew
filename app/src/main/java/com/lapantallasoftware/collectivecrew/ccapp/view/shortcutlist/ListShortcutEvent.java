package com.lapantallasoftware.collectivecrew.ccapp.view.shortcutlist;

import com.lapantallasoftware.collectivecrew.ccapp.model.Team;

import java.util.List;

/**
 * Created by AbrWin on 14/04/17.
 */

class ListShortcutEvent {

    public final static int onBeUserResolvableError = 1;
    public final static int onGooglePlayServicesFailed = 2;
    public final static int onGeneralError = 3;
    public final static int onValuesList = 4;
    public final static int onEmptyList = 5;


    private int eventType;
    private int statusCode;
    private String errorMsj;
    private List<Team> teamList;

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMsj() {
        return errorMsj;
    }

    public void setErrorMsj(String errorMsj) {
        this.errorMsj = errorMsj;
    }
}
