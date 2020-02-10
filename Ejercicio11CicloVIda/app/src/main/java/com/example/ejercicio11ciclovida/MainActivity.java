package com.example.ejercicio11ciclovida;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b,b2,b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Ciclos", "Create");
        b = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, Main2Activity.class),1);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(getApplicationContext(), "Are you sure about that", Toast.LENGTH_SHORT);
        finish();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Ciclos", "Resume");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("Ciclos", "Start");
    }


    @Override
    protected void onStop() {
        super.onStop();

        Log.d("Ciclos", "Stop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("Ciclos", "Restart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("Ciclos", "Destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("Ciclos", "Pause");
    }
}
