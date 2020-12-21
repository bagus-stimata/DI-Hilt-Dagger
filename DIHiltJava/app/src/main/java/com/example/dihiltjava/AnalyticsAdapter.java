package com.example.dihiltjava;

import android.util.Log;

import javax.inject.Inject;


public class AnalyticsAdapter {

    /**
     * yang di inject adalah konstruktornya
      */
    @Inject
    public AnalyticsAdapter(){
        Log.d("Hello ", "Ini dari KOnstruktur AnalyticsAdapter");
    }

//    @Inject -> Tidak bisa dilakukan disini, kerena untuk field injection hanya konstruktor tanpa parameter yang bisa diinject
    public AnalyticsAdapter(AnalyticsService service){
    }

}
