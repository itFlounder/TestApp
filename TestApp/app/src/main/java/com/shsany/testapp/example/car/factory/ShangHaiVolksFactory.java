package com.shsany.testapp.example.car.factory;

import com.shsany.testapp.example.car.insurance.Insurance;
import com.shsany.testapp.example.car.insurance.OneLevel;
import com.shsany.testapp.example.car.shanghai.Passat;
import com.shsany.testapp.example.car.shanghai.Polo;
import com.shsany.testapp.example.car.shanghai.ShangHaiVolks;
import com.shsany.testapp.example.car.volks.Volks;

/**
 * Created by PC on 2017/11/10.
 */

public class ShangHaiVolksFactory extends VolksFactory {

    @Override
    public <T extends Volks> T createVolks(int productID) {
        ShangHaiVolks shangHaiVolks = null;
        switch (productID){
            case Passat.ID:
                shangHaiVolks =new Passat();
                break;
            case Polo.ID:
                shangHaiVolks = new Polo();
                break;
            default:
                shangHaiVolks = null;
        }
        return (T)shangHaiVolks;
    }

    @Override
    public Insurance bindInsucrance() {
        return new OneLevel();
    }
}
