package com.ubtechinc.cruzr.daggerdemo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

// @Module informs Dagger that this class is a Dagger Module
@Module
public class NetworkModule {
    @Singleton
    // @Provides tell Dagger how to create instances of the type that this function
    // returns (i.e. LoginRetrofitService).
    // Function parameters are the dependencies of this type.
    @Provides
    public LoginService provideLoginService() {
        // Whenever Dagger needs to provide an instance of type LoginRetrofitService,
        // this code (the one inside the @Provides method) is run.
        return new Retrofit.Builder()
                .baseUrl("https://example.com")
                .build()
                .create(LoginService.class);
    }
    @Singleton
    @Provides
    public LoginRetrofitService provideLoginRetrofitService(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://example.com")
                .build()
                .create(LoginRetrofitService.class);
    }
}
