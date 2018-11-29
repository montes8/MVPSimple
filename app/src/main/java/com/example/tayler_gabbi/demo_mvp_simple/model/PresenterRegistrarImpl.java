package com.example.tayler_gabbi.demo_mvp_simple.model;

import android.text.TextUtils;

import com.example.tayler_gabbi.demo_mvp_simple.database.modelos.DaoSession;
import com.example.tayler_gabbi.demo_mvp_simple.database.modelos.Usuario;
import com.example.tayler_gabbi.demo_mvp_simple.presenter.RegistrarPresenter;
import com.example.tayler_gabbi.demo_mvp_simple.view.RegistrarView;


public class PresenterRegistrarImpl implements RegistrarPresenter {

    private RegistrarView registrarView;
    private DaoSession daoSession;

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
            Usuario usuario = new Usuario();
            usuario.setNombre(name);
            usuario.setUsuario(userName);
            usuario.setContrasenia(password);
            Long a=daoSession.getUsuarioDao().insert(usuario);
            registrarView.registrarSuccess();
        }
    }
}
