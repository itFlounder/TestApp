package com.shsany.testapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by PC on 2017/11/7.
 */
public class CalculatorTest {
    private Calculator mCalculator;
    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @Test
    public void sum() throws Exception {
        Assert.assertEquals(6d,mCalculator.sum(1d,5d),0);
    }

    @Test
    public void substract() throws Exception {
        Assert.assertEquals(6d,mCalculator.substract(7d,1d),0);
    }

    @Test
    public void multiply() throws Exception {
        Assert.assertEquals(18d,mCalculator.multiply(3d,6d),0);
    }

    @Test
    public void divide() throws Exception {
        Assert.assertEquals(4.5d,mCalculator.divide(9d,2d),0);
    }

}