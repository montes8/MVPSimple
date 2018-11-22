package com.example.tayler_gabbi.demo_mvp_simple.model;

import android.text.TextUtils;

import com.example.tayler_gabbi.demo_mvp_simple.presenter.LoginPresenter;
import com.example.tayler_gabbi.demo_mvp_simple.view.LoginView;

public class PresenterImpl implements LoginPresenter {

    LoginView loginView;

    public PresenterImpl(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void perfomLogin(String userName, String password) {

        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){

            loginView.loginValidations();

        }else {

            if(userName.equals("tayler") && password.equals("tayler")){

                loginView.loginSuccess();
            }else {

                loginView.loginError();
            }
        }

    }
}
