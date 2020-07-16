package com.demo.applicationlect9;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(getString(R.string.pref_category_main),MODE_PRIVATE);

        int launchNumber = sharedPreferences.getInt(getString(R.string.pref_key_launch_number),0);
        long firstLaunch = sharedPreferences.getLong(getString(R.string.pref_key_first_launch),System.currentTimeMillis());

        if (launchNumber > 5
                || System.currentTimeMillis()-firstLaunch > TimeUnit.MINUTES.toMillis(2)){
            showRateUsDialog();
        }
//тільки при першому запуску додатка
        if(savedInstanceState == null){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(getString(R.string.pref_key_launch_number), ++launchNumber);
            editor.apply();
        }

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

    private void showRateUsDialog() {
        Boolean rateUs = sharedPreferences.getBoolean(getString(R.string.pref_key_rated_us),false);
        if(!rateUs){
            new AlertDialog.Builder(this, R.style.Theme_AppCompat_Dialog_Alert)
                    .setMessage("Проголосуй за нашу алку?").
                    setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(getString(R.string.pref_key_rated_us), true);
                    editor.apply();

                }
            }).show();
        }
    }
}