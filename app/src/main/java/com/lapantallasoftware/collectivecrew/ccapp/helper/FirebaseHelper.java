package com.lapantallasoftware.collectivecrew.ccapp.helper;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

/**
 * Created by AbrWin on 14/04/17.
 */

public class FirebaseHelper {
    private FirebaseDatabase database;
    private FirebaseStorage dataStorage;

    public static class SingletonHolder {
        public static final FirebaseHelper INSTANCE = new FirebaseHelper();
    }

    public static FirebaseHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public FirebaseHelper() {
        this.database = FirebaseDatabase.getInstance();
        this.dataStorage = FirebaseStorage.getInstance();
    }

    public FirebaseDatabase getDatabaseReference() {
        return database;
    }

    public FirebaseStorage getDataStorageRefecence(){
        return dataStorage;
    }
}
