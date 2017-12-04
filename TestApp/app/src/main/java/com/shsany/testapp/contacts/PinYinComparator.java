package com.shsany.testapp.contacts;

import java.util.Comparator;

/**
 * 用来对ListView中的数据根据A-Z进行排序，前面两个if判断主要是将不是以汉字开头的数据放在后面
 * Created by PC on 2017/10/13.
 */

public class PinYinComparator implements Comparator<PersonBean> {
    @Override
    public int compare(PersonBean o1, PersonBean o2) {
        //这里主要是用来对ListView里面的数据根据ABCDEFG...来排序
        if (o1.getInitial().equals("@")
                || o2.getInitial().equals("#")) {
            return -1;
        } else if (o1.getInitial().equals("#")
                || o2.getInitial().equals("@")) {
            return 1;
        } else {
            return o1.getInitial().compareTo(o2.getInitial());
        }
    }
}
