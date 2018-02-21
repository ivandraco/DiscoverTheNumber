package com.discoverthenumber;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity  {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;
    private   String User=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.

        Button sign_in_button = (Button) findViewById(R.id.button_sign_in);
        sign_in_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tvUser = (TextView)findViewById(R.id.User);
                Editable UserEdit= (Editable)tvUser.getText();
                User= UserEdit.toString();

                SharedPreferences.Editor editor = getSharedPreferences("MyPrefsFile", MODE_PRIVATE).edit();
                editor.putInt("conDiscs", 0);
                editor.putInt("contFails", 0);
                editor.putString("User", User);
                editor.commit();


                Context context = getApplicationContext();
                CharSequence text =  User+" "+getResources().getString(R.string.initGame);
                int duration = Toast.LENGTH_LONG;

              if(!User.equals("") && User!=null  && !User.isEmpty()) {
                  Toast toast = Toast.makeText(context, text, duration);
                  toast.show();

                  Log.wtf("User Login:", User);

                  LoginActivity.this.finish();
                  startActivity(new Intent(LoginActivity.this, MainActivity.class));
              }
                 }
        });


        Button bttEst =  (Button) findViewById(R.id.buttom_estadistica);
        bttEst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Context context = getApplicationContext();
                CharSequence text =  "Estadisticas del Juego";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                LoginActivity.this.finish();
                startActivity(new Intent(LoginActivity.this, ListViewMain.class));
            }
        });



    }
}

