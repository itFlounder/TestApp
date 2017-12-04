package com.shsany.testapp.example.car.factory;

import com.shsany.testapp.example.car.insurance.Insurance;
import com.shsany.testapp.example.car.volks.Volks;

/**
 * Created by PC on 2017/11/10.
 */

public abstract class VolksFactory {

    public abstract <T extends Volks>T createVolks(int productID);

    public abstract Insurance bindInsucrance();

   /**
    * 反射获取
    * 例子：
      public final Volks createVolks(Class<? extends Volks> clazz){
        Volks volks = null;
        try{
            volks = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return volks;
    }
    */
//   public abstract <T extends Volks> T createVolks(Class<? extends Volks> clazz);

}
