package com.project_n.tourandtravelproject;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;


@Entity(tableName = "Travel")
public class Traveling implements Serializable{
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo (name = "KotaAsal")
    String KotaAsal;
    @ColumnInfo (name = "KotaTujuan")
    String KotaTujuan;
    @ColumnInfo (name = "TujuanDestinasi")
    String TujuanDestinasi;
    @ColumnInfo (name = "ListWisata")
    String ListWisata;

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }


    public String getKotaAsal() {
        return KotaAsal;
    }

    public void setKotaAsal( String KotaAsal) {
        this.KotaAsal = KotaAsal;
    }
}
