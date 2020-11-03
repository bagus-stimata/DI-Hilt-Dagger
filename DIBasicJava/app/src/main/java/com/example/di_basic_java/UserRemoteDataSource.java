package com.example.di_basic_java;

import retrofit2.Retrofit;

public class UserRemoteDataSource {
    private final Retrofit retrofit;

    public UserRemoteDataSource(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
}
