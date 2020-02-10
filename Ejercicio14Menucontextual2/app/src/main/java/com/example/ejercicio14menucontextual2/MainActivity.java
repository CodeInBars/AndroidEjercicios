package com.example.ejercicio14menucontextual2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView etiqueta1, etiqueta2;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.textView){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_etiqueta1, menu);
        }
        if(v.getId()==R.id.textView2){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_etiqueta2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.tamano:
                Toast.makeText(getApplicationContext(),"Tamaño", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cFondo:
                Toast.makeText(getApplicationContext(),"Color de fondo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cTexto:
                Toast.makeText(getApplicationContext(),"Color de Texto", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etiqueta1 = findViewById(R.id.textView);
        etiqueta2 = findViewById(R.id.textView2);

        registerForContextMenu(etiqueta1);
        registerForContextMenu(etiqueta2);

    }



}
