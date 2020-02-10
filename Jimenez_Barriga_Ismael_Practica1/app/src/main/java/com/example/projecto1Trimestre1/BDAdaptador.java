package com.example.projecto1Trimestre1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

public class BDAdaptador {

    Cursor c;
    SQLiteDatabase bdEscritura;
    Context context;
    BaseDatos bd;

    public BDAdaptador(Context context){

        this.context = context;
        bd = new BaseDatos(context);
    }

    public long insertarUsuario(String nombre, double puntuacion, String dificultad, String fecha){

        bdEscritura = bd.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("puntuacion", puntuacion);
        values.put("dificultad", dificultad);
        values.put("fecha", fecha);
        long result = bdEscritura.insert("tablaScore",null,values);
        return result;
    }

    public Cursor mostrar(){

        String cadena = "Select * from tablaScore order by puntuacion desc limit 10";
        bdEscritura = bd.getReadableDatabase();
        c = bdEscritura.rawQuery(cadena,null);

        return c;
    }
}
