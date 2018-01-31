package com.discoverthenumber;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by IVANROCK on 11-May-17.
 */

public class ListviewAdapter  extends ArrayAdapter<ListviewRen> {

    Context context;
    int layoutResourceId;
    ListviewRen datos[];

   public ListviewAdapter(Context context, int layoutResourceId, ListviewRen[] datos )
   {
       super(context,layoutResourceId,datos);
       this.context= context;
       this.layoutResourceId = layoutResourceId;
       this.datos = datos;
   }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

       View renglon = convertView;
        ListviewHolder holder = null;

        if(renglon == null){
            LayoutInflater inflater= ((Activity)context).getLayoutInflater();
            renglon = inflater.inflate(layoutResourceId,parent,false);

            holder= new ListviewHolder();
            holder.imagen= (ImageView)renglon.findViewById(R.id.img_foto);
            holder.nombre= (TextView)renglon.findViewById(R.id.txt_nombre);
            renglon.setTag(holder);
        }else{
            holder= (ListviewHolder) renglon.getTag();

        }

        ListviewRen listviewRen = datos[position];
        holder.nombre.setText(listviewRen.nombre);
        holder.imagen.setImageResource(listviewRen.imagen);

        return renglon;
    }

    static  class ListviewHolder{
        ImageView imagen;
        TextView nombre;

    }

}
