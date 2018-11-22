package com.project_n.tourandtravelproject.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.project_n.tourandtravelproject.Main;
import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.util.PreferenceHelper;

public class SettingActivity extends AppCompatActivity {
    ImageView mBack;
    AlertDialog.Builder mAlertAboutApp;
    LayoutInflater mAlertAboutAppInflater;
    View dialogView;
    PreferenceHelper instance;
    //TextView TampilNama, TampilNoTelp, TampilEmail, TampilPass, TampilanAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mBack = (ImageView) findViewById(R.id.Back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this, Main.class));
                overridePendingTransition(R.anim.in_leftt, R.anim.out_right);
                finish();
            }
        });

        instance = PreferenceHelper.getInstance(getApplicationContext());


    }
    public void Akun(View view) {

       /* final Traveling mTravel = mtravel.get(0);
        TampilNama.setText(mTravel.getUserName());
        TampilNoTelp.setText(mTravel.getPhone());
        TampilEmail.setText(mTravel.getEmail());
        TampilPass.setText(mTravel.getPass());
        TampilanAlamat.setText(mTravel.getAlamat());*/

        startActivity(new Intent(this, Account_Activity.class));
    }

    public void AboutUs(View view) {
        DialogAboutUs();
    }

    public void ContactUs(View view) {
        startActivity(new Intent(this, ContactUsActivity.class));
    }


    public void LogOut(View view) {
        instance.setLogin(false);
        startActivity(new Intent(this, Login.class));
        finish();

    }

    private void DialogAboutUs(){
        mAlertAboutApp = new AlertDialog.Builder(SettingActivity.this);
        mAlertAboutAppInflater = getLayoutInflater();
        dialogView = mAlertAboutAppInflater.inflate(R.layout.alert_about, null);
        mAlertAboutApp.setView(dialogView);
        mAlertAboutApp.setCancelable(true);
        mAlertAboutApp.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        mAlertAboutApp.show();
    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(SettingActivity.this, Main.class));
        overridePendingTransition(R.anim.in_leftt, R.anim.out_right);
        finish();
    }
}
