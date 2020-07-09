package com.demo.applicationlect9.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "my_database.sqldb";
    public static final int VERSION = 1;

    public DataBaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE coins (" +
                "_id TEXT PRIMARY KEY," +
                "rank INTEGER," +
                "name TEXT," +
                "marketCap INTEGER," +
                "simbol TEXT," +
                "priceUsd REAL," +
                "percent24h REAL"+
                ")");

        db.execSQL("CREATE TABLE favorites (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "coinId TEXT," +
                "favorite TEXT," +
                "UNIQUE(coinId)" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
