package com.ubtechinc.cruzr.daggerdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LoginService {
    @GET("login")
    Call<Object> login(@Query("name") String name, @Query("password") String password);
}
