package com.shsany.testapp.example.view;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shsany.testapp.R;

/**
 * Created by PC on 2017/11/1.
 */

public class CustomStateActivity extends ListActivity {
    private Message[] messages = new Message[] {
            new Message("Gas bill overdue", true),
            new Message("Congratulations, you've won!", true),
            new Message("I love you!", false),
            new Message("Please reply!", false),
            new Message("You ignoring me?", false),
            new Message("Not heard from you", false),
            new Message("Electricity bill", true),
            new Message("Gas bill", true),
            new Message("Holiday plans", false),
            new Message("Marketing stuff", false), };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getListView().setAdapter(new ArrayAdapter<Message>(this,-1,messages){
            private LayoutInflater inflater = LayoutInflater.from(getContext());

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                ViewHolder holder = null;
                if (convertView == null){
                    holder = new ViewHolder();
                    convertView = inflater.inflate(R.layout.activity_custom_state,parent,false);
                    holder.iv = (ImageView) convertView.findViewById(R.id.iv_msg_item_icon);
                    holder.tv = (TextView) convertView.findViewById(R.id.tv_msg_item_icon);
                    convertView.setTag(holder);
                }else {
                    holder = (ViewHolder) convertView.getTag();
                }
                MessageListItem messageListItem = (MessageListItem)convertView;
                Message message = (Message)getItem(position) ;
                holder.tv.setText(message.subject);
                messageListItem.setMessageReaded(message.unread);
                return convertView;
            }
            class ViewHolder{
                ImageView iv;
                TextView tv;
            }
        });

    }
    private static class Message{
        private String subject;
        private boolean unread;
        private Message(String subject,boolean unread){
            this.subject = subject;
            this.unread = unread;
        }
    }
}
