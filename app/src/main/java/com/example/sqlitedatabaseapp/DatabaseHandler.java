package com.example.sqlitedatabaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "F1Drivers.db";
    public static final String TABLE_NAME = "DRIVER";
    public static final String COLUMN_ID = "ID";
    public static final String FIRST_NAME = "FIRSTNAME";
    public static final String LAST_NAME = "LASTNAME";

    public static final String USER_DATABASE_NAME="App.db";
    public static final String USER_TABLE_NAME="SIGNUP";
    public static final String USER_ID = "USERID";
    public static final String USER_FIRST_NAME = "FIRSTNAME";
    public static final String USER_LAST_NAME = "LASTNAME";
    public static final String USER_PH = "PHONE";
    public static final String USER_EMAIL_ID = "EMAILID";
    public static final String USER_PASSWORD = "PASSWORD";
    private SQLiteDatabase database;

    UserModel userModel = new UserModel();

    public DatabaseHandler(@Nullable Context context) {
        //super(context, DATABASE_NAME, null, DATABASE_VERSION);
        super(context, USER_DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +
                " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + FIRST_NAME + " VARCHAR, "
                + LAST_NAME + " VARCHAR);");

        db.execSQL("create table " + USER_TABLE_NAME + " ( " + USER_ID +"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                USER_FIRST_NAME+ " VARCHAR, " +
                USER_LAST_NAME+ " VARCHAR, " +
                USER_PH+ " INTEGER, " +
                USER_EMAIL_ID+" VARCHAR, "+
                USER_PASSWORD+ "VARCHAR); ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertRecord(DriverModel driverModel) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME,driverModel.getFirstname());
        contentValues.put(LAST_NAME,driverModel.getLastname());
        database.insert(TABLE_NAME,null,contentValues);
        database.close();

    }

    public ArrayList<DriverModel> getAllRecords(){
        database = this.getReadableDatabase();
        Cursor cursor = database.query(USER_TABLE_NAME,null,null,
                null,null,null,null);

        ArrayList<DriverModel> drivername = new ArrayList<DriverModel>();
        DriverModel driverModel;
        if (cursor.getCount() > 0){
            for (int i=0;i<cursor.getCount();i++){
                cursor.moveToNext();
                driverModel = new DriverModel();
                driverModel.setId(cursor.getString(0));
                driverModel.setFirstname(cursor.getString(1));
                driverModel.setLastname(cursor.getString(2));
                drivername.add(driverModel);
            }
        }
        cursor.close();
        database.close();
        return drivername;
    }

    public void updateRecord(DriverModel driverModel) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME,driverModel.getFirstname());
        contentValues.put(LAST_NAME,driverModel.getLastname());
        database.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?",
                new String[]{driverModel.getId()});
        database.close();
    }


    public void deleteRecord(DriverModel driverModel) {
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, COLUMN_ID + " = ?",new String[]{driverModel.getId()});
        database.close();
    }

    public void userInsert(UserModel userModel){
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_FIRST_NAME,userModel.getUserfirstname());
        contentValues.put(USER_LAST_NAME,userModel.getUserlastname());
        contentValues.put(USER_PH,userModel.getPhone());
        contentValues.put(USER_EMAIL_ID,userModel.getEmail());
        contentValues.put(USER_PASSWORD,userModel.getPassword());
        database.insert(TABLE_NAME,null,contentValues);
        database.close();
    }

    public UserModel getuserAllRecords(String email, String pass){
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME,null,null,
                null,null,null,null);

        if (cursor.getCount() > 0){

            for (int i=0;i<cursor.getCount();i++){
                cursor.moveToNext();
                if (email.equals(userModel.getEmail()) && pass.equals(userModel.getPassword()) ){
                    userModel.getUserfirstname();
                    userModel.getUserlastname();
                    userModel.getPhone();
                    userModel.getEmail();
                }
            }
        }
        cursor.close();
        database.close();
        return userModel;
    }

}
