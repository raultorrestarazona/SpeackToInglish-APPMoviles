package com.example.appmovilspeakinglish.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.appmovilspeakinglish.Entidad.Diccionario;
import com.example.appmovilspeakinglish.R;

import java.util.List;

public class AdaptadorDiccionario extends ArrayAdapter<Diccionario> {
    //definir dos atributos
    private List<Diccionario> lista;
    private Context contexto;

    public AdaptadorDiccionario(List<Diccionario> lista, Context contexto){
        //invocar al constructor de la clase ArrayAdapter
        super(contexto,0,lista);
        this.contexto=contexto;
        this.lista=lista;
    }

    //método
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View vista=null;
        TextView tvCodigodic,tvpalabraesp,tvpalabraingl;


        //crear objeto de la clase LayoutInflater
        LayoutInflater inflater= (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //obtener el archivo "xml" y convertirlo a un View
        vista  = inflater.inflate(R.layout.activity_data,parent,false);
        //referencias
        tvCodigodic=vista.findViewById(R.id.tvCodigoDic);
        tvpalabraesp=vista.findViewById(R.id.tvPalabraesp);
        tvpalabraingl=vista.findViewById(R.id.tvPalabraingl);
        //mostrar valores en los atributos "tvCodigo,tvNombre,tvApellidos"
        tvCodigodic.setText(lista.get(position).getCodDiccionario()+"");
        tvpalabraesp.setText(lista.get(position).getPalabraesp());
        tvpalabraingl.setText(lista.get(position).getPalabraingl());
        return vista;
    }
}
