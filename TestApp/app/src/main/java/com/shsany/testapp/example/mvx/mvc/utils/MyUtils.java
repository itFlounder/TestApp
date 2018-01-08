package com.shsany.testapp.example.mvx.mvc.utils;

import android.icu.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by PC on 2017/12/20.
 */

public class MyUtils {
    public static String EXTRA_ROOM_NAME ="EXTRA_ROOM_NAME";

    public static String convertTime(long timestamp){
        Calendar c= Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = new Date(timestamp);
        sdf.setTimeZone(TimeZone.getDefault());
        return  sdf.format(date);

    }
}
