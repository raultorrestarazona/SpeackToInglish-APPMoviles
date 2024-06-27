package com.example.appmovilspeakinglish;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.appmovilspeakinglish.Adaptador.AdaptadorDiccionario;
import com.example.appmovilspeakinglish.Dao.DiccionarioDaoImpl;
import com.example.appmovilspeakinglish.Entidad.Diccionario;

import java.util.List;

public class MenuDiccionario extends AppCompatActivity implements View.OnClickListener,  AdapterView.OnItemClickListener {
    Button btnregresard, btnconsultardic;
    EditText edtconsultarpalabra;
    ListView lstPalabras;
    DiccionarioDaoImpl diccionarioDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_diccionario);
        edtconsultarpalabra=(EditText) findViewById(R.id.edtBuscarpalabradic);
        lstPalabras=(ListView) findViewById(R.id.lstPalabras);
        btnregresard = (Button) findViewById(R.id.btnRegresardicc);
        btnconsultardic = (Button) findViewById(R.id.btnConsultardicc);

        btnregresard.setOnClickListener(this);
        btnconsultardic.setOnClickListener(this);
        lstPalabras.setOnItemClickListener(this);

        diccionarioDao= new DiccionarioDaoImpl(this);
        cargar();
    }

    void cargar(){
        //obtener todos los docentes
        List<Diccionario> data=diccionarioDao.listAllDiccionarios();
        //crear objeto de la clase AdaptadorDocente
        AdaptadorDiccionario adapter=new AdaptadorDiccionario(data,this);
        //mostrar adapater dentro del lstDocentes
        lstPalabras.setAdapter(adapter);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //obtener el Docente según donde se realiza click
        Diccionario bean= (Diccionario) lstPalabras.getItemAtPosition(position);
        //crear objeto de la clase Intent
        Intent intent=new Intent(this,MainDatos.class);
        //crear una clave dentro del objeto "intent"
        intent.putExtra("diccionario",bean);
        //direccionar
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if(v == btnregresard){
            startActivity(new Intent(MenuDiccionario.this, com.example.appmovilspeakinglish.MenuPrincipal.class));
            finish();
        }
        if( v == btnconsultardic){
            List<Diccionario> data=diccionarioDao.listAllPorPalabraesp(edtconsultarpalabra.getText().toString());
            //crear objeto de la clase AdaptadorDiccionario
            AdaptadorDiccionario adapter=new AdaptadorDiccionario(data,this);
            //mostrar adapater dentro del lstPalabras
            lstPalabras.setAdapter(adapter);
        }
    }
}