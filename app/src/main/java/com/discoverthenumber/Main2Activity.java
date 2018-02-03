package com.discoverthenumber;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        int NumberRandom = intent.getIntExtra("NumberRandom", 0);
        int NumberButton = intent.getIntExtra("NumberButton", 0);

        //getting preferences
        SharedPreferences prefs = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
         int  conDiscs  = prefs.getInt("conDiscs", 0);//"0" is the default value.
         int  contFails = prefs.getInt("contFails", 0); //0 is the default value.
         String  user  = prefs.getString("User", null);

        ImageView iv = (ImageView) findViewById(R.id.imageViewMain2);

        if(NumberRandom==NumberButton)
        {
            Glide.with(this)
                    .load(Uri.parse("file:///android_asset/SmileCorrect.gif"))
                    .into(iv);
            conDiscs= conDiscs+1;
        }
        else
        {
            Glide.with(this)
                    .load(Uri.parse("file:///android_asset/ErrorFace.gif"))
                    .into(iv);
            contFails=contFails+1;
        }


       //setting preferences
        SharedPreferences.Editor editor = getSharedPreferences("MyPrefsFile", MODE_PRIVATE).edit();
        editor.putInt("conDiscs", conDiscs);
        editor.putInt("contFails", contFails);
        editor.commit();


        FloatingActionButton bttflot =  (FloatingActionButton) findViewById(R.id.fab);
        bttflot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Main2Activity.this.finish();
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });



        Button bttExit =  (Button) findViewById(R.id.buttExit2);
        bttExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("MyPrefsFile", MODE_PRIVATE).edit();
                editor.putInt("conDiscs", 0);
                editor.putInt("contFails", 0);
                editor.putString("User", null);
                editor.commit();
                Main2Activity.this.finish();
                startActivity(new Intent(Main2Activity.this,LoginActivity.class));
            }
        });


    }

}
