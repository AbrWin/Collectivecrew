package com.lapantallasoftware.collectivecrew.ccapp.view.detailshortcut;


/**
 * Created by AbrWin on 02/05/17.
 */

public class DetailShortcutMVP {

    public interface View {
        void retryInfoView();
    }

    public interface Presenter {
        void onCreate();

        void onDestroy();

        void onEventMainThread(DetailShortcutEvent event);

        void registerViewsDB(int positionElement);
    }


    public interface DetailShortcutInteractor {
        void registerViewsDB(int positionElement);
    }

    public interface DetailShortcutRepository {
        void registerViewsDB(int positionElement);
    }
}
