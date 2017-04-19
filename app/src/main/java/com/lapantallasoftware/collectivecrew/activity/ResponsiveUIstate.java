package com.lapantallasoftware.collectivecrew.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.lapantallasoftware.collectivecrew.R;
import com.lapantallasoftware.collectivecrew.ccapp.view.ViewDetailShortcut;
import com.lapantallasoftware.collectivecrew.ccapp.view.ViewShortcutList;

/**
 * Created by AbrWin on 14/04/17.
 */

public enum ResponsiveUIstate {
    SHORTCUT() {
        @Override
        public Fragment execute(MainActivity activity) {
            return colocaOuBuscaFragmentNaTela(activity, R.id.fragment_container, ViewShortcutList.class);
        }
    },
    DETAILPROYECT() {
        @Override
        public Fragment execute(MainActivity activity) {
            return colocaOuBuscaFragmentNaTela(activity, R.id.fragment_container, ViewDetailShortcut.class);
        }
    },
    HOME() {
        @Override
        public Fragment execute(MainActivity activity) {
            return colocaOuBuscaFragmentNaTela(activity, R.id.fragment_container, ViewShortcutList.class);
        }
    };


    ResponsiveUIstate() {
    }

    public abstract Fragment execute(MainActivity activity);
    public Bundle bundle;

    Fragment colocaOuBuscaFragmentNaTela(MainActivity activity, int id,
                                         Class<? extends Fragment> fragmentClass) {

        Fragment fragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(fragmentClass.getCanonicalName());
        if (fragmentByTag != null) {
            Bundle b = fragmentByTag.getArguments();
            if (b == null || b == bundle)
                return fragmentByTag;
        }

        try {
            Fragment newFragment = fragmentClass.newInstance();
            if (bundle != null)
                newFragment.setArguments(bundle);

            FragmentManager manager = activity.getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            //tx.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            //tx.setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out,android.R.anim.fade_in,android.R.anim.fade_out);
            transaction.replace(id, newFragment, fragmentClass.getCanonicalName());
            transaction.addToBackStack(null);
            transaction.commit();
            return newFragment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResponsiveUIstate setState(ResponsiveUIstate newState){
        ResponsiveUIstate state = newState;
        return state;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ResponsiveUIstate setBundle(Bundle bundle) {
        this.bundle = bundle;
        return this;
    }
}
