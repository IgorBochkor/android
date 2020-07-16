package com.demo.applicationlect9.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.demo.applicationlect9.MainActivity;
import com.demo.applicationlect9.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.pref_category_main),MODE_PRIVATE);
//        sharedPreferences.getBoolean("tutorial_complite", false);
        boolean complete = sharedPreferences.getBoolean(getString(R.string.get_tutorial_complite),false);

        if (!complete){
            startActivity(new Intent(getBaseContext(),MainActivity.class));
        }else{
            startActivity(new Intent(getBaseContext(),TutorialActivity.class));
        }
    }
}