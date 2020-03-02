package com.example.IndustryProject.db;

import android.app.Application;

import com.example.IndustryProject.db.AppDB;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDB.createAppDBInstance(this);
    }
}
