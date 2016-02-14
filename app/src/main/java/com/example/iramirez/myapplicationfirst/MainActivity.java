package com.example.iramirez.myapplicationfirst;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.example.iramirez.myapplicationfirst.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int Numero_Aleat= Utils.GetNumberRandom();

        Button p1_button = (Button)findViewById(R.id.button);
        p1_button.setText(String.valueOf("one"));

        Button p2_button = (Button)findViewById(R.id.button2);
        p2_button.setText(String.valueOf("two"));

        Button p3_button = (Button)findViewById(R.id.button3);
        p3_button.setText(String.valueOf("three"));

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //     intent.putExtra();
                startActivity(intent);

            }
        });


    }

}
