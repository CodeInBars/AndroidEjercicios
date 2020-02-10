package com.example.ejercicio10permisos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn, btn1, btn2, btn3, btn4;
    EditText txt;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        //El request code debe coincidir
        //Si no me da permiso, mostrar un toast y volver a pedirlo
        if((requestCode==2)&&(grantResults[0]== PackageManager.PERMISSION_DENIED)){

            pedirPermisos(Manifest.permission.CALL_PHONE);
        }
    }

    private void pedirPermisos(String callPhone) {
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{callPhone,}, 1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn1 = findViewById(R.id.button2);
        btn2 = findViewById(R.id.button3);
        btn3 = findViewById(R.id.button4);
        btn4 = findViewById(R.id.button5);
        txt = findViewById(R.id.editText);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Intent.ACTION_WEB_SEARCH);
                intento.putExtra(SearchManager.QUERY,"I.E.S. Augustobriga");
                startActivity(intento);

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intento);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Intent.ACTION_CALL, Uri.parse("tel:123456789"));
                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){

                    pedirPermisos(Manifest.permission.CALL_PHONE);
                }else{


                };
                startActivity(intento);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED){
                    pedirPermisos(Manifest.permission.SEND_SMS);
                }else{

                };
                try {
                    SmsManager sms = SmsManager.getDefault();
                    sms.sendTextMessage("123456789",null,"HELLO ",null,null);
                    Intent intento = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:123456789"));
                    startActivity(intento);
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Mensaje no enviado, datos incorrectos.", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(), Main2Activity.class);
                in.putExtra("Nombre", txt.getText().toString());

                startActivity(in);
            }
        });
    }
}
