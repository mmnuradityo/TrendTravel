package com.project_n.tourandtravelproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.array.ListKota;
import com.project_n.tourandtravelproject.fragment.MulaiTourFragment;
import com.project_n.tourandtravelproject.util.adapter.RecycleViewAdapterKota;

import java.util.ArrayList;
import java.util.List;

public class MulaiTourKota extends AppCompatActivity {
    RecyclerView myRecyclerview;
    RecycleViewAdapterKota recycleAdapter;
    List<ListKota> listKota = new ArrayList<>();
    TextView mDetailKota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai_tour_kota);

        listKota.add(new ListKota("Yogyakarta"));
        listKota.add(new ListKota("Jakarta"));
        listKota.add(new ListKota("Bandung"));
        listKota.add(new ListKota("Surabaya"));
        listKota.add(new ListKota("Bali"));

        mDetailKota = (TextView) findViewById(R.id.textDetailKota);

        myRecyclerview = (RecyclerView) findViewById(R.id.rvDetaiKota);
        initRecyclerView();
        setAdapter();
    }

    private void initRecyclerView() {
        myRecyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(llm);
        recycleAdapter =new RecycleViewAdapterKota(this,listKota);

    }

    private void setAdapter() {
        myRecyclerview.setAdapter(recycleAdapter);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.enter_down, R.anim.move_down);

    }

    public void KotaKota(View view) {
        overridePendingTransition(R.anim.enter_down, R.anim.move_down);
        Bundle B = new Bundle();
        B.putString("kota", mDetailKota.getText().toString());
        Intent i = new Intent(this, MulaiTourFragment.class);
        i.putExtras(B);
        startActivity(i);
    }
}
