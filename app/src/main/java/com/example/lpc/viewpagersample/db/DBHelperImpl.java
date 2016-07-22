package com.example.lpc.viewpagersample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lpc.viewpagersample.entities.PasswordInfo;
import com.example.lpc.viewpagersample.entities.PersonInfo;

import java.util.List;

/**
 * Created by lpc on 2016/7/20.
 */
public class DBHelperImpl extends DBHelper {
    public List<PasswordInfo> mPasswordInfos ;
    public PasswordInfo mPasswordInfo ;
    public PersonInfo mPersonInfo ;
    public Context mContext ;
    public SQLiteDatabase mDatabase ;

    public DBHelperImpl(Context context) {
        super(context);
        this.mContext = context ;
        initDataBase() ;
    }
    /*public DBHelperImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context ;
        initDataBase();
    }*/

    public void initDataBase() {
        mDatabase = new DBHelper(mContext).getWritableDatabase();
    }

    public Long insertDB(PasswordInfo passwordInfo) {
        ContentValues pwdValues = new ContentValues() ;
        pwdValues.put("sitename",passwordInfo.getSiteName());
        pwdValues.put("siteaddress",passwordInfo.getSiteAddress());
        pwdValues.put("useraccount",passwordInfo.getUserAccount());
        pwdValues.put("userpwd",passwordInfo.getPassword());
        pwdValues.put("mobilephonenumber",passwordInfo.getMobilePhoneNumber());
        pwdValues.put("email",passwordInfo.getEmail());
        pwdValues.put("lastpwd",passwordInfo.getLastPassword());
        pwdValues.put("createat",passwordInfo.getCreatedAt());
        pwdValues.put("updateat",passwordInfo.getUpdateAt());
        pwdValues.put("webimgstr",passwordInfo.getWebImgStr());

        Long result = mDatabase.insert(DBHelper.TABLE_NAME_USER,null,pwdValues) ;
        return result ;
    }

//    public Cursor queryDB()
}
