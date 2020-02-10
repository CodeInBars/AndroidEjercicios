package com.example.basedatos;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {

    String cadenaTablas = "CREATE TABLE tablaPrueba (_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(25), edad VARCHAR(3), email VARCHAR(30))";
    String cadenaTablas2 = "CREATE TABLE tablaLocalidades (_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(25))";
    Context contexto;

    public BaseDatos(@Nullable Context context) {
        super(context, "BDPrueba", null, 4);
        contexto = context;
        Toast.makeText(context, "Constructor",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL(cadenaTablas);
            db.execSQL(cadenaTablas2);

        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Toast.makeText(contexto, "OnUpgrade",Toast.LENGTH_SHORT).show();

        //0.Backup de los datos (opcional)
        //1.Eliminar tablas y relaciones
        db.execSQL("Drop table IF EXISTS tablaPrueba");
        db.execSQL("Drop table IF EXISTS tablaLocalidades");
        db.execSQL(cadenaTablas);
        //2.Volver a crear todo
        onCreate(db);

    }
}
