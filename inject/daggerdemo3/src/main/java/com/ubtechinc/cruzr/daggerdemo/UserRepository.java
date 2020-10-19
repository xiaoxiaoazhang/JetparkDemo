package com.ubtechinc.cruzr.daggerdemo;

import javax.inject.Inject;
import javax.inject.Singleton;

// Scope this class to a component using @Singleton scope (i.e. ApplicationGraph)
@Singleton
//或者
//@MyCustomScope
public class UserRepository {

    private final UserLocalDataSource userLocalDataSource;
    private final UserRemoteDataSource userRemoteDataSource;

    @Inject //@Inject lets Dagger know how to create instances of this object
    public UserRepository(UserLocalDataSource userLocalDataSource, UserRemoteDataSource userRemoteDataSource) {
        this.userLocalDataSource = userLocalDataSource;
        this.userRemoteDataSource = userRemoteDataSource;
    }
}
