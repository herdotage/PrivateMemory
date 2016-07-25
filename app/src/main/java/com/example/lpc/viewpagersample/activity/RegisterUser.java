package com.example.lpc.viewpagersample.activity;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lpc.viewpagersample.R;
import com.example.lpc.viewpagersample.db.DBHelperImpl;

/**
 * Created by lpc on 2016/7/25.
 */
public class RegisterUser extends Activity {

    public EditText mUserAccount, mUserPwd, mUserConfirmPwd, mUserEmail ;

    public Button mRegister ;

    public Handler mHandler ;

    public String mUserAccountStr ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register_user) ;

        initView() ;

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        } ;

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regiterUser() ;
            }
        });


    }


    public void initView() {
        mUserAccount = (EditText) findViewById(R.id.et_user_account) ;
        mUserPwd = (EditText) findViewById(R.id.et_user_pwd) ;
        mUserConfirmPwd = (EditText) findViewById(R.id.et_confirm_pwd) ;
        mUserEmail = (EditText) findViewById(R.id.et_conn_email) ;

        mRegister = (Button) findViewById(R.id.btn_register) ;
    }


    public void regiterUser() {

        if (mUserAccount.getText().toString().equals("") || mUserPwd.getText().toString().equals("") ||
                mUserConfirmPwd.getText().toString().equals("") || mUserEmail.getText().toString().equals("")) {
            Toast.makeText(RegisterUser.this,"上述资料不能为空，请重新填写！",Toast.LENGTH_LONG).show();
        }
        mUserAccountStr = mUserAccount.getText().toString() ;
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //查询数据库，判断账户是否重复
                DBHelperImpl dbHelper = new DBHelperImpl(RegisterUser.this) ;

                SQLiteDatabase db = dbHelper.getDB() ;

                dbHelper.queryUserId(mUserAccountStr) ;
            }
        }) ;

    }
}
