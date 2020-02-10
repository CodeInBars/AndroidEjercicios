package com.example.ejercicio7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends BaseAdapter {


    ArrayList<filas> lista;
    Context contexto;

    public MyCustomAdapter(Context c, String[] titulos, String[] subtitulos, int[] imagenes) {


        this.contexto = c;

        lista = new ArrayList<>();
        //Crear el ArrayList de filas
        for(int i=0; i<imagenes.length; i++){

            filas f = new filas(imagenes[i], titulos[i], subtitulos[i]);
            lista.add(f);
        }




    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {

        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {


        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Definimos un LayoutInflater para poder cargar el custom layout
        LayoutInflater inflar = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Inflamos el custom layout
        View list = inflar.inflate(R.layout.customlistview, parent, false);
        //Enlazamos a traves de un list
        ImageView imagenLayout = list.findViewById(R.id.imagenfila);
        imagenLayout.setImageResource(lista.get(position).imagen);

        TextView tituloLayout = list.findViewById(R.id.titulofila);
        tituloLayout.setText(lista.get(position).titulo);

        TextView subtituloLayout = list.findViewById(R.id.subtitulofila);
        subtituloLayout.setText(lista.get(position).subtitulo);
        return list;

    }
}
