package com.shsany.testapp.example.car.faw;

/**
 * Created by PC on 2017/11/10.
 */

public class Sagitar implements FAWVolks{
    public static final int ID = 4;

    @Override
    public void drive() {
        System.out.println("FAW Sagitar drive success");
    }

    @Override
    public String getName() {
        return "Sagitar";
    }

    @Override
    public void brake() {
        System.out.println("FAW Sagitar brake success");

    }
}
