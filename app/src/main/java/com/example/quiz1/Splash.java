package com.example.quiz1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash extends AppCompatActivity {
    public static final String dataUserCache = "dataUser";
    private static final int modo_priv = Context.MODE_PRIVATE;
    String Nombre;
    String Edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        
        validarGuardar();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(dataUserCache, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.apply();
                if (Nombre.equalsIgnoreCase("0")||Edad.equalsIgnoreCase("0")){
                    Intent i = new Intent(Splash.this,MainActivity.class);
                    startActivity(i);
                }


            }
        }, 2000);



    }

    private void validarGuardar() {
        Nombre = getApplicationContext().getSharedPreferences(dataUserCache,modo_priv).getString("name","0");
        Edad = getApplicationContext().getSharedPreferences(dataUserCache,modo_priv).getString("age","0");

    }
}