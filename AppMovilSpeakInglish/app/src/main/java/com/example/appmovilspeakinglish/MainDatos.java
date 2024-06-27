package com.example.appmovilspeakinglish;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.appmovilspeakinglish.Dao.DiccionarioDaoImpl;
import com.example.appmovilspeakinglish.Entidad.Diccionario;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class MainDatos extends AppCompatActivity implements View.OnClickListener{

    TextView tvCodigo;
    EditText edtPalabraesp,edtPalabraingl;
    Button btnActualizar,btnEliminar, btnRegresar;

    DiccionarioDaoImpl diccionarioDAO=new DiccionarioDaoImpl(this);
    List<Diccionario> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_datos);
        tvCodigo=(TextView) findViewById(R.id.edtCodigoARD);
        edtPalabraesp=(EditText) findViewById(R.id.edtPalabraespARD);
        edtPalabraingl=(EditText) findViewById(R.id.edtPalabrainglARD);
        btnActualizar=(Button) findViewById(R.id.btnActualizarRD);
        btnEliminar=(Button) findViewById(R.id.btnEliminarRD);
        btnRegresar=(Button) findViewById(R.id.btnRegresarRD);


        btnActualizar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);
        mostrarDatos();
    }

    @Override
    public void onClick(View v) {
        if(v==btnActualizar){
            if(edtPalabraesp.getText().toString().matches("[a-zA-Z\\s]{3,}")==false){
                mensaje("Campo palabras en español solo letras min. 3");
            }
            else if(edtPalabraingl.getText().toString().matches("[a-zA-Z\\s]{3,}")==false){
                mensaje("Campo palabras en ingles solo letras min. 3");
            }
            else {
                //crear objeto de la clase Docente
                Diccionario bean = new Diccionario();
                //setear
                bean.setCodDiccionario(Integer.parseInt(tvCodigo.getText().toString()));
                bean.setPalabraesp(edtPalabraesp.getText().toString());
                bean.setPalabraingl(edtPalabraingl.getText().toString());
                //
                int salida;
                salida=diccionarioDAO.actualizarDiccionario(bean);
                if(salida>0) {
                    mensaje("Diccionario acualizado");
                    edtPalabraesp.setText("");
                    edtPalabraingl.setText("");
                }
                else
                    mensaje("Error en la actualización del Diccionario");
            }
        }
        if(v==btnEliminar){
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Sistema");
            dialogo1.setMessage("¿ Seguro de elimiar registro?");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    int salida;
                    salida=diccionarioDAO.eliminarDiccionario(Integer.parseInt(tvCodigo.getText().toString()));
                    if(salida>0)
                        mensaje("Diccionario eliminado");
                    else
                        mensaje("Error en la eliminación del Diccionario");
                }
            });
            dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {

                }
            });
            dialogo1.setIcon(android.R.drawable.ic_dialog_alert);
            dialogo1.show();
        }
        if(v==btnRegresar){
            Intent intent=new Intent(this, MenuRegistraDiccionario.class);
            startActivity(intent);
        }

    }
    void mostrarDatos(){
        //recuperar clave "diccionerio"
        Diccionario bean= (Diccionario) getIntent().getSerializableExtra("diccionario");
        tvCodigo.setText(bean.getCodDiccionario()+"");
        edtPalabraesp.setText(bean.getPalabraesp());
        edtPalabraingl.setText(bean.getPalabraingl()+"");
    }
    void mensaje(String m){
        Toast.makeText(this,m,Toast.LENGTH_LONG).show();
    }
}