package com.demo.applicationlect9;

public class Coin {

    private int rank;
    private String name;
    private long marketCap;
    private String Simbol;
    private double priceUsd;
    private double percent24h;

    public Coin(int rank, String simbol,String name, long marketCap,  double priceUsd, double percent24h) {
        this.rank = rank;
        this.name = name;
        this.marketCap = marketCap;
        Simbol = simbol;
        this.priceUsd = priceUsd;
        this.percent24h = percent24h;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public String getSimbol() {
        return Simbol;
    }

    public double getPriceUsd() {
        return priceUsd;
    }

    public double getPercent24h() {
        return percent24h;
    }
}
