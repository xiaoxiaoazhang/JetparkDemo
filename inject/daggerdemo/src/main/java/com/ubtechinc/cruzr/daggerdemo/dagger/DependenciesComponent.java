package com.ubtechinc.cruzr.daggerdemo.dagger;

import com.ubtechinc.cruzr.daggerdemo.MainActivity;

import dagger.Component;

//@Component(modules = {MainModule.class}, dependencies = AppComponent.class)
public interface DependenciesComponent {
    void inject(MainActivity activity);
}
