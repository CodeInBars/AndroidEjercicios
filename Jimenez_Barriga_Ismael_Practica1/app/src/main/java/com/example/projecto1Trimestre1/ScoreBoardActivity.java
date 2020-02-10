package com.example.projecto1Trimestre1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class ScoreBoardActivity extends AppCompatActivity {

    private ListView score;
    Cursor c;
    private BDAdaptador bd = new BDAdaptador(ScoreBoardActivity.this);
    private ArrayList<String> fecha = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_scoreboard);

        score = findViewById(R.id.score);

        c = bd.mostrar();

        while(c.moveToNext()){


            fecha.add(c.getString(3));
        }

        final SimpleCursorAdapter adapterC = new SimpleCursorAdapter(ScoreBoardActivity.this, R.layout.layout_fila, c, new String[]{"nombre", "puntuacion", "dificultad"}, new int[]{R.id.nombrePlayer, R.id.scorePlayer, R.id.dificultad});

        score.setAdapter(adapterC);

        score.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(getApplicationContext(), "\nFecha: " + fecha.get(position), Toast.LENGTH_SHORT).show();;
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent myintent = new Intent(ScoreBoardActivity.this, MenuActivity.class);
        startActivity(myintent);
        finish();
    }
}
