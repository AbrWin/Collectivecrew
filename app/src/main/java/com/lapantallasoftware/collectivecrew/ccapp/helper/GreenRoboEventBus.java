package com.lapantallasoftware.collectivecrew.ccapp.helper;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by AbrWin on 14/04/17.
 */

public class GreenRoboEventBus implements com.lapantallasoftware.collectivecrew.ccapp.helper.EventBus {
    private EventBus eventBus;

    public static class SingletonHolder {
        public static final GreenRoboEventBus ROBO_EVENT_BUS = new GreenRoboEventBus();
    }

    public static GreenRoboEventBus getInstance() {
        return SingletonHolder.ROBO_EVENT_BUS;
    }

    public GreenRoboEventBus() {
        this.eventBus = EventBus.getDefault();
    }

    @Override
    public void register(Object subscribe) {
        this.eventBus.register(subscribe);
    }

    @Override
    public void unregister(Object subscribe) {
        this.eventBus.unregister(subscribe);
    }

    @Override
    public void post(Object event) {
        this.eventBus.post(event);
    }
}
