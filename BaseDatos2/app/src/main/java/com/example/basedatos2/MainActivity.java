package com.example.basedatos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText usuario;
    Button btnInsertar, btnMostrar;
    BDAdaptador bd = new BDAdaptador(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        usuario = findViewById(R.id.editText);
        btnInsertar = findViewById(R.id.button);
        btnMostrar = findViewById(R.id.button2);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),bd.insertarUsuario(usuario.getText().toString(), "Navalmoral")+"", Toast.LENGTH_SHORT).show();
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent integ = new Intent(MainActivity.this, Main2Activity.class);

                startActivity(integ);
            }
        });
    }
}
