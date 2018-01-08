package com.shsany.testapp.example.mvx.mvc.interfaces;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by PC on 2017/12/20.
 */

public interface FirebaseCallBacks {
    void onNewMessage(DataSnapshot dataSnapshot);
}
