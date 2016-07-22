package com.example.lpc.viewpagersample.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.WebView;
import android.widget.HorizontalScrollView;

import java.lang.reflect.Field;

/**
 * Created by lpc on 2016/7/18.
 */
public class MyViewPager extends ViewPager {

    public Context mContext ;
    public MyViewPager(Context context) {
        super(context);
        this.mContext = context ;
        setup();
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        setup();
    }

    /**
     * 如果返回false可以禁用左右滑动
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v instanceof HorizontalScrollView) {
            //System.out.println("canScroll....");
            return true;
        }
        if(v instanceof WebView)
        {
            //System.out.println("canScroll....");
            return true;
        }
        return super.canScroll(v, checkV, dx, x, y);
    }

    private void setup(){
        try{
            Field mScrollerField = ViewPager.class.getDeclaredField("mScroller");
            mScrollerField.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(mContext,new AccelerateDecelerateInterpolator());
            mScrollerField.set(this, scroller);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
