package com.lapantallasoftware.collectivecrew.ccapp.helper;

/**
 * Created by AbrWin on 14/04/17.
 */

public interface EventBus {
    void register(Object subscribe);
    void unregister(Object subscribe);
    void post(Object event);
}
