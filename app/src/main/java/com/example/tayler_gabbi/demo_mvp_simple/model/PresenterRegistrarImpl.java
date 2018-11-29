package com.example.tayler_gabbi.demo_mvp_simple.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.example.tayler_gabbi.demo_mvp_simple.database.ConexionSQLiteHelper;
import com.example.tayler_gabbi.demo_mvp_simple.presenter.RegistrarPresenter;
import com.example.tayler_gabbi.demo_mvp_simple.view.RegistrarView;


public class PresenterRegistrarImpl implements RegistrarPresenter {

    private RegistrarView registrarView;

    Context context;

    public PresenterRegistrarImpl(RegistrarView registrarView) {
        this.registrarView = registrarView;

    }

    @Override
    public void registrarUsuario(String name, String userName, String password) {

        if(TextUtils.isEmpty(name)){

            registrarView.nameError();

        }else if(TextUtils.isEmpty(userName)){

            registrarView.usuarioError();
        }else if(TextUtils.isEmpty(password)){

            registrarView.passwordError();

        }else {
            registrarView.registrarSuccess();

        }
    }
}
