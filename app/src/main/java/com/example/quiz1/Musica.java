package com.example.quiz1;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Musica extends AppCompatActivity {
    TextView txt_name,txt_age;

    public static final String dataUserCache = "dataUser";
    private static final int modo_priv = Context.MODE_PRIVATE;
    String Nombre;
    String Edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_musica);

        txt_name = findViewById(R.id.txt_name);
        txt_age = findViewById(R.id.txt_age);

        Nombre = getApplicationContext().getSharedPreferences(dataUserCache,modo_priv).getString("name","0");
        Edad = getApplicationContext().getSharedPreferences(dataUserCache,modo_priv).getString("age","0");

        txt_name.setText(Nombre);
        txt_age.setText(Edad);

    }
}