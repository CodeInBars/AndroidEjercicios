package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView dim;
    ArrayList<String> datos;
    ArrayAdapter dat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dim = findViewById(R.id.dim);

        datos = new ArrayList<>();
        datos.add("Lunes");
        datos.add("Martes");
        datos.add("Miercoles");

        //ArrayAdapter
        dat = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,datos);
        dim.setAdapter(dat);

        dim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                datos.remove(position);
                dat.notifyDataSetChanged();
            }
        });




    }
}
