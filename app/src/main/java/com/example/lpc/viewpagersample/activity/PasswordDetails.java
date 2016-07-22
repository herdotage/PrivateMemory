package com.example.lpc.viewpagersample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import com.example.lpc.viewpagersample.R;

/**
 * Created by lpc on 2016/7/19.
 */
public class PasswordDetails extends Activity {

    public String siteId = "12121" ;
    public TextView tvSiteId ;

    /**
     * 以后别写错onCreate函数了，不要写成带2个参数的
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("LPC","onCreate-----------") ;
        setContentView(R.layout.activity_password_details);

        initDatas() ;
        initViews() ;
    }


    public void initDatas() {
        Intent intent = getIntent() ;
         siteId = intent.getStringExtra("siteId") ;
        Log.d("LPC","siteId receive----------->" + siteId) ;


    }

    public void initViews() {
        tvSiteId = (TextView) findViewById(R.id.tv_site_id) ;
        tvSiteId.setText(siteId);
    }
}
