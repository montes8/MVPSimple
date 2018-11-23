package com.example.tayler_gabbi.demo_mvp_simple.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.example.tayler_gabbi.demo_mvp_simple.database.dao.UsuarioDao;
import com.example.tayler_gabbi.demo_mvp_simple.database.modelos.Usuario;

@Database(entities = { Usuario.class},version = 1)
public abstract class DataBase extends RoomDatabase{

    public abstract UsuarioDao usuarioDao();
}
