package com.project_n.tourandtravelproject.array;

import com.project_n.tourandtravelproject.activity.MulaiTourKota;

public class ListKota {
    private String Title;
    public ListKota(MulaiTourKota list_Kota, Class<MulaiTourKota> mulaiTourKotaClass) {
    }
    public ListKota(String title) {
        Title = title;
    }
    public String getTitle() {
        return Title;
    }
}
