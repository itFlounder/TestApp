package com.shsany.testapp.example.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.shsany.testapp.R;

/**
 * Created by PC on 2017/9/26.
 */

public class CustomTitleView extends View {
    private String mTitleText;
    private int mTitleTextColor;
    private  int mTitleTextSize;
    //绘制时控制文本绘制的范围
    private Rect mBound;
    private Paint mPaint;

    public CustomTitleView(Context context) {
        this(context,null);
    }

    public CustomTitleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    /**
     * 获取自定义样式的属性
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CustomTitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView,defStyleAttr,0);
        int n = typedArray.getIndexCount();
        for (int i = 0; i<n; i++){
            int attr = typedArray.getIndex(i);
            switch (attr){
                case R.styleable.CustomTitleView_titleText:
                    mTitleText =typedArray.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    mTitleTextColor = typedArray.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = typedArray.getDimensionPixelSize(attr, (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
                    break;
            }
        }
        typedArray.recycle();

        //获取绘制文本的宽高
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width,height;
        if (widthMode == MeasureSpec.EXACTLY){
            width = widthSize;
        }else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
            float textWidth = mBound.width();
            int desired = (int)(getPaddingLeft()+textWidth +getPaddingRight());
            width = desired;
        }
        if (heightMode == MeasureSpec.EXACTLY){

            height = heightSize;
        }else{
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText,0,mTitleText.length(),mBound);
            float textHeight = mBound.height();
            int desired = (int)(getPaddingTop() +textHeight+getPaddingBottom());
            height = desired;
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画图片
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);
        //画字体
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText,(getWidth()-mBound.width())/2, (getHeight()-mBound.height())/2,mPaint);

    }
}
