package com.manishkpr.Tjs_Solutions;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Timer timer= new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent in = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(in);
            }
        };
        timer.schedule(task, 3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SplashActivity.this.finish();
    }

    @Override
    public void onBackPressed() {

    }
}