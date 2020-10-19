package com.ubtechinc.cruzr.daggerdemo.dagger;

import com.ubtechinc.cruzr.daggerdemo.MainActivity;

import dagger.Component;

//一个Component 应用多个 module
@Component(modules = {AModule.class, BModule.class})
public interface MultiComponent {
    void inject(MainActivity activity);
}
