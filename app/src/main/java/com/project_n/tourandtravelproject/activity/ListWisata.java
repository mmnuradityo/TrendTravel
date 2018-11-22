package com.project_n.tourandtravelproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project_n.tourandtravelproject.R;

public class ListWisata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_wisata);
        overridePendingTransition(R.anim.move_up, R.anim.exit_up);

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_down, R.anim.move_down);
    }
}
