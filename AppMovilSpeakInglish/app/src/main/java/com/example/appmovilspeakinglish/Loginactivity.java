package com.example.appmovilspeakinglish;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appmovilspeakinglish.Dao.UsuarioDao;


public class Loginactivity extends AppCompatActivity implements View.OnClickListener {

    Button btnlogin, btncrear;
    EditText user, pass;
    UsuarioDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.txtUsuario);
        pass = findViewById(R.id.txtContraseña);
        btnlogin = findViewById(R.id.btniniciarsesion);
        btnlogin.setOnClickListener(this);
        btncrear = findViewById(R.id.btnCreate);
        btncrear.setOnClickListener(this);
        dao = new UsuarioDao(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnlogin) {
            String u = user.getText().toString();
            String p = pass.getText().toString();
            if (u.equals("") && p.equals("")) {
                Toast.makeText(this, "ERROR: Campos vacios", Toast.LENGTH_SHORT).show();
            } else if (dao.login(u, p) == 1) {
                Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(Loginactivity.this, MenuPrincipal.class);
                startActivity(i2);
            } else if (dao.login(u, p) == 0) {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }
        }
        if (v == btncrear) {
            Intent i = new Intent(Loginactivity.this, RegistrarUsuarioActivity.class);
            startActivity(i);
        }
    }
}