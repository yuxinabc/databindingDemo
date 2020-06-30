package com.cass.livedataviewmodeldatabinding.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.databinding.InverseBindingListener;

import com.cass.livedataviewmodeldatabinding.R;

/**
 * @Description:
 * @Author: SYX
 * @Copyright: cassInfo
 * @CreateDate: 2020/6/30 11:09 AM
 * @Version: 1.0.0
 */
public class MyTextView extends View {
    private Paint mPaint;
    private String text;
    private int color;
    private InverseBindingListener listener;
    public MyTextView(Context context) {
        this(context,null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(40);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.MyTextView);
        text=typedArray.getString(R.styleable.MyTextView_text);
        typedArray.recycle();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int mWidth;
        int mHeight;
        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        int hMode = MeasureSpec.getMode(heightMeasureSpec);
        int wSize = MeasureSpec.getSize(widthMeasureSpec);
        int hSize = MeasureSpec.getSize(heightMeasureSpec);
        if(wMode==MeasureSpec.EXACTLY){
            mWidth=wSize;
        }else{
            //自己计算宽度
           mWidth= (int) mPaint.measureText(text);
        }
        if(hMode==MeasureSpec.EXACTLY){
            mHeight=hSize;
        }else{
            //自己计算高度
            mHeight= (int) mPaint.getTextSize();
        }
        setMeasuredDimension(mWidth,mHeight);
    }
    public void setText(String text){
        this.text=text;
        requestLayout();
    }
    public void setColorHH(@ColorInt int color){
        this.color=color;
        invalidate();
    }
    public String getText() {
        return text;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(TextUtils.isEmpty(text)){
            return;
        }
        if(color!=0){
            mPaint.setColor(color);
        }
        canvas.translate(0,getHeight()/2f);
        canvas.drawText(text,0,Math.abs(mPaint.ascent() + mPaint.descent()) / 2,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            this.text="AAAAA"+(int)(Math.random()*100);
            if(listener!=null){
                listener.onChange();
            }
            requestLayout();
        }
        return true;
    }

    public void setListener(InverseBindingListener listener) {
        this.listener=listener;
    }
}
