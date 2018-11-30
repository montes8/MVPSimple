package com.example.tayler_gabbi.demo_mvp_simple.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;

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

    public ConexionSQLiteHelper(Context context, String dbNombre, SQLiteDatabase.CursorFactory factory, int dbVersion) {
        super(context, dbNombre, factory, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(sqlCrearTablaUsuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int versionAntigua, int versionNueva) {

        sqLiteDatabase.execSQL("Drop table IF EXISTS "+ TablaUser);

    }

    public Long insertarUsuario(Usuario usuario){
     SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre",usuario.getNombre());
        values.put("usuario",usuario.getUsuario());
        values.put("contrasenia",usuario.getContrasenia());
        Long ID =db.insert(TablaUser,"",values);
        return ID;
    }


    public ArrayList<Usuario> consultarListaUsuarios() {

        SQLiteDatabase consulta= getReadableDatabase();

        Usuario usuario = null;

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Cursor cursor=consulta.rawQuery("SELECT * FROM "+TablaUser,null);

        while (cursor.moveToNext()){
            usuario = new Usuario();
            usuario.setId(cursor.getLong(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setUsuario(cursor.getString(2));
            usuario.setContrasenia(cursor.getString(3));
        }
        return listaUsuarios;
    }

    public void actualizarUsuario(Usuario usu){

        SQLiteDatabase actualizar= getWritableDatabase();

        String [] parametro = {usu.getId().toString()};

        ContentValues values = new ContentValues();
        values.put(columnaNombre,usu.getNombre());
        values.put(columnaUsuario,usu.getUsuario());
        values.put(columnaContrasenia,usu.getContrasenia());

        actualizar.update(TablaUser,values,columnaID+"=?",parametro);

    }

}
