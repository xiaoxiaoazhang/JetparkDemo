package com.ubtechinc.cruzr.daggerdemo.dagger;

import com.ubtechinc.cruzr.daggerdemo.bean.A;
import com.ubtechinc.cruzr.daggerdemo.bean.B;

import dagger.Module;
import dagger.Provides;

//第一步 添加@Module 注解
@Module
public class MainModule {

    /***
     * 构造方法需要其他参数时候
     *
     * @return
     */
    @Provides
    B providerB() {
        return new B();
    }

    //第二步 使用Provider 注解 实例化对象
    @Provides
    A providerA(B b) {
        return new A(b);
    }

}
