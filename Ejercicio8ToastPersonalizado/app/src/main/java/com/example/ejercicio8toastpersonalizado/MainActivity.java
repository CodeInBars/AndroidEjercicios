package com.example.ejercicio8toastpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get your custom_toast.xml ayout
                LayoutInflater inflater = getLayoutInflater();

                View layout = inflater.inflate(R.layout.ctoast,
                        (ViewGroup) findViewById(R.id.custom_toast_layout_id));

                // set a dummy image
                ImageView image = (ImageView) layout.findViewById(R.id.image);
                image.setImageResource(R.drawable.ic_launcher_background);

                // set a message
                TextView text = (TextView) layout.findViewById(R.id.text);
                text.setText("Button is clicked!");

                // Toast...
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP|Gravity.RIGHT, 50, 200);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();
            }
        });


    }
}
