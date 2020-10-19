package com.ubtechinc.cruzr.daggerdemo.dagger;

import com.ubtechinc.cruzr.daggerdemo.MainActivity;
import com.ubtechinc.cruzr.daggerdemo.bean.MainApi;
import com.ubtechinc.cruzr.daggerdemo.bean.MainChildApi;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class SampleModule {
    private MainActivity activity;

    public SampleModule(MainActivity activity) {
        this.activity = activity;
    }


    @Named("dev")
    @Provides
    MainApi provideMainApiDev(MainChildApi mainChildApi, String url) {
        return new MainApi(mainChildApi, activity,"dev");
    }

    @Named("release")
    @Provides
    MainApi provideMainApiRelease(MainChildApi mainChildApi, String url) {
        return new MainApi(mainChildApi, activity,"release");
    }

}
