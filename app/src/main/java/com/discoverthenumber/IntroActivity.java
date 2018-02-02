package com.discoverthenumber;

import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends AppCompatActivity {

    private static final long DELAY = 3000;
    private boolean scheduled = false;
    private Timer MainTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ImageView iv = (ImageView) findViewById(R.id.imageView);

        Glide.with(this)
               .load(Uri.parse("file:///android_asset/random_numbers.gif"))
               .into(iv);

        MainTimer = new Timer();
        MainTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                IntroActivity.this.finish();
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
            }
        }, DELAY);
        scheduled = true;
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (scheduled)
            MainTimer.cancel();
        MainTimer.purge();
    }

}
