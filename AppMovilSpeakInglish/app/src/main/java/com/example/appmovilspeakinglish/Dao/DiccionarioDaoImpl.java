package com.example.appmovilspeakinglish.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appmovilspeakinglish.Data.SqlOpenHelper;
import com.example.appmovilspeakinglish.Entidad.Diccionario;

import java.util.ArrayList;
import java.util.List;

public class DiccionarioDaoImpl {
    //atributo de la clase SqlOpenHelper
    SqlOpenHelper admin;

    //constructor
    public DiccionarioDaoImpl(Context contexto){
        admin=new SqlOpenHelper(contexto);
    }

    public List<Diccionario> listAllDiccionarios(){
        List<Diccionario> lista=new ArrayList<Diccionario>();
        Diccionario bean = null;
        //crear un objeto de la clase SQLiteDatabase en modo lectura
        SQLiteDatabase base=admin.getReadableDatabase();
        //objeto de la clase Cursor para almacenar el contenido de un SELECT
        Cursor cursor=base.rawQuery("select * from tb_dic",null);
        //bucle para realizar recorrido sobre "cursor"
        while(cursor.moveToNext()) {
            bean = new Diccionario();
            bean.setCodDiccionario(cursor.getInt(0));
            bean.setPalabraesp(cursor.getString(1));
            bean.setPalabraingl(cursor.getString(2));
            lista.add(bean);
        }
        return lista;
    }

    public List<Diccionario> listAllPorPalabraesp(String palabraesp){
        List<Diccionario> lista=new ArrayList<Diccionario>();
        Diccionario bean = null;
        //crear un objeto de la clase SQLiteDatabase en modo lectura
        SQLiteDatabase base=admin.getReadableDatabase();
        //objeto de la clase Cursor para almacenar el contenido de un SELECT
        String SQL="select * from tb_dic where pespanol like ?";
        Cursor cursor=base.rawQuery(SQL,new String[]{palabraesp+"%"});
        //bucle para realizar recorrido sobre "cursor"
        while(cursor.moveToNext()) {
            bean = new Diccionario();
            bean.setCodDiccionario(cursor.getInt(0));
            bean.setPalabraesp(cursor.getString(1));
            bean.setPalabraingl(cursor.getString(2));
            lista.add(bean);
        }
        return lista;
    }

    public int adicionarDiccionario(Diccionario bean){
        int salida=-1;
        //crear un objeto de la clase SQLiteDatabase en modo escritura
        SQLiteDatabase base=admin.getWritableDatabase();
        //crear objeto de la clase ContentValues
        ContentValues data=new ContentValues();
        //crear claves según los campos de la tabla "tb_diccionario"
        data.put("pespanol",bean.getPalabraesp());
        data.put("pingles",bean.getPalabraingl());
        salida= (int) base.insert("tb_dic","cod_dic",data);
        return salida;
    }

    public int actualizarDiccionario(Diccionario bean){
        int salida=-1;
        SQLiteDatabase base=admin.getWritableDatabase();
        ContentValues data=new ContentValues();
        data.put("pespanol",bean.getPalabraesp());
        data.put("pingles",bean.getPalabraingl());
        salida=base.update("tb_dic",data,"cod_dic="+bean.getCodDiccionario(),null);
        return salida;
    }
    public int eliminarDiccionario(int codigo) {
        int salida = -1;
        SQLiteDatabase base = admin.getWritableDatabase();
        salida=base.delete("tb_dic","cod_dic="+codigo,null);
        return salida;
    }
}
