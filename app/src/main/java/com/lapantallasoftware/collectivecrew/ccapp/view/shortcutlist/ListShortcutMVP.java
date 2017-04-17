package com.lapantallasoftware.collectivecrew.ccapp.view.shortcutlist;

import com.lapantallasoftware.collectivecrew.ccapp.model.Team;

import java.util.List;

/**
 * Created by AbrWin on 14/04/17.
 */

public class ListShortcutMVP {
    public interface View {
        void showloading(boolean show);

        void showToastError(String error);

        void showEmptylist();

        void showGooglePlayServicesDialog(int statusCode);

        void getListValues(List<Team> values);
    }

    public interface Presenter {
        void onCreate();

        void onDestroy();

        void onEventMainThread(ListShortcutEvent event);

        void getListValues();
    }

    public interface ListShortcutInteractor {
        void getValues();
    }

    public interface ListShortRepository {
        void getValues();
    }


}
