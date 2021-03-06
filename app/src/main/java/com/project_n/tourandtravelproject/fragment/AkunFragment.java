package com.project_n.tourandtravelproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.array.RiwayatPemesanan;
import com.project_n.tourandtravelproject.util.PreferenceHelper;
import com.project_n.tourandtravelproject.util.adapter.ReceylerViewAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AkunFragment extends Fragment {
    TextView mUserName;
    PreferenceHelper instance;
    RecyclerView mRecyclerView;
    ReceylerViewAdapter mrecyclerviewRiwayat;

    public AkunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_akun, container, false);

        mUserName = view.findViewById(R.id.FragAkunUserName);
        instance = PreferenceHelper.getInstance(getActivity().getApplicationContext());
        mUserName.setText(instance.getName());

        List<RiwayatPemesanan> lstRiwayat = new ArrayList<>();
        lstRiwayat.add(new RiwayatPemesanan("Paket Tour A"));
        lstRiwayat.add(new RiwayatPemesanan("Paket Tour Z"));
        lstRiwayat.add(new RiwayatPemesanan("Paket Tour C"));
        lstRiwayat.add(new RiwayatPemesanan("Paket Tour H"));
        lstRiwayat.add(new RiwayatPemesanan("Paket Tour B"));
        lstRiwayat.add(new RiwayatPemesanan("Paket Tour F"));
        lstRiwayat.add(new RiwayatPemesanan("Paket Tour B"));
        lstRiwayat.add(new RiwayatPemesanan("Paket Tour G"));
        lstRiwayat.add(new RiwayatPemesanan("Paket Tour D"));

        mRecyclerView = view.findViewById(R.id.RicyclerViewRiwayat);
        mrecyclerviewRiwayat = new ReceylerViewAdapter(lstRiwayat, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mrecyclerviewRiwayat);

        return view;
    }


}
