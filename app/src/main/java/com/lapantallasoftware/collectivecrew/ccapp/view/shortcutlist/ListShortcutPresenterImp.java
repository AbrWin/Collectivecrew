package com.lapantallasoftware.collectivecrew.ccapp.view.shortcutlist;

import com.lapantallasoftware.collectivecrew.ccapp.helper.EventBus;
import com.lapantallasoftware.collectivecrew.ccapp.helper.GreenRoboEventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by AbrWin on 14/04/17.
 */

public class ListShortcutPresenterImp implements ListShortcutMVP.Presenter {
    private EventBus eventBus;
    private ListShortcutMVP.View shortView;
    private ListShortcutMVP.ListShortcutInteractor interactor;


    public ListShortcutPresenterImp(ListShortcutMVP.View shortView) {
        this.eventBus = GreenRoboEventBus.getInstance();
        this.shortView = shortView;
        this.interactor = new ListShortcutInteractorImp();
    }

    @Override
    public void getListValues() {
        interactor.getValues();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Subscribe
    @Override
    public void onEventMainThread(ListShortcutEvent event) {
        if (event != null) {
            switch (event.getEventType()) {
                case ListShortcutEvent.onValuesList:
                    if (shortView != null) {
                        shortView.showloading(false);
                        shortView.getListValues(event.getTeamList());
                    }
                    break;
                case ListShortcutEvent.onGeneralError:
                    if (shortView != null) {
                        shortView.showloading(false);
                        shortView.showEmptylist();
                    }
                    break;
                case ListShortcutEvent.onBeUserResolvableError:
                    if (shortView != null) {
                        shortView.showloading(false);
                        shortView.showGooglePlayServicesDialog(event.getStatusCode());
                    }
                    break;
                case ListShortcutEvent.onGooglePlayServicesFailed:
                    if (shortView != null) {
                        shortView.showloading(false);
                        shortView.showGooglePlayServicesError();
                    }
                    break;
                case ListShortcutEvent.onEmptyList:
                    if(shortView != null){
                        shortView.showloading(false);
                        shortView.showEmptylist();
                    }
            }
        }

    }
}
