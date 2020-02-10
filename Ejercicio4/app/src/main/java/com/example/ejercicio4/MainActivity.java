package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int [] im = {R.drawable.img01, R.drawable.img02};
    Button boton;
    RadioButton rb,rb2;
    ConstraintLayout pantalla;
    RadioGroup rest;
    ImageView img;
    int m = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pantalla = findViewById(R.id.resultado);
        img = findViewById(R.id.imageView);
        rest = findViewById(R.id.rest);
        rb = findViewById(R.id.radioButton9);
        rb = findViewById(R.id.radioButton10);

        boton = new Button(this);
        boton.setText("Boton Programado");
        pantalla.addView(boton);
        img.setImageResource(im[0]);




        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(m == 0){
                    img.setImageResource(im[1]);
                    m ++;
                }
                else{
                    img.setImageResource(im[0]);
                    m --;
                }
            }
        });




    }

}