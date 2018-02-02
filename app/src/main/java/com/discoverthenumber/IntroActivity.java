package com.discoverthenumber;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.io.InputStream;

public class IntroActivity extends AppCompatActivity {

    private static final long DELAY = 3000;
    private boolean scheduled = false;
    private Timer MainTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageBitmap(getBitmapFromAssets("Random.gif"));

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


    private Bitmap getBitmapFromAssets(String fileName){
        AssetManager am = getAssets();
        InputStream is = null;
        Bitmap bitmap = null;
            try{
                  is = am.open(fileName);
                  bitmap = BitmapFactory.decodeStream(is);
            }catch(IOException e){
                e.printStackTrace();
            }
        return bitmap;
    }

}
