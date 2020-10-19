package com.ubtechinc.cruzr.firstdemo;

import android.content.Context;

import androidx.startup.Initializer;

import java.util.List;

import static java.util.Collections.emptyList;

public class WorkManagerInitializer implements Initializer<WorkManager> {

    @Override
    public WorkManager create(Context context) {
        WorkManager.initialize(context);
        return WorkManager.getInstance(context);
    }

//    @Override
//    public List<Class<Initializer<?>>> dependencies() {
//        // No dependencies on other libraries.
//        return emptyList(); //如果不依赖其他的模块
//    }
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        // No dependencies on other libraries.
        return emptyList(); //如果不依赖其他的模块
    }
}
