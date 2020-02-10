package com.example.pulsaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float xDown = 0;
    float xUp = 0;
    float xMove = 0;
    float xMove2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = MotionEventCompat.getActionMasked(event);


        switch(action){
            case MotionEvent.ACTION_DOWN:
                Log.d("TAG", "Down");
                xDown = event.getX();
                xMove2 = xDown;

                return true;
            case MotionEvent.ACTION_UP:
                Log.d("TAG", "Up");
                xUp = event.getX();
                if(xDown<xUp){
                    Log.d("Posicion", "Derecha");
                }else{
                    Log.d("Posicion", "Izquierda");
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                Log.d("TAG", "MOVE");
                xMove = event.getX();

                if(xMove>xMove2){
                    Log.d("Move", "Derecha");
                    xMove2 = xMove;
                }else{
                    Log.d("Move", "Izquierda");
                    xMove2 = xMove;
                }
                return true;
            default:
                return super.onTouchEvent(event);
        }

    }
}
