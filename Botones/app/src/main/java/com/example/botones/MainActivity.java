package com.example.botones;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1. Definir un objeto
    Button boton, boton2, boton3, boton4;
    int numero = 0;
    TextView puntuacion, bor;
    EditText texte;
    ImageView imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = findViewById(R.id.button);
        boton2 = findViewById(R.id.button2);
        boton3 = findViewById(R.id.button3);
        boton4 = findViewById(R.id.button4);
        puntuacion = findViewById(R.id.textView);
        bor = findViewById(R.id.textView2);
        texte = findViewById(R.id.editText);
        imagen = findViewById(R.id.imageView);



        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), ""+bor.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bor.setText(texte.getText());
                imagen.setImageResource(R.mipmap.ic_launcher_round);
            }
        });

        boton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clickBotonEnviarLong(boton);
                return true;
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBotonEnviar(boton);
            }
        });

        boton2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clickBotonEnviarLong(boton2);
                return true;
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickBotonEnviar(boton2);
            }
        });


    }


    public void clickBotonEnviar(Button botones){

        if(botones.getText().equals("Restar")){

            numero --;
            puntuacion.setText(""+numero);
        }
        else{

            numero ++;
            puntuacion.setText(""+numero);
        }

        Toast.makeText(MainActivity.this, "Has pulsado " + botones.getText() + " " + numero, Toast.LENGTH_SHORT).show();
    }

    public void clickBotonEnviarLong(Button botones){

        if(botones.getText().equals("Restar")){

            numero = numero - 2;
            puntuacion.setText(""+numero);
        }
        else{

            numero = numero + 2;
            puntuacion.setText(""+numero);
        }
        Toast.makeText(getApplicationContext(), "Has pulsado " + botones.getText() + " " + numero, Toast.LENGTH_SHORT).show();
    }
}
