package com.ubtechinc.cruzr.daggerdemo.dagger;

import com.ubtechinc.cruzr.daggerdemo.bean.B;

import dagger.Module;
import dagger.Provides;

@Module
public class BModule {

    @Provides
    B providerB() {
        return new B();
    }
}
