package com.example.dihiltjava;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyHiltApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
