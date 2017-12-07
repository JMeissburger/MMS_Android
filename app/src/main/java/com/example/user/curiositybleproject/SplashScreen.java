package com.example.user.curiositybleproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jordan on 21/11/17.
 */

public class SplashScreen extends AppCompatActivity {

    private static final long DEFAULT_DELAY = 5000;
    ImageView mImageView;
    Intent mIntent;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mImageView = (ImageView) findViewById(R.id.image);

        mIntent = new Intent(this,MainActivity.class);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startMain();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, DEFAULT_DELAY);
    }
    public void startMain(){
        startActivity(mIntent);
        finish();
    }
}
