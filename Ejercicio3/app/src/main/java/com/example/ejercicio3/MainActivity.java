package com.example.ejercicio3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnPrevious, btnNext, button;
    ImageView n;
    CheckBox check,check1, check2;
    int [] imagenes = {R.drawable.campanilla,R.drawable.disney,R.drawable.mickie,R.drawable.mini, R.drawable.pepito, R.drawable.pluto};
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        check = findViewById(R.id.checkBox);
        check1 = findViewById(R.id.checkBox2);
        check2 = findViewById(R.id.checkBox3);
        n = findViewById(R.id.imageView);
        button = findViewById(R.id.button3);

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                retroceder();
            }
        });

        btnPrevious.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                contador = 0;
                n.setImageResource(imagenes[contador]);
                return true;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                siguiente();
            }
        });

        btnNext.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                contador = 5;
                n.setImageResource(imagenes[contador]);
                return true;
            }
        });

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                siguiente();
            }
        });

        n.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                check.setChecked(!check.isChecked());

                retroceder();
                return true;
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "CheckBox clicado " + check.isChecked(), Toast.LENGTH_SHORT).show();
                Log.d("Checkbox", "Entra en el listener");
                if(check.isChecked()){
                    check.setText("Check en true");
                }else{
                    check.setText("Check en false");
                }

            }
        });
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("Checked", "boolean" + isChecked);
                Toast.makeText(getApplicationContext(), "CheckBox changed", Toast.LENGTH_LONG).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Android "+ check2.isChecked() + "Java " + check.isChecked() + "OpenCSV " + check1.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });



    }


    public void retroceder(){

        contador --;
        if(contador==-1) {
            contador = 5;
        }
        n.setImageResource(imagenes[contador]);
    }

    public void siguiente(){

        contador ++;
        if(contador==6){
            contador = 0;
        }
        n.setImageResource(imagenes[contador]);
    }


}
