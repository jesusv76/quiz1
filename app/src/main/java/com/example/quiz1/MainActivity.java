package com.example.quiz1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt_nombre,edt_edad;
    Button btn_guardar;

    Spinner Opciones;

    public static final String dataUserCache = "dataUser";
    private static final int modo_priv = Context.MODE_PRIVATE;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edt_edad = findViewById(R.id.edt_edad);
        edt_nombre = findViewById(R.id.edt_nombre);
        btn_guardar = findViewById(R.id.btn_guardar);
        Opciones = findViewById(R.id.selector);

        sharedPreferences  = getSharedPreferences(dataUserCache,modo_priv);
        editor = sharedPreferences.edit();


        String[] opciones = {"Deporte", "Musica", "Cine"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        Opciones.setAdapter(adapter);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procesar();
            }

            private void procesar() {

                String nombre = edt_nombre.getText().toString();
                String edad = edt_edad.getText().toString();
                String seleccion = Opciones.getSelectedItem().toString();

                if (nombre.isEmpty() || edad.isEmpty()) {
                    Toast.makeText(MainActivity.this, "por favor llenar todos los campos", Toast.LENGTH_LONG).show();
                } else {
                    if (seleccion.equals("Deporte")) {
                        editor.putString("name", edt_nombre.getText().toString());
                        editor.putString("age", edt_edad.getText().toString());
                        editor.commit();
                        Intent i = new Intent(MainActivity.this, Deporte.class);
                        startActivity(i);;
                    } else if (seleccion.equals("Musica")) {
                        editor.putString("name", edt_nombre.getText().toString());
                        editor.putString("age", edt_edad.getText().toString());
                        editor.commit();
                        Intent i = new Intent(MainActivity.this, Musica.class);
                        startActivity(i);;
                    } else if (seleccion.equals("Cine")) {
                        editor.putString("name", edt_nombre.getText().toString());
                        editor.putString("age", edt_edad.getText().toString());
                        editor.commit();
                        Intent i = new Intent(MainActivity.this, Cine.class);
                        startActivity(i);;
                    }
                }

            }

        }
        );






    }
}