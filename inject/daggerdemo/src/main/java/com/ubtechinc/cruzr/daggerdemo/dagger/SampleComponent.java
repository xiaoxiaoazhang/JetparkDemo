package com.ubtechinc.cruzr.daggerdemo.dagger;

import com.ubtechinc.cruzr.daggerdemo.MainActivity;

import dagger.Component;

@Component(modules = {SampleModule.class})
public interface SampleComponent {
    void inject(MainActivity activity);
}
