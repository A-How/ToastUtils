package com.zpf.toastutils.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * 自定义 饼状图
 * Created by zpf on 2018/9/2.
 */

public class PieView extends View {

    // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    private float mStartAngle = 0;

    private ArrayList<PieData> mData;

    private int mWidth,mHeight;

    private Paint mPaint = new Paint();

    public PieView(Context context) {
        this(context,null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(null == mData)
            return;
        float currentStartAngle = mStartAngle;
        canvas.translate(mWidth/2,mHeight/2);
        float r = (float) (Math.min(mWidth,mHeight)/2);
        RectF rect = new RectF(-r,-r,r,r);
        for (int i= 0;i < mData.size();i++){
            PieData pieData = mData.get(i);
            mPaint.setColor(pieData.getColor());
            canvas.drawArc(rect,currentStartAngle,pieData.getAngle(),true,mPaint);
            currentStartAngle += pieData.getAngle();
        }
    }

    //设置起始角度
    public void setStartAngle(int mStartAngle){
        this.mStartAngle = mStartAngle;
        invalidate(); //刷新
    }

    public void setData(ArrayList<PieData> mData){
        this.mData = mData;
        initData(mData);
        invalidate();
    }

    private void initData(ArrayList<PieData> mData) {
        if (null == mData || mData.size() == 0)
            return;
        float sumValue = 0;
        for (int i = 0; i<mData.size(); i++){
            PieData pie = mData.get(i);
            sumValue += pie.getValue();
            int j = i % mColors.length;
            pie.setColor(mColors[j]);
        }
        float sumAngle = 0;
        for (int i=0;i<mData.size();i++){
            PieData pie = mData.get(i);
            float percentage = pie.getValue() / sumValue;
            float angle = percentage * 360;
            pie.setAngle(angle);
            sumAngle += angle;

        }

    }

}
