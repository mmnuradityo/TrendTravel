package com.project_n.tourandtravelproject;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Traveling.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TravelingDao travelingDao();
}
