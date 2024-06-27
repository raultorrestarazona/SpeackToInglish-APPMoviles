package com.example.appmovilspeakinglish;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {
    EditText txtname;
    Button btnirdiccionario,btndinamica,btnrgrdiccionario, btnexit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        txtname = findViewById(R.id.txtPrincipal);
        btnirdiccionario= (Button) findViewById(R.id.btnirdiccionario);
        btndinamica=(Button) findViewById(R.id.btnPresenteDin);
        btnrgrdiccionario=(Button) findViewById(R.id.btnPasadoDin);
        btnexit=(Button) findViewById(R.id.btnRegresarDin);

        btnirdiccionario.setOnClickListener(this);
        btnrgrdiccionario.setOnClickListener(this);
        btndinamica.setOnClickListener(this);
        btnexit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == btnexit){
            Intent intent =new Intent(MenuPrincipal.this, Loginactivity.class);
            Toast.makeText(MenuPrincipal.this, "Cerraste Sesion" , Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        if(v == btnirdiccionario){
            Intent intent1 =new Intent(MenuPrincipal.this, MenuDiccionario.class);
            startActivity(intent1);
        }
        if(v == btnrgrdiccionario){
            Intent intent2 =new Intent(MenuPrincipal.this, MenuRegistraDiccionario.class);
            startActivity(intent2);
        }
        if(v == btndinamica){
            Intent intent2 =new Intent(MenuPrincipal.this, MainDinamicaDic.class);
            startActivity(intent2);
        }
    }
}