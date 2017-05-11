package com.example.iramirez.myapplicationfirst;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewExample extends AppCompatActivity {

    ListView lsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);

        ListviewRen  renglones_datos[] =  new ListviewRen[]{
                                                new ListviewRen(R.mipmap.ic_launcher,"uno"),
                                                new ListviewRen(R.mipmap.ic_launcher,"dos"),
                                                new ListviewRen(R.mipmap.ic_launcher,"tres"),
                                                new ListviewRen(R.mipmap.ic_launcher,"cuatro"),
                                                new ListviewRen(R.mipmap.ic_launcher,"cinco"),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis")
                                             };


        ListviewAdapter adapter= new ListviewAdapter(this,R.layout.renglon,renglones_datos);

        lsv= (ListView)findViewById(R.id.listView);
        lsv.setAdapter(adapter);
        lsv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
                public void onItemClick(AdapterView<?> arg0,View arg1, int arg2, long arg3){

                TextView v = (TextView)arg1.findViewById(R.id.txt_nombre);
                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT );
            }
         }
         );

    }

}
