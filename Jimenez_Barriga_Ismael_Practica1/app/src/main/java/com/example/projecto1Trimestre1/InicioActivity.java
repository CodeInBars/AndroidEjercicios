package com.example.projecto1Trimestre1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class InicioActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;
    ProgressBar pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_inicio);

        pr = findViewById(R.id.progressBar);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(InicioActivity.this, MenuActivity.class);
                InicioActivity.this.startActivity(mainIntent);
                InicioActivity.this.finish();
                for(int i = 0; i<2000; i++){

                    pr.setProgress(i);
                }
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}
