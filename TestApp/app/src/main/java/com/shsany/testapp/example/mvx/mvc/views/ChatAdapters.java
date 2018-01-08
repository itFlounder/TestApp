package com.shsany.testapp.example.mvx.mvc.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.shsany.testapp.R;
import com.shsany.testapp.example.mvx.mvc.model.ChatPojo;
import com.shsany.testapp.example.mvx.mvc.utils.MyUtils;

import java.util.ArrayList;

/**
 * Created by PC on 2017/12/20.
 */

public class ChatAdapters extends RecyclerView.Adapter<ChatAdapters.FollowerViewHolder> {
    private ArrayList<ChatPojo> chatList;
    private Context context;

    public ChatAdapters(Context context, ArrayList<ChatPojo> chatList) {
        this.chatList =chatList;
        this.context=context;
    }

    @Override
    public FollowerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.row_chat_adapter,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(FollowerViewHolder holder, int position) {
        if (chatList.get(position).getSenderId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {

            holder.layoutLeftMessages.setVisibility(View.GONE);
            holder.layoutRightMessages.setVisibility(View.VISIBLE);

            holder.messagesTextRight.setText(chatList.get(position).getMessage());
            holder.timeMessagesRight.setText(MyUtils.convertTime(chatList.get(position).getTimeStamp()));

        } else {

            holder.layoutLeftMessages.setVisibility(View.VISIBLE);
            holder.layoutRightMessages.setVisibility(View.GONE);

            holder.messagesTextLeft.setText(chatList.get(position).getMessage());
            holder.timeMessagesLeft.setText(MyUtils.convertTime(chatList.get(position).getTimeStamp()));
        }
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }


    class  FollowerViewHolder extends RecyclerView.ViewHolder{
        private TextView messagesTextLeft, timeMessagesLeft, messagesTextRight,timeMessagesRight;
        private LinearLayout layoutLeftMessages, layoutRightMessages;

        public FollowerViewHolder(View itemView) {
            super(itemView);

            messagesTextLeft = (TextView) itemView.findViewById(R.id.text_message_left);
            timeMessagesLeft =(TextView) itemView.findViewById(R.id.text_time_messages_left);
            messagesTextRight =(TextView) itemView.findViewById(R.id.text_message_right);
            timeMessagesRight=(TextView) itemView.findViewById(R.id.text_time_message_right);

            layoutLeftMessages =(LinearLayout) itemView.findViewById(R.id.layout_message_left);
            layoutRightMessages =(LinearLayout) itemView.findViewById(R.id.layout_message_right);
        }
    }
}
