package com.example.basedatos2;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {

    String cadenaTablas = "CREATE TABLE tablaPrueba (_id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(25), localidad VARCHAR(25))";
    String table = "DROP TABLE IF EXISTS tablaPrueba";
    Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, "BDNAME", null, 5);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL(table);
            db.execSQL(cadenaTablas);
            Toast.makeText(context, "Create", Toast.LENGTH_SHORT).show();
        }catch (SQLException e){

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(table);
        db.execSQL(cadenaTablas);
    }
}
