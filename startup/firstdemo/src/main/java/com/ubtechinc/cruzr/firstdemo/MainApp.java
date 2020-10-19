package com.ubtechinc.cruzr.firstdemo;

import android.app.Application;

import androidx.startup.AppInitializer;

public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //也可以手动初始化，如果没有自动的话
//        AppInitializer.getInstance(this).initializeComponent(ExampleLoggerInitializer.class);
    }
}
