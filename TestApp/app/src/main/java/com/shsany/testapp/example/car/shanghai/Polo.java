package com.shsany.testapp.example.car.shanghai;

/**
 * Created by PC on 2017/11/10.
 */

public class Polo implements ShangHaiVolks{
    public static final int ID = 1;
    @Override
    public void drive() {
        System.out.println("Polo drive success");
    }

    @Override
    public String getName() {
        return "Polo";
    }
}
