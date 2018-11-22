package com.project_n.tourandtravelproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.project_n.tourandtravelproject.activity.ListWisata;
import com.project_n.tourandtravelproject.activity.MulaiTourKota;
import com.project_n.tourandtravelproject.activity.SettingActivity;
import com.project_n.tourandtravelproject.util.BottomNavigationHelper;
import com.project_n.tourandtravelproject.util.adapter.ViewPagerAdapter;

public class Main extends AppCompatActivity /*implements View.OnClickListener*/ {

    public BottomNavigationView bottomNav;
    ViewPager mViewPager;
    ViewPagerAdapter adapterVp;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //<=============TOOLBAR UPBAR===========>//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Trend Travel");
        String title = actionBar.getTitle().toString();
        actionBar.show();

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_airplane);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //<=============TOOLBAR UPBAR===========>//

        mViewPager = (ViewPager) findViewById(R.id.MainContent);
        adapterVp = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapterVp);

        bottomNav = (BottomNavigationView) findViewById(R.id.BottomNav);
        BottomNavigationHelper.removeShiftMode(bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.HomeBottom:
                        item.setIcon(R.drawable.ic_home_select);
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.CategoryBottom:
                        item.setIcon(R.drawable.ic_category_select);
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.TourBottom:
                        item.setIcon(R.drawable.ic_tour_select);
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.RiwayatBottom:
                        item.setIcon(R.drawable.ic_akun_select);
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNav.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNav.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNav.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menusetting, menu);
        return  true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.MenuSetting:
                startActivity(new Intent(this, SettingActivity.class));
                overridePendingTransition(R.anim.in_right, R.anim.out_left);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Apakah anda ingin keluar?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void mtKotaAsal(View view) {
        //Animation A = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_up);
        Intent i = new Intent(Main.this, MulaiTourKota.class);
        startActivity(i);
        overridePendingTransition(R.anim.move_up, R.anim.exit_up);
    }

    public void mtTujuan(View view) {
        Intent i = new Intent(Main.this, MulaiTourKota.class);
        startActivity(i);
        overridePendingTransition(R.anim.move_up, R.anim.exit_up);
    }

    public void mtListWisata(View view) {
        Intent i = new Intent(Main.this, ListWisata.class);
        startActivity(i);
        overridePendingTransition(R.anim.move_up, R.anim.exit_up);

    }


}
