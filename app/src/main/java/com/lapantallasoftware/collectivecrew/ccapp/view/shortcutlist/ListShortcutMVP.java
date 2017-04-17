package com.lapantallasoftware.collectivecrew.ccapp.view.shortcutlist;

import com.lapantallasoftware.collectivecrew.ccapp.model.Team;
import java.util.List;

/**
 * Created by AbrWin on 14/04/17.
 */

public class ListShortcutMVP {
    public interface View {
        void showloading(boolean show);

        void showToastErrr(String error);

        void showEmptylist();

        void showGooglePlayServicesError();

        void showGooglePlayServicesDialog(int statusCode);

        void getListValues(List<Team> values);
    }

    public interface Presenter {
        void onCreate();

        void onDestroy();

        void onPause();

        void onResume();

        void onEventMainThread(ListShortcutEvent event);

        void getListValues();
    }

    public interface ListShortcutInteractor {
        void shortlistContactLisctEvent();

        void unshortlistContactLisctEvent();

        void destroyListener();

        void getValues();
    }

    public interface ListShortRepository {
        void shortlistContactLisctEvent();

        void unshortlistContactLisctEvent();

        void destroyListener();

        void getValues();
    }


}
