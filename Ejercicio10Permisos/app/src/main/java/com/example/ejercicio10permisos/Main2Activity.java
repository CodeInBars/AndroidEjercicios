package com.example.ejercicio10permisos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView t;
    Button b;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if((requestCode==1) && (resultCode==RESULT_OK)){

            Toast.makeText(getApplicationContext(), "Vuelve el pending intent OK", Toast.LENGTH_SHORT).show();
            t.setText(data.getStringExtra("Texto"));

        }else{

                Toast.makeText(getApplicationContext(), "Vuelve el pending intent CANCEL", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b = findViewById(R.id.button6);
        t = findViewById(R.id.textView);
        Intent in = getIntent();
        t.setText(in.getStringExtra("Nombre"));



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                startActivityForResult(i, 1);
            }
        });






    }
}
