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

public class ListViewMain extends AppCompatActivity {

    ListView lsv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);

        ListviewRen  renglones_datos[] =  new ListviewRen[]{
                                                new ListviewRen(R.mipmap.ic_launcher,"uno"+" discovers"+" fails"),
                                                new ListviewRen(R.mipmap.ic_launcher,"dos"),
                                                new ListviewRen(R.mipmap.ic_launcher,"tres"),
                                                new ListviewRen(R.mipmap.ic_launcher,"cuatro"),
                                                new ListviewRen(R.mipmap.ic_launcher,"cinco"),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis1" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis2" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis3" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis4" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis5" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis6" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis7" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis8" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis9" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis10" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis11" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis12" ),
                                                new ListviewRen(R.mipmap.ic_launcher,"seis13" )
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
