package com.example.ejercicio5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);

        String[] datos = {"Lunes","Martes"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(getApplicationContext(), R.layout.fila, R.id.textoLayout, datos);


        list.setAdapter(adaptador);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item Selected: " + list.getItemAtPosition(position) + "Item Position: " + list.getItemIdAtPosition(position), Toast.LENGTH_SHORT).show();


            }
        });


    }
}
