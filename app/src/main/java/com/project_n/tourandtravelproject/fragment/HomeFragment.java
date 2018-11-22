package com.project_n.tourandtravelproject.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.util.adapter.ReceylerViewAdapterHome;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView recyclerViewHome;
    ReceylerViewAdapterHome mRecyclerViewAdapter;

    public HomeFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View tampil = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewHome = tampil.findViewById(R.id.RecyclerHome);
        ArrayList<Integer> listViewType = new ArrayList<>();
        listViewType.add(ReceylerViewAdapterHome.TYPE_1);
        listViewType.add(ReceylerViewAdapterHome.TYPE_2);
        listViewType.add(ReceylerViewAdapterHome.TYPE_2);
        listViewType.add(ReceylerViewAdapterHome.TYPE_2);
        listViewType.add(ReceylerViewAdapterHome.TYPE_2);
        listViewType.add(ReceylerViewAdapterHome.TYPE_2);
        listViewType.add(ReceylerViewAdapterHome.TYPE_2);
        listViewType.add(ReceylerViewAdapterHome.TYPE_2);
        listViewType.add(ReceylerViewAdapterHome.TYPE_2);
        listViewType.add(ReceylerViewAdapterHome.TYPE_2);
        listViewType.add(ReceylerViewAdapterHome.TYPE_2);


        mRecyclerViewAdapter = new ReceylerViewAdapterHome(listViewType, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewHome.setLayoutManager(layoutManager);

        recyclerViewHome.setAdapter(mRecyclerViewAdapter);

        return tampil;
    }

}
