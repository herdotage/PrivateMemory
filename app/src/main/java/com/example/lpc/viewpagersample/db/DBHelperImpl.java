package com.example.lpc.viewpagersample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.lpc.viewpagersample.entities.PasswordInfo;
import com.example.lpc.viewpagersample.entities.PersonInfo;
import com.example.lpc.viewpagersample.utils.CommonUtils;

import java.util.ArrayList;
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

    public SQLiteDatabase getDB() {
        if (mDatabase != null) {

            return mDatabase ;
        }

        return new DBHelper(mContext).getWritableDatabase() ;
    }

    public void initDataBase() {
        mDatabase = new DBHelper(mContext).getWritableDatabase();
    }

    public Long insertPassword(PasswordInfo passwordInfo) {
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

        mDatabase.beginTransaction();

        Long result = mDatabase.insert(DBHelper.TABLE_NAME_PWD,null,pwdValues) ;

        /**
         * 更新数据库用户-密码表记录
         */
        int userId = Integer.parseInt(new CommonUtils(mContext).getCurrentUserId()) ;
        int pwdId = queryPwdId(String.valueOf(userId)) ;
        insertUserPwd(userId,pwdId) ;
        mDatabase.endTransaction();
        return result ;
    }

    public Long insertPerson(PersonInfo personInfo) {

        ContentValues personValues = new ContentValues() ;
        personValues.put("username",personInfo.getUsername());
        personValues.put("userpwd",personInfo.getPassword());
        personValues.put("userpwd",personInfo.getPassword());
        personValues.put("mobilephonenumber",personInfo.getMobilePhoneNumber());
        personValues.put("email",personInfo.getEmail());
        personValues.put("createat",personInfo.getCreatedAt());
        personValues.put("updateat",personInfo.getUpdateAt());
        personValues.put("headimgstr",personInfo.getHeadImgStr());

        Long result = mDatabase.insert(DBHelper.TABLE_NAME_USER,null,personValues) ;
        return result ;
    }

    public Long insertUserPwd(int userId, int pwdId) {

        Long result = null ;
        ContentValues userPwd = new ContentValues() ;
        userPwd.put("user_id",userId);
        userPwd.put("pwd_id",pwdId);

        result = mDatabase.insert(DBHelper.TABLE_NAME_USER_PWD,null,userPwd) ;

        return result ;
    }



    public PersonInfo queryPersonInfo() {

        PersonInfo info = new PersonInfo() ;
        Cursor cursor = mDatabase.query(DBHelper.TABLE_NAME_USER,null,null,null,null,null,null) ;

        cursor.moveToFirst() ;
        int i = 0 ;
        while (cursor.moveToNext()) {
            info.setObjectId(String.valueOf(cursor.getInt(0)));
            info.setUsername(cursor.getString(1));
            info.setPassword(cursor.getString(2));
            info.setMobilePhoneNumber(cursor.getString(3));
            info.setEmail(cursor.getString(4));
            info.setHeadImgStr(cursor.getString(7));
            info.setHeadImg( new CommonUtils().strToBitmap(info.getHeadImgStr()));
        }
        cursor.close();
        return  info ;
    }

    public int queryUserId(String id) {

        String[] args = {id} ;
        int userId = 0 ;

        Cursor cursor = mDatabase.query(DBHelper.TABLE_NAME_USER,null,"id=?",args,null,null,null) ;

        cursor.moveToFirst() ;
        userId = cursor.getInt(0) ;
        cursor.close();
        return userId ;
    }
    public int queryPwdId(String userId) {

        int pwdId = 0 ;
        String[] args = {userId} ;

        Cursor cursor = mDatabase.query(DBHelper.TABLE_NAME_USER_PWD,null,"user_id=?",args,null,null,null) ;

        cursor.moveToFirst() ;
        pwdId = cursor.getInt(2) ;
        cursor.close();
        return pwdId ;
    }

}
