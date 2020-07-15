package com.demo.applicationlect9;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.recycleView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CoinDataSource dataSource = new CoinDataSource();
        dataSource.load(new CoinDataSource.ResultCallback() {
            @Override
            public void onResult(List<Coin> coins) {
                RecyclerView.Adapter adapter = new CoinRecycleViewAdapter(coins);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}