package com.project_n.tourandtravelproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project_n.tourandtravelproject.R;


public class PemesananFragment extends Fragment {
    private FragmentTabHost mTabHost;

    public PemesananFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pemesanan, container, false);

        mTabHost = view.findViewById(R.id.TabPesan);
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.FrameTabPesan);
        mTabHost.addTab(mTabHost.newTabSpec("mulai tour").setIndicator("Mulai Tour"), MulaiTourFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("paket tour").setIndicator("Paket Tour"), PaketTourFragment.class, null);
        return view;
    }
}
