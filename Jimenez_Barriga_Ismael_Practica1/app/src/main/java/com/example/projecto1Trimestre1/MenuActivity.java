package com.example.projecto1Trimestre1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button btnJugar, btnMarcadores, btnSalir;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent mainIntent;
        switch (item.getItemId()) {
            case R.id.configuracion:
                mainIntent = new Intent(MenuActivity.this, ConfigActivity.class);
                MenuActivity.this.startActivity(mainIntent);

                break;

            case R.id.ayuda:

                mainIntent = new Intent(MenuActivity.this, AyudaActivity.class);
                MenuActivity.this.startActivity(mainIntent);
                MenuActivity.this.finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menuactivity, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);


        btnJugar = findViewById(R.id.btnJugar);
        btnMarcadores = findViewById(R.id.btnMarcador);
        btnSalir = findViewById(R.id.btnSalir);



        btnSalir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);

                builder.setTitle("Desea Salir de la aplicacion");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("No", null);
                builder.create();
                builder.show();
            }
        });

        btnMarcadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MenuActivity.this, ScoreBoardActivity.class);
                startActivity(myintent);
                finish();
            }
        });

        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myintent = new Intent(MenuActivity.this, GameActivity.class);
                startActivity(myintent);
                finish();
            }
        });
    }
}
