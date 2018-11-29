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
    public void perfomLogin(final String userName, final String password) {

        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){

            loginView.loginValidations();

        }else {

        }
    }


}
