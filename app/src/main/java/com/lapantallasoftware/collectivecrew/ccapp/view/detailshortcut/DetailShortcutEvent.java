package com.lapantallasoftware.collectivecrew.ccapp.view.detailshortcut;

/**
 * Created by AbrWin on 02/05/17.
 */

public class DetailShortcutEvent {
    public static final int onErrorDataBase = 0;

    private int eventType;
    private String errorMsj;

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getErrorMsj() {
        return errorMsj;
    }

    public void setErrorMsj(String errorMsj) {
        this.errorMsj = errorMsj;
    }
}
