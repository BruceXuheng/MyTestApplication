package com.example.chenxh.myttestapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context) {
        super(context, "test", null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS person (id integer primary key autoincrement, name varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}