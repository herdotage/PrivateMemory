package com.example.lpc.viewpagersample.db;

import android.content.Context;
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
    public DBHelperImpl(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context ;
        initDataBase();
    }

    public void initDataBase() {
        mDatabase = new DBHelper(mContext).getWritableDatabase();
    }

    public int insertDB(PasswordInfo passwordInfo) {
//        mDatabase.insert("user",)
        return 0 ;
    }
}
