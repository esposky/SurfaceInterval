package com.example.demologinapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteDatabase extends SQLiteOpenHelper {

    public static final String Database_Name = "UserLogin.db";

    public MySQLiteDatabase( Context context) {
        super(context,"UserLogin.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase myDatabase) {
        myDatabase.execSQL("create Table users(username TEXT primary key, password TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase myDatabase, int i, int i1) {
        myDatabase.execSQL("drop Table if exists users");

    }

    public Boolean insertUserData(String username,String password){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = myDatabase.insert("users",null,contentValues);
        if(result == -1) return false;
        else
            return true;
    }

    public Boolean check_username(String username){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from users where username = ?", new String[]{username});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean check_username_password(String username, String password){
        SQLiteDatabase myDatabase = this.getWritableDatabase();
        Cursor cursor = myDatabase.rawQuery("Select * from users where username = ? and password = ?",new String[]{username,password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

}//Do not touch this!

