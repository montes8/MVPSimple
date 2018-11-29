package com.example.tayler_gabbi.demo_mvp_simple.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSQLiteHelper extends SQLiteOpenHelper{


    String dbNombre="database";
    Integer dbVersion = 1;

    String TablaUser ="USUARIO";
    String columnaID ="id";
    String columnaNombre ="nombre";
    String columnaUsuario ="usuario";
    String columnaContrasenia ="contrasenia";
    //creamos la tabla de categorias
    String sqlCrearTablaUsuario ="CREATE TABLE IF NOT EXISTS " + TablaUser +" ("+ columnaID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            columnaNombre +" TEXT NOT NULL,"+
            columnaUsuario +" TEXT NOT NULL,"+
            columnaContrasenia +" TEXT NOT NULL)";

    public ConexionSQLiteHelper(Context context, String dbNombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbNombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCrearTablaUsuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionAntigua, int versionNueva) {

        sqLiteDatabase.execSQL("Drop table IF EXISTS "+ TablaUser);

    }
}
