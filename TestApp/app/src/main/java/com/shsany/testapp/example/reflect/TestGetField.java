package com.shsany.testapp.example.reflect;

import java.lang.reflect.Field;

/**
 * Created by PC on 2017/12/6.
 */

public class TestGetField {
    /**
     * 利用反射操作类的字段
     * 1 getFields()获取类的字段，但是获取不到私有字段
     * 2 getDeclaredFields()获取类的所有字段
     * 3 获取指定的字段及其type
     * 4 获取指定对象的某个字段值
     * 5 设置指定对象的某个字段值
     * @param args
     */
    public static void main(String[] args){
        try{
            Class clazz = Class.forName("com.shsany.testapp.example.reflect.Girl");

            Field[] fields = clazz.getFields();
            for (Field field : fields){
                System.out.println("field = " +field);
            }

            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field: declaredFields){
                System.out.println("declaredFields = " +field);
            }

            //获取指定字段及其类型
            Field field = clazz.getDeclaredField("name");
            Class type = field.getType();
            System.out.println("field = " +field+",type = "+ type);

            //获取指定对象的某个字段值
            Girl girl = new Girl("nick",60,100,90,16);
            field.setAccessible(true);
            String name = (String)field.get(girl);
            System.out.println("name = " +name);

            //设置指定对象的摸个字段值
            field.setAccessible(true);
            field.set(girl,"scale");
            System.out.println("girl = " +girl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
