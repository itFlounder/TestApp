package com.shsany.testapp.contacts;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.shsany.testapp.R;

/**
 * 自定义带删除功能的edittext
 * Created by PC on 2017/10/17.
 */

public class EditTextDel extends android.support.v7.widget.AppCompatEditText {
    private Context mContext;
    private Drawable imgLeft;
    private Drawable imgable;

    public EditTextDel(Context context) {
        super(context);
    }

    public EditTextDel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditTextDel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init(){
        imgLeft = mContext.getResources().getDrawable(R.drawable.icon_search);
        imgable = mContext.getResources().getDrawable(R.drawable.icon_delete_gray);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        setDrawable();

    }

    //设置搜索框左右图片显示
    private void setDrawable() {
        if (length()<1){
            setCompoundDrawablesWithIntrinsicBounds(imgLeft,null,null,null);
        }else {
            setCompoundDrawablesWithIntrinsicBounds(imgLeft,null,imgable,null);
        }
    }

    //处理删除时间

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (imgable != null && event.getAction() == MotionEvent.ACTION_UP){
            int enevtX = (int) event.getRawX();
            int eventY = (int) event.getRawY();
            Rect rect = new Rect();
            getGlobalVisibleRect(rect);
            rect.left = rect.right - 50;
            if (rect.contains(enevtX,eventY)){
                setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
