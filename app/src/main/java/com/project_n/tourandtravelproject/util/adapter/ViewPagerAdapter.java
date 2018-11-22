package com.project_n.tourandtravelproject.util.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.project_n.tourandtravelproject.fragment.PemesananFragment;
import com.project_n.tourandtravelproject.fragment.AkunFragment;
import com.project_n.tourandtravelproject.fragment.CategoryFragment;
import com.project_n.tourandtravelproject.fragment.HomeFragment;

/**
 * Created by Nurad on 15/10/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new CategoryFragment();
            case 2:
                return new PemesananFragment();
            case 3:
                return new AkunFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }


}
