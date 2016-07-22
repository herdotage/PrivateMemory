package com.example.lpc.viewpagersample.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lpc on 2016/7/19.
 */
public class DBHelper extends SQLiteOpenHelper {

    /**
     * private momeries
     */
    private final static String DB_NAME = "pm" ;

    private final static String CREATE_USER = "CREATE table user (" +
            "id int(5) NOT NULL auto_increment ," +
            "username VARCHAR(50)  ," +
            "userpwd VARCHAR(100) ," +
            "mobilephonenumber VARCHAR(20) ," +
            "email varchar(50) ," +
            "createat VARCHAR(50) ," +
            "updateat VARCHAR(50) ," +
            "headimgstr MEDIUMBLOB ," +
            "PRIMARY KEY (id)" +
            ")" ;
    private final static String CREATE_PASSMANAGE = "CREATE table PASSMANAGE (" +
            "id int(5) NOT NULL auto_increment ," +
            "sitename VARCHAR(50)  ," +
            "siteaddress VARCHAR(200) ," +
            "useraccount VARCHAR(100) ," +
            "userpwd VARCHAR(100) ," +
            "lastpwd VARCHAR(100) ," +
            "mobilephonenumber VARCHAR(20) ," +
            "email varchar(50) ," +
            "createat VARCHAR(50) ," +
            "updateat VARCHAR(50) ," +
            "webimgstr MEDIUMBLOB ," +
            "PRIMARY KEY (id)" +
            ")" ;

    private final static String DELETE_USER = "" ;

    public SQLiteDatabase getDatabase() {
        SQLiteDatabase database = getWritableDatabase() ;
        return database ;
    }
    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, 1);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, DB_NAME, null, 1, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase = getWritableDatabase() ;

        sqLiteDatabase.beginTransaction();
        sqLiteDatabase.execSQL(CREATE_USER);
        sqLiteDatabase.execSQL(CREATE_PASSMANAGE);
        sqLiteDatabase.endTransaction();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
