package com.lapantallasoftware.collectivecrew.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lapantallasoftware.collectivecrew.R;
import com.lapantallasoftware.collectivecrew.ccapp.utils.GeneralLog;

/**
 * Abrwin 30/01/17
 */
public class SplashActivity extends AppCompatActivity {
    private InitActivity initActivity;
    private String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);
        initActivity = new InitActivity();
        initActivity.callDelayHandler();
    }

    private class InitActivity implements Runnable {
        private Handler handler;
        private int TIME_DELAY = 2000;

        public InitActivity() {
            this.handler = new Handler();
        }

        private void callDelayHandler() {
            if (handler != null) {
                handler.postDelayed(this, TIME_DELAY);
            }
        }

        @Override
        public void run() {
            initMain();
        }

        private void finishHandler() {
            handler.removeCallbacks(this);
            GeneralLog.d(TAG, "finish handler");
        }
    }

    private void initMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        initActivity.finishHandler();
        finish();
    }
}
