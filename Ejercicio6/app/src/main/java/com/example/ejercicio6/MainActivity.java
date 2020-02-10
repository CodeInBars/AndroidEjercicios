package com.example.ejercicio6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    String[] arrayListas = {"lista1", "lista2"};
    ArrayAdapter dat;
    ArrayAdapter datos;
    Spinner spin1, spin2;
    Button r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin1 = findViewById(R.id.spinner1);
        spin2 = findViewById(R.id.spinner2);
        r = findViewById(R.id.button);


        dat = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.pais));
        datos = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, arrayListas);

        spin1.setAdapter(dat);
        spin2.setAdapter(datos);




        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Spin 1: " + spin1.getSelectedItem() + "\nSpin 2: " + spin2.getSelectedItem() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
