package com.demo.applicationlect9.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.demo.applicationlect9.Coin;

@Database(entities = {Coin.class},
        exportSchema = false,
        version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract CoinsDao getCoinDao();
}
