package com.demo.applicationlect9.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.demo.applicationlect9.MainActivity;
import com.demo.applicationlect9.R;

import java.sql.Time;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.pref_category_main),MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putBoolean(getString(R.string.get_tutorial_complite), true);
                editor.putLong(getString(R.string.pref_key_first_launch), System.currentTimeMillis());
                editor.apply();

                startActivity(new Intent(v.getContext(), MainActivity.class));
                finish();

            }
        });
    }
}
