package com.shsany.testapp.example.car.faw;

/**
 * Created by PC on 2017/11/10.
 */

public class Magotan implements FAWVolks{
    public static final int ID = 3;
    @Override
    public void drive() {
        System.out.println("FAW Magotan drive success");
    }

    @Override
    public String getName() {
        return "Magotan";
    }

    @Override
    public void brake() {
        System.out.println("FAW Magotan brake success");
    }
}
