package com.shsany.testapp.example.car.factory;

import com.shsany.testapp.example.car.faw.FAWVolks;
import com.shsany.testapp.example.car.faw.Magotan;
import com.shsany.testapp.example.car.faw.Sagitar;
import com.shsany.testapp.example.car.insurance.Insurance;
import com.shsany.testapp.example.car.insurance.TowLevel;
import com.shsany.testapp.example.car.volks.Volks;

/**
 * Created by PC on 2017/11/10.
 */

public class FAWVolksFactory extends VolksFactory{

    @Override
    public <T extends Volks> T createVolks(int productID) {
        FAWVolks fawVolks = null;
        switch (productID){
            case Magotan.ID:
                fawVolks =new Magotan();
                break;
            case Sagitar.ID:
                fawVolks = new Sagitar();
                break;
            default:
                fawVolks = null;
        }
        return (T)fawVolks;
    }

    @Override
    public Insurance bindInsucrance() {
        return new TowLevel();
    }
}
