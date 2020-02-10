package com.example.ejercicio7;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    ListView dim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] titulos = getResources().getStringArray(R.array.titulos);
        String[] subtitulos = getResources().getStringArray(R.array.subtitulos);
        int[] imagenes = {R.drawable.aim, R.drawable.ask, R.drawable.bebo, R.drawable.betvibes, R.drawable.blinklist};

        dim = findViewById(R.id.dim);
        MyCustomAdapter cusadap = new MyCustomAdapter(getApplicationContext(),titulos, subtitulos, imagenes);

        dim.setAdapter(cusadap);

        dim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                filas f = (filas) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Titulo: " + f.titulo + "\nSubtitulo: " + f.subtitulo, Toast.LENGTH_SHORT);
            }
        });
    }
}
