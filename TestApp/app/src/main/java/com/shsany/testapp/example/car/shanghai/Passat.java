package com.shsany.testapp.example.car.shanghai;

/**
 * Created by PC on 2017/11/10.
 */

public class Passat implements ShangHaiVolks{
    public static final int ID = 0;

    @Override
    public void drive() {
        System.out.println("Passat drive success");
    }

    @Override
    public String getName() {
        return "Passat";
    }
}
