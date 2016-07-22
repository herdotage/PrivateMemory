package com.example.lpc.viewpagersample.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lpc.viewpagersample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpc on 2016/7/19.
 */
public class NewPassword extends Activity implements Spinner.OnItemSelectedListener {

//    public TopMenu mTopMenu ;
    public ImageView mBack ;
    public TextView mTopTitle ;
    public ImageView mMenu ;
    public EditText mWebAddr, mWebAccount, mWebPwd, mConnEmail, mConnPhone ;
    public Spinner mSpWebAddr, mSpWebAccount, mSpWebPwd, mSpConnEmail, mSpConnPhone ;
    public List<String> mAddrList, mAccountList, mPwdList, mConnEmailList, mConnPhoneList ;
    public ArrayAdapter<String> mAddrAdapter, mAccountAdapter, mPwdAdapter, mConnEmailAdapter, mConnPhoneAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_password);

        initView() ;
        initData() ;
    }

    private void initData() {

        /**
         * get Datas from database
         */
        mAccountList = new ArrayList<String>();
        mAccountList.add("eml193@qq.com");
        mAccountList.add("zifary@163.com");
        mAccountList.add("zifary");
        mAccountList.add("herdotage@gmail.com");
        mAccountList.add("927528219@qq.com");
        mAddrAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mAccountList);
        mSpWebAccount.setAdapter(mAccountAdapter);
        mSpWebAccount.setOnItemSelectedListener(this);

        mAddrList = new ArrayList<String>();
        mAddrList.add("http://www.baidu.com");
        mAddrList.add("https://google.com");
        mAddrList.add("http://taobao.com");
        mAddrList.add("http://mail.163.com");
        mAddrList.add("http://mi.com");
        mAddrAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mAddrList);
        mSpWebAddr.setAdapter(mAddrAdapter);
        mSpWebAddr.setOnItemSelectedListener(this);

        mPwdList = new ArrayList<String>();
        mPwdList.add("123456");
        mPwdList.add("lpc999lpc");
        mPwdList.add("19902999");
        mPwdList.add("donottakepwd");
        mPwdList.add("carrymehaha");
        mPwdAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mPwdList);
        mSpWebPwd.setAdapter(mPwdAdapter);
        mSpWebPwd.setOnItemSelectedListener(this);


        mConnEmailList = new ArrayList<String>();
        mConnEmailList.add("eml1993@qq.com");
        mConnEmailList.add("herdotage@gmail.com");
        mConnEmailList.add("zifary@163.com");
        mConnEmailList.add("927528219@qq.com");
        mConnEmailAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mConnEmailList);
        mSpConnEmail.setAdapter(mConnEmailAdapter);
        mSpConnEmail.setOnItemSelectedListener(this);

        mConnPhoneList = new ArrayList<String>();
        mConnPhoneList.add("13412987867");
        mConnPhoneList.add("13003478658");
        mConnPhoneAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mConnPhoneList);
        mSpConnPhone.setAdapter(mConnPhoneAdapter);
        mSpConnPhone.setOnItemSelectedListener(this);


    }

    private void initView() {
        /*mTopMenu = (TopMenu) findViewById(R.id.new_password_top_menu) ;

        mTopMenu.setOnBarItemClickListener(new TopMenu.OnBarItemClickListener() {
            @Override
            public void onLeftClick() {
                Intent intent = new Intent(NewPassword.this,MainActivity.class) ;
                startActivity(intent);
            }

            @Override
            public void onRightClick() {
                Toast.makeText(NewPassword.this,"Menu",Toast.LENGTH_SHORT).show();
            }
        });*/
        mBack = (ImageView) findViewById(R.id.img_back) ;
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewPassword.this,MainActivity.class) ;
                startActivity(intent);
            }
        });
        mMenu = (ImageView) findViewById(R.id.iv_top_menu) ;
        mMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NewPassword.this,"Menu",Toast.LENGTH_SHORT).show();
            }
        });

        mWebAddr = (EditText) findViewById(R.id.et_web_addr) ;
        mWebAccount = (EditText) findViewById(R.id.et_web_account) ;
        mWebPwd = (EditText) findViewById(R.id.et_web_pwd) ;
        mConnEmail = (EditText) findViewById(R.id.et_conn_email) ;
        mConnPhone = (EditText) findViewById(R.id.et_conn_phone) ;

        mSpWebAddr = (Spinner) findViewById(R.id.sp_web_addr) ;
        mSpWebAccount = (Spinner) findViewById(R.id.sp_web_account) ;
        mSpWebPwd = (Spinner) findViewById(R.id.sp_web_pwd) ;
        mSpConnEmail = (Spinner) findViewById(R.id.sp_conn_email) ;
        mSpConnPhone = (Spinner) findViewById(R.id.sp_conn_phone) ;

    }

    /**
     *
     * @param adapterView 触发选择后的Spinner
     * @param view Spinner里的Item
     * @param i 选择的值
     * @param l
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.sp_web_addr:
                mWebAddr.setText(mSpWebAddr.getSelectedItem().toString());
                break;
            case R.id.sp_web_account:
                mWebAccount.setText(mSpWebAccount.getSelectedItem().toString());
                break;
            case R.id.sp_web_pwd:
                mWebPwd.setText(mSpWebPwd.getSelectedItem().toString());
                break;
            case R.id.sp_conn_email:
                mConnEmail.setText(mSpConnEmail.getSelectedItem().toString());
                break;
            case R.id.sp_conn_phone:
                mConnPhone.setText(mSpConnPhone.getSelectedItem().toString());
                break;
            default:
                break;
        }
        Log.d("LPC","view: "+view.getId());
        Log.d("LPC","i: "+i);
        Log.d("LPC","l: "+l);
        Log.d("LPC","mSpWebAddr.getSelectedItem(): "+mSpWebAddr.getSelectedItem().toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        mWebAddr.setText("http://gg.com");
        mWebAccount.setText("gg@gg.com");
        mWebPwd.setText("gg989gg") ;
        mConnEmail.setText("email");
        mConnPhone.setText("13423546754");
    }
}
