package com.shsany.testapp.example.mvx.mvc.model;

import com.google.firebase.database.DataSnapshot;
import com.shsany.testapp.example.mvx.mvc.interfaces.ModelCallBacks;

import java.util.ArrayList;

/**
 * Created by PC on 2017/12/20.
 */

public class MessageModel {
    private ArrayList<ChatPojo> mMseeages;
    ModelCallBacks mModelCallBacks;
    public MessageModel(ModelCallBacks modelCallBacks){
        this.mModelCallBacks = modelCallBacks;
    }
    public void addMessages(DataSnapshot dataSnapshot){
        if (mMseeages == null){
            mMseeages =new ArrayList<>();
        }
        ChatPojo chatPojo = new ChatPojo(dataSnapshot);
        mMseeages.add(chatPojo);
        mModelCallBacks.onModelUpdated(mMseeages);
    }
}
