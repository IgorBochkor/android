package com.demo.applicationlect9;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.demo.applicationlect9.db.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class CoinDataSource {
   private DataBaseHelper helper;

    public CoinDataSource(Context context){

        helper = new DataBaseHelper(context);

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

        List<ContentValues> values = new ArrayList<>();

        for (Coin x: coins){
            ContentValues value = new ContentValues();
            value.put(BaseColumns._ID, x.getSimbol());
            value.put("rank", x.getRank());
            value.put("name", x.getName());
            value.put("marketCap", x.getMarketCap());
            value.put("simbol", x.getSimbol());
            value.put("priceUsd", x.getPriceUsd());
            value.put("percent24h", x.getPercent24h());
            values.add(value);
        }

        try (SQLiteDatabase database = helper.getWritableDatabase()) {
            try{
                database.beginTransaction();
                //insert
                for (ContentValues value: values){
                    database.insert("coins",null,value);
                }
                database.setTransactionSuccessful();
            } finally {
                database.endTransaction();
            }
        }

        resultCallback.onResult(coins);
    }
}
