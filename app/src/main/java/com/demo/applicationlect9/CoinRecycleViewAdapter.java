package com.demo.applicationlect9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CoinRecycleViewAdapter extends RecyclerView.Adapter<CoinRecycleViewAdapter.CoinViewHolder> {

    private List<Coin> coinList;

    public CoinRecycleViewAdapter(List<Coin> coinList) {
        this.coinList = coinList;
    }

    @NonNull
    @Override
    public CoinViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_coin, parent,false);
//        View  itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coin, parent, false);
        return new CoinViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoinViewHolder holder, int position) {

        Coin coin = coinList.get(position);
        holder.setData(coin);

//        holder.rank.setText(String.valueOf(coin.getRank()));
//        holder.simbol.setText(String.valueOf(coin.getSimbol()));
//        holder.name.setText(String.valueOf(coin.getName()));
//        holder.marketCap.setText(String.valueOf(coin.getMarketCap()) + "$");
//        holder.priceUsd.setText(String.valueOf(coin.getPriceUsd())+ "$");
//        holder.percent24h.setText(String.valueOf(coin.getPercent24h())+ "%");


    }

    @Override
    public int getItemCount() {
        return coinList.size();
    }

    public static class CoinViewHolder extends RecyclerView.ViewHolder{

        TextView rank, simbol, name, marketCap, priceUsd, percent24h;

        public CoinViewHolder(@NonNull View itemView) {
            super(itemView);
            rank = itemView.findViewById(R.id.ranktextView);
            simbol = itemView.findViewById(R.id.simboltextView);
            name = itemView.findViewById(R.id.nametextView);
            marketCap = itemView.findViewById(R.id.marketCaptextView);
            priceUsd = itemView.findViewById(R.id.pricetextView);
            percent24h = itemView.findViewById(R.id.percenttextView);
        }

        public void setData(Coin coin){
            rank.setText(String.valueOf(coin.getRank()));
            simbol.setText(String.valueOf(coin.getSimbol()));
            name.setText(String.valueOf(coin.getName()));
            marketCap.setText(String.valueOf(coin.getMarketCap()) + "$");
            priceUsd.setText(String.valueOf(coin.getPriceUsd())+ "$");
            percent24h.setText(String.valueOf(coin.getPercent24h())+ "%");
        }
    }

}
