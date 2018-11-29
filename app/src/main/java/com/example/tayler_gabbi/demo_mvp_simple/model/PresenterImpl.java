package com.example.tayler_gabbi.demo_mvp_simple.model;

import android.text.TextUtils;
import android.util.Log;
import com.example.tayler_gabbi.demo_mvp_simple.database.modelos.Usuario;
import com.example.tayler_gabbi.demo_mvp_simple.database.modelos.UsuarioDao;
import com.example.tayler_gabbi.demo_mvp_simple.presenter.LoginPresenter;
import com.example.tayler_gabbi.demo_mvp_simple.view.LoginView;

import java.util.ArrayList;

public class PresenterImpl implements LoginPresenter {

    LoginView loginView;
    private UsuarioDao usuarioDao;

    public PresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void perfomLogin(final String userName, final String password) {

        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){

            loginView.loginValidations();

        }else {

            ArrayList<Usuario> listUsuario = (ArrayList<Usuario>) usuarioDao.queryBuilder().where(UsuarioDao.Properties.Usuario.eq(userName)).list();
            Log.d("validaciologin",""+ listUsuario);
            if(listUsuario!= null && listUsuario.size() > 0) {

                loginView.loginSuccess();

            } else {

                loginView.loginError();
            }
        }
    }


}
