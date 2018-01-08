package com.shsany.testapp.example.mvx.mvc.controllers;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.shsany.testapp.R;
import com.shsany.testapp.example.mvx.mvc.utils.MyUtils;

/**
 * Created by PC on 2017/12/20.
 */

public class LoginController extends Activity implements View.OnClickListener{

    private Button mAuth;
    private Button mCreateRoom;
    private Button mEnterExistingRoom;
    private TextView mInfo;
    private Dialog mChatRoomDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_login);

        mAuth = (Button) findViewById(R.id.button_auth);
        mCreateRoom = (Button) findViewById(R.id.button_create_room);
        mEnterExistingRoom = (Button) findViewById(R.id.button_existing_room);
        mInfo= (TextView) findViewById(R.id.text_info);

        mAuth.setOnClickListener(this);
        mCreateRoom.setOnClickListener(this);
        mEnterExistingRoom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_auth:
                firebaseAnonymousAuth();
                break;
            case R.id.button_create_room:
                showRoomDialog();
                break;
            case R.id.button_existing_room:
                showRoomDialog();
                break;
        }
    }

    private void showRoomDialog() {
        mChatRoomDialog=new Dialog(this);
        mChatRoomDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_room,null);
        Button submitRoomName= (Button) view.findViewById(R.id.button_room_submit);
        final EditText editTextRoomName=(EditText) view.findViewById(R.id.edittext_room_name);
        submitRoomName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextRoomName.getText().toString().trim().isEmpty()){
                    Toast.makeText(LoginController.this,"Enter a valid Name",Toast.LENGTH_SHORT).show();
                } else {
                    startChatActivity(editTextRoomName.getText().toString());
                }
            }
        });

        mChatRoomDialog.setContentView(view);
        mChatRoomDialog.show();

    }
    public void startChatActivity(String roomName) {
        mChatRoomDialog.dismiss();
        mChatRoomDialog=null;

        Intent intent=new Intent(this,ChatController.class);
        intent.putExtra(MyUtils.EXTRA_ROOM_NAME,roomName);
        startActivity(intent);
    }

    private void firebaseAnonymousAuth() {
        mAuth.setText(getString(R.string.text_waiting_for_auth));
        FirebaseAuth.getInstance().signInAnonymously()
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()){
                            Toast.makeText(LoginController.this,"Firebase authentication failed, please check your internet connection",Toast.LENGTH_SHORT).show();
                            mAuth.setText(getString(R.string.authentication_label));
                        }
                    }
                });
    }
}
