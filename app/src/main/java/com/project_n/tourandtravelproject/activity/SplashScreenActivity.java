package com.project_n.tourandtravelproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.project_n.tourandtravelproject.Main;
import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.util.PreferenceHelper;

public class SplashScreenActivity extends AppCompatActivity {

    PreferenceHelper instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

        instance = PreferenceHelper.getInstance(getApplicationContext());
        int SPLAH_TIME_OUT = 2500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!instance.isLogin()){
                    Intent i = new Intent(SplashScreenActivity.this, Login.class);
                    startActivity(i);
                    finish();
                }else {
                    Intent i = new Intent(SplashScreenActivity.this, Main.class);
                    startActivity(i);
                    finish();

                }
            }
        }, SPLAH_TIME_OUT);
    }
}
