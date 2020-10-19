package com.ubtechinc.cruzr.daggerdemo;

import android.app.Application;

public class MainApp extends Application {

    // Reference to the application graph that is used across the whole app
    ApplicationComponent appComponent = DaggerApplicationComponent.create();

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
