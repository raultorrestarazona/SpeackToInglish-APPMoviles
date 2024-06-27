package com.example.appmovilspeakinglish;

import android.content.Intent;
import android.os.Bundle;

import com.example.appmovilspeakinglish.Dao.DiccionarioDaoImpl;
import com.example.appmovilspeakinglish.Entidad.Diccionario;
import com.example.appmovilspeakinglish.Entidad.Usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MenuRegistraDiccionario extends AppCompatActivity implements View.OnClickListener {

    Button btnregistardic, btnregresarregdic;
    EditText edtpalabraesp, edtpalabraingl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_registra_diccionario);
        edtpalabraesp= (EditText) findViewById(R.id.edtpalabraespa);
        edtpalabraingl=(EditText) findViewById(R.id.edtpalabraingles);
        btnregistardic=(Button) findViewById(R.id.btnrgrdic);
        btnregresarregdic=(Button) findViewById(R.id.btnregresarrgrdic);

        btnregistardic.setOnClickListener(this);
        btnregresarregdic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnregistardic){
            if(edtpalabraesp.getText().toString().matches("[a-zA-Z\\s]{1,}")==false){
                mensaje("Campo palabra en español min. 1 caracteres");
            }
            else if(edtpalabraingl.getText().toString().matches("[a-zA-Z\\s]{1,}")==false){
                mensaje("Campo palabra en ingles min. 1 caracteres");
            }
            else {
                DiccionarioDaoImpl diccionarioDAO = new DiccionarioDaoImpl(this);
                //crear objeto de la clase Diccionario
                Diccionario bean = new Diccionario();
                //setear
                bean.setPalabraesp(edtpalabraesp.getText().toString());
                bean.setPalabraingl(edtpalabraingl.getText().toString());
                //
                int salida;
                salida= diccionarioDAO.adicionarDiccionario(bean);
                if(salida>0) {
                    mensaje("Nueva Palabra registrada");
                    edtpalabraesp.setText("");
                    edtpalabraingl.setText("");
                }
                else
                    mensaje("Error en el registro de la nueva palabra para el diccionario");
            }
        }
        if(v==btnregresarregdic){
            Intent intent=new Intent(this,MenuPrincipal.class);
            startActivity(intent);
        }
    }
    void mensaje(String m){
        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }
}