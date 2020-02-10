package com.example.ejercicio2ismaeljimenez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rGroup;
    RadioButton rImagen1, rImagen2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        rGroup = findViewById(R.id.radioGroup);
        rImagen1 = findViewById(R.id.rImagen1);
        rImagen2 = findViewById(R.id.rImagen2);

        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId){

                    case R.id.rImagen1:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
                        break;

                    case R.id.rImagen2:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_round));
                        break;
                }
            }
        });
    }
}
