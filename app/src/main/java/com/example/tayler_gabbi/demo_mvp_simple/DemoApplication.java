package com.example.tayler_gabbi.demo_mvp_simple;

import android.app.Application;

import com.example.tayler_gabbi.demo_mvp_simple.database.modelos.DaoMaster;
import com.example.tayler_gabbi.demo_mvp_simple.database.modelos.DaoSession;

import org.greenrobot.greendao.database.Database;


public class DemoApplication extends Application{


    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"mydb");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
