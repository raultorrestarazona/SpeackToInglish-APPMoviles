package com.example.appmovilspeakinglish;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appmovilspeakinglish.Dao.UsuarioDao;
import com.example.appmovilspeakinglish.Entidad.Usuario;

public class RegistrarUsuarioActivity extends AppCompatActivity implements View.OnClickListener{

    EditText usuario,pass,nom,corr,dni,tlf;
    Button crear_usuario,regresar;
    UsuarioDao dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        usuario =  findViewById(R.id.txtUsuario);
        pass =  findViewById(R.id.txtContraseña);
        nom = findViewById(R.id.txtNomApe);
        dni =  findViewById(R.id.txtDni);
        tlf = findViewById(R.id.txtTelefono);
        corr = findViewById(R.id.txtCorreo);
        crear_usuario=(Button) findViewById(R.id.btncreaausuario);
        regresar= findViewById(R.id.btncancelar);
        crear_usuario.setOnClickListener(this);
        regresar.setOnClickListener(this);
        dao =new UsuarioDao(this);
    }

    @Override
    public void onClick(View v) {
        if(v== crear_usuario) {
            Usuario u = new Usuario();
            u.setUsuario(usuario.getText().toString());
            u.setPassword(pass.getText().toString());
            u.setNombre(nom.getText().toString());
            u.setDni(dni.getText().toString());
            u.setTelefono(tlf.getText().toString());
            u.setCorreo(corr.getText().toString());
            if (!u.isNull()) {
                Toast.makeText(this, "Registro erroneo", Toast.LENGTH_SHORT).show();
            } else if (dao.adicionarUsuario(u) > 0) {
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(RegistrarUsuarioActivity.this, Loginactivity.class);
                startActivity(i2);
                finish();
            } else {
                Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
            }
        }
        if(v== regresar){
            Intent i = new Intent(RegistrarUsuarioActivity.this, Loginactivity.class);
            startActivity(i);
            finish();
        }
    }
}