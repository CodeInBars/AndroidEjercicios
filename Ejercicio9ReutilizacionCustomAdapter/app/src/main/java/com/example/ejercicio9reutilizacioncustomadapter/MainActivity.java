package com.example.ejercicio9reutilizacioncustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView grid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] nombre = getResources().getStringArray(R.array.nombres);
        String[] descripcion = getResources().getStringArray(R.array.subtitulos);
        int[] imagenes = {R.drawable.indice,R.drawable.indice2,R.drawable.indice3};

        grid = findViewById(R.id.grid);

        MyCustomAdapter customAdapter = new MyCustomAdapter(getApplication(), nombre, descripcion, imagenes);
        grid.setAdapter(customAdapter);
        grid.setNumColumns(2);
    }
}
