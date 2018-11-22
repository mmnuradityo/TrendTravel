package com.project_n.tourandtravelproject.array;

import com.project_n.tourandtravelproject.fragment.AkunFragment;


public class RiwayatPemesanan {
    private String Title;
    public RiwayatPemesanan(AkunFragment list_riwayat, Class<AkunFragment> akunFragmentClass) {
    }
    public RiwayatPemesanan(String title) {
        Title = title;
    }
    public String getTitle() {
        return Title;
    }
}