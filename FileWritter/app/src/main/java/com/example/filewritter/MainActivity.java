package com.example.filewritter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 225);
            } else {

            }


            OutputStreamWriter fout = new OutputStreamWriter(openFileOutput("prueba_int.txt", MODE_PRIVATE));
            fout.write("Texto de prubea");
            fout.close();

            InputStreamReader fou2 = new InputStreamReader(openFileInput("prueba_int.txt"));
            Toast.makeText(getApplicationContext(),"" + fou2, Toast.LENGTH_SHORT).show();

        }catch(Exception ex){

        }

    }
}
