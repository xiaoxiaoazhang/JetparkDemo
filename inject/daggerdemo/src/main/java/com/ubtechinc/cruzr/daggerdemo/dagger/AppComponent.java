package com.ubtechinc.cruzr.daggerdemo.dagger;

import androidx.fragment.app.Fragment;

import dagger.Component;

@Component(modules = {MainModule.class})
public interface AppComponent {
    void inject(Fragment activity);
}
