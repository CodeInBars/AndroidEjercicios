package com.example.ejercicio10permisos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {

    Button botonok, botoncancelar;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        botonok = findViewById(R.id.button7);
        botoncancelar = findViewById(R.id.button8);
        txt = findViewById(R.id.editText2);

        botonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent();
                intento.putExtra("Texto", txt.getText().toString());
                setResult(RESULT_OK, intento);
                finish();
            }
        });

        botoncancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
