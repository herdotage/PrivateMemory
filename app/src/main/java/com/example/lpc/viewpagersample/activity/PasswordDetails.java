package com.example.lpc.viewpagersample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lpc.viewpagersample.R;

/**
 * Created by lpc on 2016/7/19.
 */
public class PasswordDetails extends Activity {

    public String siteId = "12121" ;
    public TextView tvSiteId ;
    public ImageView mBack ;
    public ImageView mMenu ;

    /**
     * 以后别写错onCreate函数了，不要写成带2个参数的
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("LPC","onCreate-----------") ;
        setContentView(R.layout.activity_password_details);

        initViews() ;
        initDatas() ;
    }


    public void initDatas() {
        Intent intent = getIntent() ;
         siteId = intent.getStringExtra("siteId") ;
        Log.d("LPC","siteId receive----------->" + siteId) ;


    }

    public void initViews() {
        tvSiteId = (TextView) findViewById(R.id.et_web_addr) ;
        tvSiteId.setText(siteId);

        mBack = (ImageView) findViewById(R.id.img_back) ;
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PasswordDetails.this,MainActivity.class) ;
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
                startActivity(intent);
            }
        });
        mMenu = (ImageView) findViewById(R.id.iv_top_menu) ;
        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PasswordDetails.this,"Menu",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
