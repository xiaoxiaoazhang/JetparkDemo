package com.ubtechinc.cruzr.daggerdemo.dagger;

import com.ubtechinc.cruzr.daggerdemo.bean.A;
import com.ubtechinc.cruzr.daggerdemo.bean.B;

import dagger.Module;
import dagger.Provides;

//模块之间的依赖关系
@Module(includes = {BModule.class})// includes 引入,这样的话，Dagger会现在A moudule 中寻找对象，如果没找到，会去找module B 中是否有被Inject注解的对象，如果还是没有，那么GG，抛出异常
public class AModule {

    @Provides
    A providerA(B b) {
        return new A(b);
    }
}
