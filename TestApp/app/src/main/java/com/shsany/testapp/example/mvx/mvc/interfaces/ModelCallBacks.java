package com.shsany.testapp.example.mvx.mvc.interfaces;

import com.shsany.testapp.example.mvx.mvc.model.ChatPojo;

import java.util.ArrayList;

/**
 * Created by PC on 2017/12/20.
 */

public interface ModelCallBacks {
    void onModelUpdated(ArrayList<ChatPojo> messages);
}
