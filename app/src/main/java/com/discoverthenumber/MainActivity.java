package com.discoverthenumber;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int number=0, numberRandomButton=0;
    boolean enableButtons=false;
    int numberone=0, numbertwo=0, numberthree=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout Layout2=(LinearLayout)this.findViewById(R.id.linearLayoutBtts2);
        Layout2.setVisibility(View.INVISIBLE);

        LinearLayout Layout3=(LinearLayout)this.findViewById(R.id.linearLayoutBtts3);
        Layout3.setVisibility(View.INVISIBLE);

        Button bttRnd = (Button) findViewById(R.id.buttonRandom);
        bttRnd.setOnClickListener(this);

        //getting preferences
        SharedPreferences prefs = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);

        int  conDiscs  = prefs.getInt("conDiscs", 0);//"0" is the default value.
        int  contFails = prefs.getInt("contFails", 0); //0 is the default value.
        String  user  = prefs.getString("User", null);//"Dummy" is the default value.

        Log.wtf("User:", user);

        TextView tvUser = (TextView)findViewById(R.id.textViewUser);
        tvUser.setText(user);

        TextView tvLevel = (TextView)findViewById(R.id.textViewLevel);
        tvLevel.setText(tvLevel.getText()+": 1");

        TextView tvDisc = (TextView)findViewById(R.id.textViewDisc);
        tvDisc.setText(  tvDisc.getText()+" "+String.valueOf(conDiscs));
        tvDisc.setTextColor(Color.GREEN);

        TextView tvFail = (TextView)findViewById(R.id.textViewFail);
        tvFail.setText( tvFail.getText()+" "+String.valueOf(contFails));
        tvFail.setTextColor(Color.RED);

        Button bttExit =  (Button) findViewById(R.id.buttExit1);
        bttExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("MyPrefsFile", MODE_PRIVATE).edit();
                editor.putInt("conDiscs", 0);
                editor.putInt("contFails", 0);
                editor.putString("User", null);
                editor.commit();
                MainActivity.this.finish();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });


    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

        switch (v.getId()) {

            case R.id.button:
                    if (enableButtons) {
                        intent.putExtra("NumberRandom", number);
                        intent.putExtra("NumberButton", numberone);
                        startActivity(intent);
                        MainActivity.this.finish();
                    }
                break;

            case R.id.button2:
                    if(enableButtons) {
                        intent.putExtra("NumberRandom", number);
                        intent.putExtra("NumberButton", numbertwo);
                        startActivity(intent);
                        MainActivity.this.finish();
                    }
                break;

            case R.id.button3:
                    if(enableButtons) {
                        intent.putExtra("NumberRandom", number);
                        intent.putExtra("NumberButton", numberthree);
                        startActivity(intent);
                        MainActivity.this.finish();
                    }
                break;

            case R.id.buttonRandom:

                numberRandomButton = Utils.GetNumberRandomButton();
                number = Utils.GetRandomNumber();

                Log.w("Utils.GetNumberRandom:", String.valueOf(number));
                TextView tv = (TextView)findViewById(R.id.button);
                Button btt = (Button) findViewById(R.id.button);
                btt.setOnClickListener(this);

                TextView tv2 = (TextView)findViewById(R.id.button2);
                Button btt2 = (Button) findViewById(R.id.button2);
                btt2.setOnClickListener(this);

                TextView tv3 = (TextView)findViewById(R.id.button3);
                Button btt3 = (Button) findViewById(R.id.button3);
                btt3.setOnClickListener(this);

                   if(numberRandomButton==1)
                      {
                          tv.setText(String.valueOf(number));
                          numberone=number;
                          tv2.setText(String.valueOf(number-1));
                          numbertwo=number-1;
                          tv3.setText(String.valueOf(number + 1));
                          numberthree=number + 1;
                      }
                   if(numberRandomButton==2)
                      {
                          tv.setText(String.valueOf(number - 1));
                          numberone=number-1;
                          tv2.setText(String.valueOf(number));
                          numbertwo=number;
                          tv3.setText(String.valueOf(number + 1));
                          numberthree=number + 1;
                      }
                   if(numberRandomButton==3)
                      {
                          tv.setText(String.valueOf(number - 1));
                          numberone=number-1;
                          tv2.setText(String.valueOf(number+1));
                          numbertwo=number+1;
                          tv3.setText(String.valueOf(number));
                          numberthree=number;
                      }
                enableButtons=true;
                break;

        }

    }

}
