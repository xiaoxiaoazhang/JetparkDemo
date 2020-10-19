package com.ubtechinc.cruzr.daggerdemo;

import javax.inject.Inject;

public class UserRemoteDataSource {

    private final LoginRetrofitService loginRetrofitService;


//    @Inject //只能有一个构造函数有Inject注解
//    public UserRemoteDataSource() { }

    @Inject
    public UserRemoteDataSource(LoginRetrofitService loginRetrofitService) {
        this.loginRetrofitService = loginRetrofitService;
    }
}
