package com.example.iramirez.myapplicationfirst;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

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



        if(NumberRandom==NumberButton)
        {
            TextView tv = (TextView)findViewById(R.id.textView2);
            tv.setText(String.valueOf("You Discovered!!!!"));
            tv.setTextColor(Color.GREEN);
            conDiscs= conDiscs+1;
        }
        else
        {
            TextView tv = (TextView)findViewById(R.id.textView2);
            tv.setText(String.valueOf("Fail!"));
            tv.setTextColor(Color.RED);
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
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });

    }

}
