package com.shsany.testapp.example.expandable;

/**
 * Created by PC on 2018/1/5.
 */

public class Item {
    private int resId;
    private String name;
    private String detail;

    public Item(int resId, String name, String detail) {
        this.resId  = resId;
        this.name   = name;
        this.detail = detail;
    }
    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String toString() {
        return "Item[" + resId + ", " + name + ", " + detail + "]";
    }

}
