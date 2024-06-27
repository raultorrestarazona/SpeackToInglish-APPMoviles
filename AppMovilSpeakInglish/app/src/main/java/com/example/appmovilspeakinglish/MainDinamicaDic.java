package com.example.appmovilspeakinglish;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appmovilspeakinglish.databinding.ActivityMainDinamicaDicBinding;

public class MainDinamicaDic extends AppCompatActivity implements View.OnClickListener{

    Button btnPresenteDIN, btnPasadoDIN;
    Button btnRegresarMP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dinamica_dic);
        btnPresenteDIN=(Button) findViewById(R.id.btnPresenteDin);
        btnPasadoDIN=(Button) findViewById(R.id.btnPasadoDin);
        btnRegresarMP=(Button) findViewById(R.id.btnRegresarDin);

        btnPresenteDIN.setOnClickListener(this);
        btnPasadoDIN.setOnClickListener(this);
        btnRegresarMP.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v== btnPresenteDIN){
            mensaje("Es incorrecto, vuelve a intentarlo");
            startActivity(new Intent(MainDinamicaDic.this, com.example.appmovilspeakinglish.MenuPrincipal.class));
            finish();
        }
        if(v== btnPasadoDIN){
            mensaje("Muy bien hecho, Felicitaciones");
        }
        if(v==btnRegresarMP){
            startActivity(new Intent(MainDinamicaDic.this, com.example.appmovilspeakinglish.MenuPrincipal.class));
            finish();
        }

    }
    void mensaje(String m){
        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }
}