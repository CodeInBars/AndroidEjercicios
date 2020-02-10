package com.example.basedatos2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class BDAdaptador {

    Cursor c;
    SQLiteDatabase bdEscritura;
    Context context;
    BaseDatos bd;

    public BDAdaptador(Context context){

        this.context = context;
        bd = new BaseDatos(context);
    }

    public long insertarUsuario(String nombre, String localidad){

        bdEscritura = bd.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nombre);
        values.put("localidad", localidad);
        long result = bdEscritura.insert("tablaPrueba",null,values);
        return result;
    }

    public Cursor mostrar(){

        String cadena = "Select * from tablaPrueba";
        bdEscritura = bd.getReadableDatabase();
        c = bdEscritura.rawQuery(cadena,null);
        return c;
    }


    public long delete(String nombre) {

        bdEscritura = bd.getWritableDatabase();
        long result = bdEscritura.delete("tablaPrueba","nombre=?", new String[]{nombre});
        return result;
    }
}
