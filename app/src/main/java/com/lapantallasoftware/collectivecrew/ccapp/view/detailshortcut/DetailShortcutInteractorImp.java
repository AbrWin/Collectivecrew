package com.lapantallasoftware.collectivecrew.ccapp.view.detailshortcut;

/**
 * Created by AbrWin on 02/05/17.
 */

public class DetailShortcutInteractorImp implements DetailShortcutMVP.DetailShortcutInteractor{
    private DetailShortcutRepositoryImp repository;

    public DetailShortcutInteractorImp() {
        this.repository = new DetailShortcutRepositoryImp();
    }

    @Override
    public void registerViewsDB(int positionElement) {
        repository.registerViewsDB(positionElement);
    }
}
