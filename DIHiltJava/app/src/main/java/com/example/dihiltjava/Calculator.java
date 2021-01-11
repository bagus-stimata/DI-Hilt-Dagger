package com.example.dihiltjava;

public class Calculator {

    public Integer divider(Integer x, Integer y){
        if (y==0){
            throw new IllegalArgumentException("tidak bisa dibagi dengan kosong");
        }else {
            return x/y;
        }
    }
}
