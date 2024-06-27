package com.example.appmovilspeakinglish.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlOpenHelper extends SQLiteOpenHelper {
    public SqlOpenHelper(Context contexto){
        super(contexto,"SpeakToInglish.db",null,6);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //crear tabla Diccionario
        db.execSQL("create table if not exists tb_dic("+
                "cod_dic integer primary key autoincrement,"+
                "pespanol varchar(40),"+
                "pingles varchar(40))");
        //crear tabla Usuario
        db.execSQL("create table if not exists tb_usuario( " +
                "cod integer primary key autoincrement," +
                " usuario varchar(20)," +
                " pass varchar(40)," +
                "nombre varchar(40)," +
                "dni int," +
                "tlf int," +
                "corr varchar(40))");

        db.execSQL("insert into tb_dic values(null,'buenas noches','good night')");
        db.execSQL("insert into tb_dic values(null,'buenos dias','good morning')");
        db.execSQL("insert into tb_dic values(null,'chau','bye')");
        db.execSQL("insert into tb_dic values(null,'eat','comer')");
        db.execSQL("insert into tb_dic values(null,'sleep','dormir')");

        //Insertamos valores a la tabla usuario
        db.execSQL("insert into tb_usuario values(null,'n00346784','pockemon123','Raul Daniel',78945612,987654321,'n00346784@upn.pe')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists tb_usuario");
        onCreate(db);
    }
}
