package com.example.ejercicio15sharepreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import static com.example.ejercicio15sharepreferences.R.color.colorDark;
import static com.example.ejercicio15sharepreferences.R.color.colorDarkFont;
import static com.example.ejercicio15sharepreferences.R.color.colorPrimary;

public class MainActivity extends AppCompatActivity {

    EditText edi1, edi2, edi3, edi4, edi5;
    CheckBox chc;
    Button btn,btn2,btn3;
    ConstraintLayout c;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);



        String nom_usuario = preferences.getString("nombre", "sin_usuario");
        String ape1_usuario = preferences.getString("apellido1", "sin_apellido");
        String ape2_usuario = preferences.getString("apellido2", "sin_apellido");
        int edad = preferences.getInt("edad", 0);
        String idioma = preferences.getString("idioma", "sin_idioma");
        Boolean sonido = preferences.getBoolean("sonido", false);

        Toast.makeText(getApplicationContext(), nom_usuario +"\n"+ ape1_usuario +"\n"+ ape2_usuario +"\n"+ edad +"\n"+ idioma +
                "\n"+ sonido, Toast.LENGTH_SHORT).show();


        c = findViewById(R.id.c);
        edi1 = findViewById(R.id.editText);
        edi2 = findViewById(R.id.editText2);
        edi3 = findViewById(R.id.editText3);
        edi4 = findViewById(R.id.editText5);
        edi5 = findViewById(R.id.editText6);

        chc = findViewById(R.id.checkBox);
        btn = findViewById(R.id.button);
        btn3 = findViewById(R.id.button4);

        edi1.setText(nom_usuario);
        edi2.setText(ape1_usuario);
        edi3.setText(ape2_usuario);
        edi4.setText(String.valueOf(edad));
        edi5.setText(idioma);
        chc.setChecked(sonido);

        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor miEditor = preferences.edit();

                miEditor.putString("nombre", edi1.getText().toString());
                miEditor.putString("apellido1", edi2.getText().toString());
                miEditor.putString("apellido2", edi3.getText().toString());
                miEditor.putInt("edad", Integer.parseInt(edi4.getText().toString()));
                miEditor.putString("idioma", edi5.getText().toString());

                if(chc.isChecked())
                    miEditor.putBoolean("sonido", true);
                else
                    miEditor.putBoolean("apellido1", false);


                miEditor.commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ActivityConfiguracion.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

                String nombre = preferences.getString("edit_text_preference_1", "nada");
                Toast.makeText(getApplicationContext(), nombre, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Boolean darkMode = preferences2.getBoolean("TemaColor", false);
        if(darkMode){
            edi1.setTextColor(getResources().getColor(colorDarkFont));
            c.setBackgroundColor(getResources().getColor(colorDark));

        }else{
            edi1.setTextColor(getResources().getColor(colorDark));
            c.setBackgroundColor(getResources().getColor(colorPrimary));

        }
    }
}
