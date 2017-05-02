package com.lapantallasoftware.collectivecrew.ccapp.view.detailshortcut;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.lapantallasoftware.collectivecrew.ccapp.application.MyApplication;
import com.lapantallasoftware.collectivecrew.ccapp.helper.FirebaseHelper;
import com.lapantallasoftware.collectivecrew.ccapp.helper.GreenRoboEventBus;
import com.lapantallasoftware.collectivecrew.ccapp.utils.Connectivity;
import com.lapantallasoftware.collectivecrew.ccapp.utils.GeneralLog;

/**
 * Created by AbrWin on 02/05/17.
 */

public class DetailShortcutRepositoryImp implements DetailShortcutMVP.DetailShortcutRepository {
    private final String TAG = DetailShortcutRepositoryImp.class.getSimpleName();
    private final String TEAM_KEY = "team";
    private final String NUMBER_VIEWS = "view";
    private FirebaseDatabase database;
    private GreenRoboEventBus eventBus;

    public DetailShortcutRepositoryImp() {
        this.database = FirebaseHelper.getInstance().getDatabaseReference();
        this.eventBus = GreenRoboEventBus.getInstance();
    }

    @Override
    public void registerViewsDB(int positionElement) {
        if (Connectivity.isOnline(MyApplication.getCtx())) {
            StringBuilder reference = new StringBuilder();
            String position = String.valueOf(positionElement);

            reference.append(TEAM_KEY).append("/").append(position).append("/").append(NUMBER_VIEWS);
            final Query query = database.getReference(reference.toString());
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    int numViews = Integer.parseInt(dataSnapshot.getValue().toString()) + 1;
                    dataSnapshot.getRef().setValue(numViews);
                    GeneralLog.d(TAG, "onDataChange: DATAVIEW ->" + dataSnapshot.getValue().toString());
                    query.removeEventListener(this);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    query.removeEventListener(this);
                    postEvent(DetailShortcutEvent.onErrorDataBase);
                    GeneralLog.d(TAG, "DatabaseError" + databaseError.getMessage());
                }
            });
        }
    }

    private void postEvent(int type) {
        DetailShortcutEvent event = new DetailShortcutEvent();
        event.setEventType(type);
        eventBus.post(event);
    }
}
