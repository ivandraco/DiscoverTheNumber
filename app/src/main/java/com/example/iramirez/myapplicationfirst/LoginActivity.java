package com.example.iramirez.myapplicationfirst;

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
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

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

        Button sign_in_button = (Button) findViewById(R.id.sign_in_button);
        sign_in_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                AutoCompleteTextView tvUser = (AutoCompleteTextView)findViewById(R.id.User);
                Editable UserEdit= (Editable)tvUser.getText();
                User= UserEdit.toString();

                SharedPreferences.Editor editor = getSharedPreferences("MyPrefsFile", MODE_PRIVATE).edit();
                editor.putInt("conDiscs", 0);
                editor.putInt("contFails", 0);
                editor.putString("User", User);
                editor.commit();


                Context context = getApplicationContext();
                CharSequence text =  User+" a iniciado session en juego";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


                Log.wtf("User Login:", User);

                startActivity(new Intent(LoginActivity.this, MainActivity.class));

                Button bttSign =  (Button) findViewById(R.id.button_sign_in);
                bttSign.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LoginActivity.this.finish();
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));


                    }
                });


                Button bttEst =  (Button) findViewById(R.id.buttom_estadistica);
                bttEst.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LoginActivity.this.finish();
                        startActivity(new Intent(LoginActivity.this, ListViewMain.class));
                    }
                });



            }
        });

    }

}

