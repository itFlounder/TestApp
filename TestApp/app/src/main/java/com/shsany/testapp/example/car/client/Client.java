package com.shsany.testapp.example.car.client;

import com.shsany.testapp.example.car.factory.FAWVolksFactory;
import com.shsany.testapp.example.car.factory.ShangHaiVolksFactory;
import com.shsany.testapp.example.car.factory.VolksFactory;
import com.shsany.testapp.example.car.faw.FAWVolks;
import com.shsany.testapp.example.car.faw.Magotan;
import com.shsany.testapp.example.car.faw.Sagitar;
import com.shsany.testapp.example.car.insurance.Insurance;
import com.shsany.testapp.example.car.shanghai.Passat;
import com.shsany.testapp.example.car.shanghai.Polo;
import com.shsany.testapp.example.car.shanghai.ShangHaiVolks;

/**
 * Created by PC on 2017/11/10.
 */

public class Client {
    public static void main(String[] args){
        System.out.println("start test ShanghaiVolks");
//        ShangHaiVolksFactory shFactory = new ShangHaiVolksFactory();
        VolksFactory shFactory = new ShangHaiVolksFactory();
        ShangHaiVolks passat = shFactory.createVolks(Passat.ID);
        passat.drive();

        ShangHaiVolks polo =shFactory.createVolks(Polo.ID);
        polo.drive();
        Insurance shanghaiInsurance = shFactory.bindInsucrance();
        System.out.println(shanghaiInsurance.getName());

        System.out.println("start test FAWVolks");
        VolksFactory fawFactory = new FAWVolksFactory();
        FAWVolks magoton = fawFactory.createVolks(Magotan.ID);
        magoton.drive();
        magoton.brake();
        FAWVolks sagitar = fawFactory.createVolks(Sagitar.ID);
        sagitar.drive();
        sagitar.brake();
        Insurance fawInsurance = fawFactory.bindInsucrance();
        System.out.println(fawInsurance.getName());
    }
}
