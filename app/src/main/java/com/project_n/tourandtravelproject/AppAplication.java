package com.project_n.tourandtravelproject;

import android.app.Application;
import android.arch.persistence.room.Room;


public class AppAplication extends Application {

    public static AppDataBase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class, "travelingdb").allowMainThreadQueries().build();
    }
}
