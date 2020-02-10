package com.example.basedatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class BDAdaptador {

    BaseDatos bd;
    SQLiteDatabase bdEscritura;
    Context context;

    public BDAdaptador(Context context){

        this.context = context;
        bd = new BaseDatos(context);


    }

    public long insertar(String nombreUsuario){

        bdEscritura = bd.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombreUsuario);
        long result = bdEscritura.insert("tablaPrueba",null,valores);
        return result;
    }

    public long insertarLocalizacion(String nombre){

        bdEscritura = bd.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        long result = bdEscritura.insert("tablaLocalidades",null,valores);
        return result;
    }

    public Cursor consultaUsuarios(){

        String consulta = "Select * from tablaPrueba";
        bdEscritura = bd.getReadableDatabase();
        Cursor c = bdEscritura.rawQuery(consulta,null);
        return c;


    }

    public String consultaUsuariosPorId(int id){

        String consulta = "Select * from tablaPrueba where _id ="+id;
        bdEscritura = bd.getReadableDatabase();
        bdEscritura.rawQuery(consulta,null);
        return "Devolver";

    }

    public String consultaLocalidad(){

        String consulta = "Select * from tablaLocalidades";
        bdEscritura = bd.getReadableDatabase();
        return bdEscritura.rawQuery(consulta,null).toString();

    }
}
