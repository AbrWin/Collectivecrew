package com.lapantallasoftware.collectivecrew.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.lapantallasoftware.collectivecrew.R;
import com.lapantallasoftware.collectivecrew.ccapp.utils.CollectiveCrewAnaliticts;
import com.lapantallasoftware.collectivecrew.ccapp.view.ViewCommon;

/**
 * Abrwin 30/01/17
 */
public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private ResponsiveUIstate state;
    protected ViewCommon actualFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.title_home));
        setSupportActionBar(toolbar);
        CollectiveCrewAnaliticts.sendAnaliticsEvent(TAG, "Init app", "Home");
        changeFragment(ResponsiveUIstate.SHORTCUT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeFragment(ResponsiveUIstate responsiveUIstate) {
        this.state = ResponsiveUIstate.setState(responsiveUIstate);
        this.state.execute(this);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public ViewCommon getActualFragment() {
        return actualFragment;
    }

    public void setActualFragment(ViewCommon actualFragment) {
        this.actualFragment = actualFragment;
    }


}
