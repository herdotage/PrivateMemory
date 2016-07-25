package com.example.lpc.viewpagersample.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.ParcelUuid;
import android.util.Log;

/**
 * Created by lpc on 2016/7/19.
 */
public class DBHelper extends SQLiteOpenHelper {

    /**
     * private momeries
     */
    public final static String DB_NAME = "pm" ;
    public final static int DB_VERSION = 2 ;
    public final static String TABLE_NAME_USER = "user" ;
    public final static String TABLE_NAME_PWD = "pwd" ;
    public final static String TABLE_NAME_USER_PWD = "user_pwd" ;

    private final static String CREATE_USER = "CREATE table " + TABLE_NAME_USER + " (" +
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
    private final static String CREATE_PWD = "CREATE table " + TABLE_NAME_PWD + " (" +
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
    private final static String CREATE_USER_PWD = "CREATE table " + TABLE_NAME_USER_PWD + " (" +
            "id int(5) NOT NULL auto_increment ," +
            "user_id int(5) " +
            "pwd_id int(5) ," +
            ")" ;

    private final static String DELETE_USER = "" ;

    public SQLiteDatabase getDatabase() {
        SQLiteDatabase database = getWritableDatabase() ;
        return database ;
    }
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, DB_NAME, null, DB_VERSION, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase = getWritableDatabase() ;

        sqLiteDatabase.beginTransaction();
        sqLiteDatabase.execSQL(CREATE_USER);
        sqLiteDatabase.execSQL(CREATE_PWD);
        sqLiteDatabase.execSQL(CREATE_USER_PWD);
        sqLiteDatabase.endTransaction();

        Log.d("LPC","create db..") ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("drop table if exists PASSMANAGE");
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME_USER);
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_NAME_PWD);
        Log.d("LPC","upGrade db...") ;

    }
}
