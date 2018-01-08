package com.shsany.testapp.example.mvx.mvc.controllers;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.shsany.testapp.R;
import com.shsany.testapp.example.mvx.mvc.interfaces.FirebaseCallBacks;
import com.shsany.testapp.example.mvx.mvc.interfaces.ModelCallBacks;
import com.shsany.testapp.example.mvx.mvc.managers.FirebaseManager;
import com.shsany.testapp.example.mvx.mvc.model.ChatPojo;
import com.shsany.testapp.example.mvx.mvc.model.MessageModel;
import com.shsany.testapp.example.mvx.mvc.utils.MyUtils;
import com.shsany.testapp.example.mvx.mvc.views.ChatAdapters;

import java.util.ArrayList;

/**
 * Created by PC on 2017/12/20.
 */

public class ChatController extends Activity implements View.OnClickListener ,FirebaseCallBacks,ModelCallBacks{

    private String mRoomName;
    private EditText mEdittextChat;
    private RecyclerView mRecyclerView;
    private MessageModel mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        mRoomName = getIntent().getStringExtra(MyUtils.EXTRA_ROOM_NAME);
        mModel = new MessageModel(this);
        setListener(mRoomName);

        mEdittextChat=(EditText) findViewById(R.id.edittext_chat_message);
        mRecyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.button_send_message).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_send_message:
                sendMessageToFirebase(mRoomName,mEdittextChat.getText().toString());
                break;
        }
    }

    private void sendMessageToFirebase(String mRoomName, String s) {
        if (!s.trim().equals("")){
            FirebaseManager.getInstance(mRoomName,this).sendMessageToFirebase(s);
        }
        mEdittextChat.setText("");
    }

    @Override
    public void onNewMessage(DataSnapshot dataSnapshot) {
        mModel.addMessages(dataSnapshot);
    }

    @Override
    public void onModelUpdated(ArrayList<ChatPojo> messages) {
        if (messages.size()>0) {
            updateList(messages);
        }
    }

    private void updateList(ArrayList<ChatPojo> messages) {
        ChatAdapters chat = new ChatAdapters(this,messages);
        mRecyclerView.setAdapter(chat);
        mRecyclerView.scrollToPosition(messages.size()-1);
    }

    public void setListener(String listener) {
        FirebaseManager.getInstance(listener,this).addMessageListeners();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FirebaseManager.getInstance(mRoomName,this).removeListeners();
        FirebaseManager.getInstance(mRoomName,this).destroy();
    }
}
