package com.example.tayler_gabbi.demo_mvp_simple.model;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.tayler_gabbi.demo_mvp_simple.HomeActivity;
import com.example.tayler_gabbi.demo_mvp_simple.database.ConexionSQLiteHelper;
import com.example.tayler_gabbi.demo_mvp_simple.database.Usuario;
import com.example.tayler_gabbi.demo_mvp_simple.presenter.RegistrarPresenter;
import com.example.tayler_gabbi.demo_mvp_simple.view.RegistrarView;


public class PresenterRegistrarImpl implements RegistrarPresenter {

    private RegistrarView registrarView;

    Context context;

    public PresenterRegistrarImpl(RegistrarView registrarView) {
        this.registrarView = registrarView;

    }

    @Override
    public void registrarUsuario(String name, String userName, String password,ConexionSQLiteHelper conn) {

        if(TextUtils.isEmpty(name)){

            registrarView.nameError();

        }else if(TextUtils.isEmpty(userName)){

            registrarView.usuarioError();
        }else if(TextUtils.isEmpty(password)){

            registrarView.passwordError();

        }else {

            Usuario usuarioi = new Usuario();
            usuarioi.setNombre(name);
            usuarioi.setUsuario(userName);
            usuarioi.setContrasenia(password);
            Long idResultante = conn.insertarUsuario(usuarioi);

            if(idResultante !=null && idResultante >0){

                registrarView.registrarSuccess();

            }else {

                registrarView.registerError();
            }



        }
    }
}
