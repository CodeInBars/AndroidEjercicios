package com.example.projecto1Trimestre1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class GameActivity extends AppCompatActivity {

    private static TextView mText, Score;
    private static ImageView avatar;
    private static double Scor = 0;
    private static double dificultadScor = 0;
    private static int seconds = 0;
    private static int idAnimacion,idNoAnimacion;
    private static BDAdaptador bd;
    private static String nombre;
    private static String dificultad;
    private static Date fecha = new Date();
    private static String fechaMod;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_game);
        mText = findViewById(R.id.mText);
        avatar = findViewById(R.id.avatar);
        Score = findViewById(R.id.score);
        Scor = 0;
        bd = new BDAdaptador(GameActivity.this);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        SharedPreferences pr = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        dificultad = pr.getString("dificultad", "1");
        nombre = pr.getString("nameplayer", "player");
        fechaMod = format.format(fecha.getTime());

        switch(dificultad){

            case "1":
                seconds = 30000;
                dificultad = "facil";
                dificultadScor = 0.25;
                idNoAnimacion = R.drawable.emadera;
                avatar.setImageDrawable(getResources().getDrawable(idNoAnimacion));
                idAnimacion = R.drawable.emadera1;
                break;

            case "2":
                seconds = 15000;
                dificultad = "media";
                dificultadScor = 0.5;
                idNoAnimacion = R.drawable.ehierro;
                avatar.setImageDrawable(getResources().getDrawable(idNoAnimacion));
                idAnimacion = R.drawable.ehierro1;
                break;

            case "3":
                seconds = 7000;
                dificultad = "dificil";
                dificultadScor = 0.75;
                idNoAnimacion = R.drawable.eoro1;
                avatar.setImageDrawable(getResources().getDrawable(idNoAnimacion));
                idAnimacion = R.drawable.eoro;
                break;

            case "4":
                seconds = 3000;
                dificultad = "extrema";
                dificultadScor = 1;
                idNoAnimacion = R.drawable.ediamante;
                avatar.setImageDrawable(getResources().getDrawable(idNoAnimacion));
                idAnimacion = R.drawable.ediamante1;
                break;
        }

        countStart();

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Scor += dificultadScor;
                Score.setText("Score: " + Scor);
                sleepAnimation();
                avatar.setImageDrawable(getResources().getDrawable(idNoAnimacion));
            }
        });


    }



    @Override
    protected void onResume() {
        super.onResume();




    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);

        builder.setTitle("Salir de la partida");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent myintent = new Intent(GameActivity.this, MenuActivity.class);
                startActivity(myintent);
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        builder.create();
        builder.show();

    }

    public void countStart(){

        new CountDownTimer(seconds, 1000) {

            public void onTick(long millisUntilFinished) {//Cuando cambia el contador
                //Actualizamos la etiqueta que muestra el contador
                if(millisUntilFinished<7){
                    mText.setTextColor(getResources().getColor(R.color.alarm));
                }
                mText.setText("Segundos restantes: " + millisUntilFinished / 1000);


            }
            //Evento que se lanza cuando acaba la cuenta atrás
            public void onFinish() {

                long id = bd.insertarUsuario(nombre, Scor, dificultad, fechaMod);
                Toast.makeText(getApplicationContext(), " " + id, Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);

                builder.setTitle("Partida Finalizada");
                builder.setPositiveButton("Jugar otra vez", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Scor = 0;
                        countStart();
                    }
                });
                builder.setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent myintent = new Intent(GameActivity.this, MenuActivity.class);
                        startActivity(myintent);
                        finish();
                    }
                });
                builder.setCancelable(false);
                builder.create();
                builder.show();
            }
        }.start();
    }

    public void sleepAnimation(){

        new CountDownTimer(600, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                avatar.setImageDrawable(getResources().getDrawable(idAnimacion));
            }
        }.start();
    }
}
