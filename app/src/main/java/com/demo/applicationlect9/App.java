package com.demo.applicationlect9;

import android.app.Application;

import androidx.room.Room;

import com.demo.applicationlect9.db.MyDatabase;
import com.facebook.stetho.Stetho;

public class App extends Application {

    public static App app;

    public static App get() {
        return app;
    }

    public MyDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Stetho.initializeWithDefaults(this);
        db = Room.databaseBuilder(getApplicationContext(),
                MyDatabase.class,
                "my_room_db.sql").allowMainThreadQueries().build();
    }
}
