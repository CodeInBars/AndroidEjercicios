package com.example.ejercicio12intentfilter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.net.URLDecoder;



public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraint = findViewById(R.id.constrain);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.id1:
                Toast.makeText(getApplicationContext(),"ID1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.azul:
                constraint.setBackgroundColor(Color.BLUE);
                break;
            case R.id.rojo:
                constraint.setBackgroundColor(Color.RED);
                break;
            case R.id.acerca:
                Intent inten = new Intent(Intent.ACTION_WEB_SEARCH);
                inten.putExtra(SearchManager.QUERY,"Google");
                startActivity(inten);
                break;

            case R.id.app_bar_switch:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
