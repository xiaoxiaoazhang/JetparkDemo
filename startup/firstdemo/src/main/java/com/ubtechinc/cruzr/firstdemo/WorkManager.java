package com.ubtechinc.cruzr.firstdemo;

import android.content.Context;
import android.util.Log;

public class WorkManager {

    private static WorkManager instance = null;
    private WorkManager() {
        Log.d("WorkManager", "WorkManager created");
    }

    public static WorkManager getInstance(Context context) {
        if(null == instance) {
            instance = new WorkManager();
        }
        return instance;
    }
    public static void initialize(Context context) {

    }
}
