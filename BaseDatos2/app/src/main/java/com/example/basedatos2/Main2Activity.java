package com.example.basedatos2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    BDAdaptador bdAdaptador = new BDAdaptador(Main2Activity.this);
    ArrayList nombre, localidad, ids;
    ListView nombres;
    EditText editText;
    Button button, button2;
    Cursor c;
    BDAdaptador bd = new BDAdaptador(Main2Activity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombres = findViewById(R.id.nombres);
        editText = findViewById(R.id.editText2);
        button = findViewById(R.id.button3);
        button2 = findViewById(R.id.button4);
        Intent m  = getIntent();

        c = bd.mostrar();

        //ArrayAdapter adap = new ArrayAdapter(Main2Activity.this, android.R.layout.simple_list_item_1, nombre);
        SimpleCursorAdapter adaptadorLista = new SimpleCursorAdapter(Main2Activity.this, R.layout.filalist, c, new String[]{"nombre","localidad"}, new int[]{R.id.filanombre, R.id.filalocalidad});
        nombres.setAdapter(adaptadorLista);

        nombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "ID: " + ids.get(position) + "Nombre: " + nombre.get(position) + " Localidad: " + localidad.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        nombres.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                return false;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.delete(editText.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder d = new AlertDialog.Builder(Main2Activity.this);
                d.setTitle("Actualizar");
                d.setMessage("Pon el nombre a actualizar");
                d.create();
                d.show();

            }
        });

    }
}
