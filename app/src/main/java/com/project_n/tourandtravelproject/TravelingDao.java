package com.project_n.tourandtravelproject;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TravelingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertTravel(Traveling travel);

    @Query("SELECT * FROM TravelUser")
    List<Traveling> getAllTravel();

}
