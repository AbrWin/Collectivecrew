package com.lapantallasoftware.collectivecrew.ccapp.view.detailshortcut;

import com.lapantallasoftware.collectivecrew.ccapp.helper.EventBus;
import com.lapantallasoftware.collectivecrew.ccapp.helper.GreenRoboEventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by AbrWin on 02/05/17.
 */

public class DetailShortcutPresenterImp implements DetailShortcutMVP.Presenter {
    private EventBus eventBus;
    private DetailShortcutMVP.View viewDetail;
    private DetailShortcutMVP.DetailShortcutInteractor interactor;

    public DetailShortcutPresenterImp(DetailShortcutMVP.View viewDetails) {
        this.eventBus = GreenRoboEventBus.getInstance();
        this.viewDetail = viewDetails;
        this.interactor = new DetailShortcutInteractorImp();
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        eventBus.unregister(this);
    }

    @Subscribe
    @Override
    public void onEventMainThread(DetailShortcutEvent event) {
        if (event != null) {
            switch (event.getEventType()) {
                case DetailShortcutEvent.onErrorDataBase:
                    viewDetail.retryInfoView();
                    break;
            }
        }
    }

    @Override
    public void registerViewsDB(int positionElement) {
        interactor.registerViewsDB(positionElement);
    }
}
