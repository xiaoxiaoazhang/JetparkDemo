package com.ubtechinc.cruzr.firstdemo;

import android.content.Context;

import androidx.startup.Initializer;

import java.util.Arrays;
import java.util.List;

public class ExampleLoggerInitializer implements Initializer<ExampleLogger> {

    @Override
    public ExampleLogger create(Context context) {
        // WorkManager.getInstance() is non-null only after
        // WorkManager is initialized.
        return new ExampleLogger(WorkManager.getInstance(context));
    }

//    @Override
//    public List<Class<Initializer<?>>> dependencies() {
//        // Defines a dependency on WorkManagerInitializer so it can be
//        // initialized after WorkManager is initialized.
//        return Arrays.asList(WorkManagerInitializer.class);
//    }
    @Override
    public List dependencies() {
        // Defines a dependency on WorkManagerInitializer so it can be
        // initialized after WorkManager is initialized.
        return Arrays.asList(WorkManagerInitializer.class);
    }

}
