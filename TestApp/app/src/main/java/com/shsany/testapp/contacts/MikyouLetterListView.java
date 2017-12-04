package com.shsany.testapp.contacts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by PC on 2017/10/9.
 */

public class MikyouLetterListView extends View {
    private OnTouchingLetterChangedListener listener;
    //定义了显示在最右边的浮动的索引项的列表,当然这个是固定的，所以可以直接初始化，如果需要变动的话则可以通过自定义属性来指定
    String[] b = {"#","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    int choose = -1;//用于标记点击存放字母数组中的下标
    Paint paint = new Paint();
    //控制当我们点击索引列表中整个索引列表的背景有个变化,为false表示开始没点击背景为正常显示时候的背景
    boolean showBkg = false;
    private List<String> letterList;
    private TextView mTv;

    public MikyouLetterListView(Context context) {
        this(context,null);
    }

    public MikyouLetterListView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MikyouLetterListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        letterList = Arrays.asList(b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (showBkg){
            canvas.drawColor(Color.parseColor("#10000000"));
        }
        int height = getHeight();
        int width = getWidth();
        int singleHeight = height/letterList.size();

        for (int i =0; i<letterList.size();i++){
            paint.setColor(Color.parseColor("#515151"));
            paint.setTextSize(25);
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.setAntiAlias(true);
            if (i == choose){
                paint.setColor(Color.parseColor("#3399ff"));
                paint.setFakeBoldText(true);
            }
            float x = width/2 - paint.measureText(letterList.get(i))/2;
            float y = singleHeight*i +singleHeight;
            canvas.drawText(letterList.get(i),x,y,paint);
            paint.reset();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        final int action = event.getAction();
        final  float y = event.getY();
        final int oldChoose = choose;//用于记录上一次点击字母所在字母数组中的下标
        final int c = (int )(y/getHeight()*letterList.size());//得到点击或触摸的位置从而确定对应点击或触摸的字母所在字母数组中的下标
        switch (action){
            case MotionEvent.ACTION_DOWN:
                showBkg = true;
                if (oldChoose != c && listener != null){
                    if (c >= 0 && c <=letterList.size()){
                        listener.onTouchingLetterChanged(letterList.get(c));
                        choose = c;
                        invalidate();//最后通知canvas重新绘制
                    }
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (oldChoose != c && listener != null){
                    if (c >= 0 && c <= letterList.size()){
                        listener.onTouchingLetterChanged(letterList.get(c));
                        choose =c;
                        invalidate();
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                showBkg = false;
                choose = -1;
                invalidate();
                break;
        }
        return true;
    }
    public void setIndexText(ArrayList<String> indexStrings) {
        this.letterList = indexStrings;
        invalidate();
    }
    public void setTextView(TextView tv){
        this.mTv = tv;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setOntouchingLetterChangedListener(OnTouchingLetterChangedListener listener){
        this.listener = listener;
    }
    /**
     * 定义一个接口，用于回调点击后的字母，显示在弹出的字母对话框中
     */
    public interface OnTouchingLetterChangedListener{
        public void onTouchingLetterChanged(String s);
    }
}
