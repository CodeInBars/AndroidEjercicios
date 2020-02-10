package com.example.ejercicio3ismaeljimenez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spin;
    Button btnActivity;
    String mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = findViewById(R.id.spinner);
        btnActivity = findViewById(R.id.btnActivity);

        ArrayAdapter ar = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.meses));

        spin.setAdapter(ar);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mes = spin.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, "Mes: " + mes, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                myIntent.putExtra("mes", mes);
                startActivity(myIntent);
            }
        });
    }
}
