package com.lapantallasoftware.collectivecrew.ccapp.view.shortcutlist;
/**
 * Created by AbrWin on 14/04/17.
 */

public class ListShortcutInteractorImp implements ListShortcutMVP.ListShortcutInteractor {
    private ListshortRepositoryImp repositoryImp;

    public ListShortcutInteractorImp() {
        this.repositoryImp = new ListshortRepositoryImp();
    }

    @Override
    public void getValues() {
        repositoryImp.getValues();
    }
}
