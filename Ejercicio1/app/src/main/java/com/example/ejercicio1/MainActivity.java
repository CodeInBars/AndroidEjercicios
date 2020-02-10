package com.example.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ls;
    Button bot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bot = findViewById(R.id.button);
        ls = findViewById(R.id.imageView);
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ls.getDrawable().getConstantState()==getResources().getDrawable(R.drawable.img1).getConstantState()){

                    ls.setImageResource(R.drawable.img2);
                }
                else{
                    ls.setImageResource(R.drawable.img1);
                }
            }
        });
    }
}
