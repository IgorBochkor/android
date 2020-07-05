package com.demo.applicationlect9;

import java.util.ArrayList;
import java.util.List;

public class CoinDataSource {

    interface ResultCallback{
        void onResult(List<Coin> coins);
    }

    void load (ResultCallback resultCallback){
        List<Coin> coins = new ArrayList<>();

        coins.add(new Coin(1,"BTC","Bitcoin",100500200l, 10000.0, -2.5));
        coins.add(new Coin(2,"NTC","Mycoin",200500200l, 1000.0, 5));
        coins.add(new Coin(2,"NTC","Mycoin",200500200l, 1000.0, 5));
        coins.add(new Coin(2,"NTC","Mycoin",200500200l, 1000.0, 5));
        coins.add(new Coin(2,"NTC","Mycoin",200500200l, 1000.0, 5));
        coins.add(new Coin(2,"NTC","Mycoin",200500200l, 1000.0, 5));
        coins.add(new Coin(2,"NTC","Mycoin",200500200l, 1000.0, 5));
        coins.add(new Coin(2,"NTC","Mycoin",200500200l, 1000.0, 5));
        coins.add(new Coin(2,"NTC","Mycoin",200500200l, 1000.0, 5));
        coins.add(new Coin(2,"NTC","Mycoin",200500200l, 1000.0, 5));
        coins.add(new Coin(5,"NTC","Mycoin",200500200l, 500.0, 5));

        resultCallback.onResult(coins);
    }
}
