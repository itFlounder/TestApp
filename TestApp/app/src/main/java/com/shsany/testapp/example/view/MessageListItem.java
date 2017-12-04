package com.shsany.testapp.example.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.shsany.testapp.R;

/**
 * Created by PC on 2017/11/1.
 */

public class MessageListItem extends RelativeLayout {
    private static final int[] STATE_MESSAGE_READER = {R.attr.state_message_readed};
    private boolean mMessageReaded = false;

    public MessageListItem(Context context) {
        this(context,null);
    }

    public MessageListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MessageListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }

    public void setMessageReaded(boolean readed){
        if (this.mMessageReaded != readed){
            mMessageReaded = readed;
            refreshDrawableState();
        }
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        if (mMessageReaded){
            final int[] drawableState = super.onCreateDrawableState(extraSpace+1);
            mergeDrawableStates(drawableState,STATE_MESSAGE_READER);
            return drawableState;
        }
        return super.onCreateDrawableState(extraSpace);
    }
}
