package com.example.lpc.viewpagersample.view;

/**
 * Created by lpc on 2016/7/18.
 */
import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class FixedSpeedScroller extends Scroller {

    private int mDuration = 5;

    public FixedSpeedScroller(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public FixedSpeedScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
        // TODO Auto-generated constructor stub
    }

//	public FixedSpeedScroller(Context context, Interpolator interpolator,
//			boolean flywheel) {
//		super(context, interpolator, flywheel);
//		// TODO Auto-generated constructor stub
//	}

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // TODO Auto-generated method stub
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // TODO Auto-generated method stub
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

}