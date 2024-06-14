package com.example.appmovilspeakinglish.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appmovilspeakinglish.Data.SqlOpenHelper;
import com.example.appmovilspeakinglish.Entidad.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    SqlOpenHelper admin;

    public UsuarioDao(Context context){
        admin=new SqlOpenHelper(context);
    }
    public int login(String u , String p){
        int a=0;
        SQLiteDatabase base=admin.getReadableDatabase();
        Cursor cursor=base.rawQuery("select *from tb_usuario",null);
        if(cursor!= null && cursor.moveToFirst()){
            do{
                if(cursor.getString(1).equals(u)&&cursor.getString(2).equals(p)){
                    a++;
                }
            }while(cursor.moveToNext());
        }
        return a;
    }
    public int adicionarUsuario(Usuario bean){
        int salida=-1;

        SQLiteDatabase base=admin.getWritableDatabase();

        ContentValues data=new ContentValues();

        data.put("usuario",bean.getUsuario());
        data.put("pass",bean.getPassword());
        data.put("nombre",bean.getNombre());
        data.put("dni",bean.getDni());
        data.put("tlf",bean.getTelefono());
        data.put("corr",bean.getCorreo());
        salida= (int) base.insert("tb_usuario","cod",data);
        return salida;
    }

    public List<Usuario> listAll(){
        List<Usuario> lista=new ArrayList<Usuario>();
        Usuario bean = null;

        SQLiteDatabase base=admin.getReadableDatabase();
        Cursor cursor=base.rawQuery("select *from tb_usuario",null);
        //bucle para realizar recorrido sobre "cursor"
        while(cursor.moveToNext()) {
            bean = new Usuario();
            bean.setCod(cursor.getInt(0));
            bean.setUsuario(cursor.getString(1));
            bean.setPassword(cursor.getString(2));
            bean.setNombre(cursor.getString(3));
            bean.setDni(cursor.getString(4));
            bean.setTelefono(cursor.getString(5));
            bean.setCorreo(cursor.getString(6));
            lista.add(bean);
        }
        return lista;
    }
}
