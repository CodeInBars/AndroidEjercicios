package com.example.ejercicio13menucontextual;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    ConstraintLayout constrain;
    ListView lista;
    ArrayAdapter datos;

    String[] contactos = {"Paco", "Elena", "Pepe"};


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo inf = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.item1:
                txt.setTextColor(Color.BLUE);
                break;
            case R.id.item2:
                txt.setTextColor(Color.RED);
                break;
            case R.id.item3:
                txt.setBackgroundColor(Color.BLUE);
                break;
            case R.id.item4:
                txt.setBackgroundColor(Color.RED);
                break;
            case R.id.mensaje:
                Toast.makeText(getApplicationContext(), "Mensaje para " + contactos[inf.position], Toast.LENGTH_SHORT).show();
                break;
            case R.id.llamar:
                Toast.makeText(getApplicationContext(), "llamando a " + contactos[inf.position], Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constrain = findViewById(R.id.constrain);
        txt = findViewById(R.id.text);
        lista = findViewById(R.id.listview);


        datos = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, contactos);

        lista.setAdapter(datos);

        txt.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_etiqueta, menu);

            }
        });

        lista.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_listview, menu);
            }
        });








    }

}
