package com.example.lpc.viewpagersample.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * 封装一些常用函数
 * Created by lpc on 2016/7/25.
 */
public class CommonUtils {
    public Context mContext ;
    public Activity mActivity ;
    public Class mClass ;

    public CommonUtils() {
    }

    public CommonUtils(Context context) {
        this.mContext = context ;
    }

    public CommonUtils(Context context, Activity activity, Class clazz) {
        this.mContext = context;
        this.mActivity = activity;
        this.mClass = clazz;
    }

    public CommonUtils(Context context, Class clazz) {
        this.mContext = context;
        this.mClass = clazz;
    }

    public void returnToHome() {
        //使用CLEAR_TOP标记，销毁目标和它之上的其他Activity，重新创建目标Activity
        Intent intent = new Intent(mContext,mClass) ;
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        mContext.startActivity(intent);
    }

    /**
     * 图片字节流转Bitmap
     * @param str
     * @return
     */
    public Bitmap strToBitmap(String str) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray ;
            bitmapArray = Base64.decode(str,Base64.DEFAULT) ;
            bitmap = BitmapFactory.decodeByteArray(bitmapArray,0,bitmapArray.length) ;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bitmap ;
    }

    /**
     * bitmap转String
     * @param bitmap
     * @return
     */
    public String bitmapToStr(Bitmap bitmap) {
        String str = "" ;
        ByteArrayOutputStream stream = new ByteArrayOutputStream() ;
        byte[] bitmapArray  = stream.toByteArray() ;
        str = Base64.encodeToString(bitmapArray,Base64.DEFAULT) ;
        Log.d("LPC","direct str: " + bitmapArray.toString()) ;
        Log.d("LPC","toByteArray str: " + str) ;
        return str ;
    }
    public String getCurrentUserId() {
        String userId = null ;
        SharedPreferences preferences = mContext.getSharedPreferences("userId",0) ;
        userId = preferences.getString("userId","1000") ;

        return userId ;
    }
}
