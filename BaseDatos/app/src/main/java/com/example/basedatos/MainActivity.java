package com.example.basedatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BDAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adaptador = new BDAdaptador(MainActivity.this);
        //long result = adaptador.insertar("IsmaelAdaptador");
        //long result2 = adaptador.insertarLocalizacion("Navalmoral");


        Cursor resultado = adaptador.consultaUsuarios();
        StringBuilder cadena=new StringBuilder();
        while(resultado.moveToNext()){
            int id = resultado.getInt(0);
            String nombre = resultado.getString(1);
            cadena.append(" ID: ");
            cadena.append(id);
            cadena.append(" Nombre: ");
            cadena.append(nombre);
            Toast.makeText(getApplicationContext(), cadena, Toast.LENGTH_SHORT).show();
        }

    }
}
