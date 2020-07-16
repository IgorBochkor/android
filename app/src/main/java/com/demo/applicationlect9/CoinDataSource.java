package com.demo.applicationlect9;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.demo.applicationlect9.db.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class CoinDataSource {

    private List<Coin> favorites = new ArrayList<>();

    public List<Coin> getFavorites() {
        return favorites;
    }

    interface ResultCallback{
        void onResult(List<Coin> coins);
    }

    void load (ResultCallback resultCallback){
        List<Coin> coins = new ArrayList<>();

        coins.add(new Coin(1,"BTC","Bitcoin",100500200l, 10000.0, -2.5));
        coins.add(new Coin(2,"NTC","Mycoin",200500200l, 1000.0, 5));
        coins.add(new Coin(2,"NTC2","Mycoin",200500200l, 1000.0, 15));
        coins.add(new Coin(2,"NTC4","Mycoin",200500200l, 1000.0, 52));
        coins.add(new Coin(2,"NTC5","Mycoin",200500200l, 1000.0, 53));
        coins.add(new Coin(2,"NTC6","Mycoin",200500200l, 1000.0, 25));
        coins.add(new Coin(2,"NTC78","Mycoin",200500200l, 1000.0, 35));
        coins.add(new Coin(2,"NTC9","Mycoin",200500200l, 1000.0, 45));
        coins.add(new Coin(2,"NTC11","Mycoin",200500200l, 1000.0, 55));
        coins.add(new Coin(2,"NTC12","Mycoin",200500200l, 1000.0, 65));
        coins.add(new Coin(5,"NTC13","Mycoin",200500200l, 500.0, 75));

        App.get().db.getCoinDao().insertAll(coins);
        List<Coin> all = App.get().db.getCoinDao().getAll();

        resultCallback.onResult(all);
    }
}
