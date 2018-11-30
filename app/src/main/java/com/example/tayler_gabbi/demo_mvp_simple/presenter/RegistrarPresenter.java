package com.example.tayler_gabbi.demo_mvp_simple.presenter;

import com.example.tayler_gabbi.demo_mvp_simple.database.ConexionSQLiteHelper;

public interface RegistrarPresenter {

    void registrarUsuario(String name, String userName, String password, ConexionSQLiteHelper conn);
}
