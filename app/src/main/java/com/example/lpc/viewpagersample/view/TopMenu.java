package com.example.lpc.viewpagersample.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lpc.viewpagersample.R;

import org.w3c.dom.Text;

/**
 * Created by lpc on 2016/7/21.
 */
public class TopMenu extends RelativeLayout {

    public Context mContext ;
    public ImageButton mLeftImg ;
    public TextView mCenterText ;

    public ImageButton mRightImg ;
    public OnBarItemClickListener mListener ;

    public TopMenu(Context context) {
        super(context,null);
        this.mContext = context ;

    }

    public TopMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context ;


    }
    public void setOnBarItemClickListener(OnBarItemClickListener listener) {
        this.mListener = listener ;
    }

    /**
     * 注意使用2个参数的构造函数，一开始使用3个参数，结果就是显示不出来
     * @param context
     * @param attrs
     */
    public TopMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context ;


        mLeftImg = new ImageButton(mContext) ;
        mLeftImg.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
//        mLeftImg.setScaleType(ImageView.ScaleType.FIT_XY);
        mRightImg = new ImageButton(mContext) ;
        mRightImg.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
//        mRightImg.setScaleType(ImageView.ScaleType.FIT_XY);
        mCenterText = new TextView(mContext) ;

        TypedArray array = mContext.obtainStyledAttributes(attrs,R.styleable.TopMenu) ;

        Drawable leftImg = array.getDrawable(R.styleable.TopMenu_leftImg) ;
        String centerText = array.getString(R.styleable.TopMenu_centerText) ;
        Drawable rightImg = array.getDrawable(R.styleable.TopMenu_rightImg) ;

        RelativeLayout.LayoutParams leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftParams.addRule(ALIGN_PARENT_LEFT,TRUE);
        addView(mLeftImg,leftParams);
        RelativeLayout.LayoutParams rightParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rightParams.addRule(ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightImg,rightParams);

        LayoutParams centerParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        centerParams.addRule(CENTER_IN_PARENT,TRUE);
//        centerParams.addRule(CENTER_VERTICAL);
        centerParams.setMargins(0,15,0,0);
        addView(mCenterText,centerParams);

        mLeftImg.setImageDrawable(leftImg);
        mCenterText.setText(centerText);
        mRightImg.setImageDrawable(rightImg);
        mLeftImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onLeftClick();
            }
        });
        mRightImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onRightClick();
            }
        });

        array.recycle();
    }

    public interface OnBarItemClickListener{
        void onLeftClick() ;
        void onRightClick() ;
    }
}
