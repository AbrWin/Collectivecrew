package com.lapantallasoftware.collectivecrew.ccapp.view.shortcutlist;

import android.text.TextUtils;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.lapantallasoftware.collectivecrew.ccapp.application.MyApplication;
import com.lapantallasoftware.collectivecrew.ccapp.helper.FirebaseHelper;
import com.lapantallasoftware.collectivecrew.ccapp.helper.GreenRoboEventBus;
import com.lapantallasoftware.collectivecrew.ccapp.model.Team;
import com.lapantallasoftware.collectivecrew.ccapp.utils.Connectivity;
import com.lapantallasoftware.collectivecrew.ccapp.utils.GeneralLog;

import java.util.List;

/**
 * Created by AbrWin on 14/04/17.
 */

public class ListshortRepositoryImp implements ListShortcutMVP.ListShortRepository {
    private final String TAG = ListshortRepositoryImp.class.getSimpleName();
    private final String TEAM_KEY = "team";
    private FirebaseDatabase database;
    private GreenRoboEventBus eventBus;

    public ListshortRepositoryImp() {
        this.database = FirebaseHelper.getInstance().getDatabaseReference();
        this.eventBus = GreenRoboEventBus.getInstance();
    }

    @Override
    public void shortlistContactLisctEvent() {

    }

    @Override
    public void unshortlistContactLisctEvent() {

    }

    @Override
    public void destroyListener() {

    }

    @Override
    public void getValues() {
        //Check status Connection
        if (!Connectivity.isOnline(MyApplication.getCtx())) {
            eventBus.post(ListShortcutEvent.onGeneralError);
        } else if (!isGooglePlayServicesAvaliable()) {
            return;
        } else {
            getListTeams();
        }
    }

    private boolean isGooglePlayServicesAvaliable() {
        int statusCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MyApplication.getCtx());
        if (GoogleApiAvailability.getInstance().isUserResolvableError(statusCode)) {
            postEvent(ListShortcutEvent.onBeUserResolvableError, statusCode);
            return false;
        } else if (statusCode != ConnectionResult.SUCCESS) {
            postEvent(ListShortcutEvent.onGooglePlayServicesFailed);
            return false;
        }
        return true;
    }

    private void postEvent(int type) {
        postEvent(type, "");

    }

    private void postEvent(int type, String errorMsj) {
        ListShortcutEvent shortcutEvent = new ListShortcutEvent();
        shortcutEvent.setEventType(type);
        if (!TextUtils.isEmpty(errorMsj)) {
            shortcutEvent.setErrorMsj(errorMsj);
        }
        eventBus.post(shortcutEvent);
    }

    private void postEvent(int type, int statuscode) {
        ListShortcutEvent listShortcutEvent = new ListShortcutEvent();
        listShortcutEvent.setEventType(type);
        listShortcutEvent.setStatusCode(statuscode);
        eventBus.post(listShortcutEvent);
    }

    private void postEvent(int type, List<Team> teamList){
        ListShortcutEvent listShortcutEvent = new ListShortcutEvent();
        listShortcutEvent.setEventType(type);
        listShortcutEvent.setTeamList(teamList);
        eventBus.post(listShortcutEvent);
    }

    private void getListTeams() {
        database.getReference(TEAM_KEY).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                GenericTypeIndicator<List<Team>> t = new GenericTypeIndicator<List<Team>>() {};
                List<Team> teamList = dataSnapshot.getValue(t);
                if(teamList != null && teamList.size() > 0){
                    postEvent(ListShortcutEvent.onValuesList, teamList);
                }else {
                    //TODO SEND GENERIAL ERROR
                }
                Log.d("VALUE-->",teamList.get(0).getTeam().getProducer());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                GeneralLog.e(TAG, databaseError.getMessage());
            }
        });
    }
}
