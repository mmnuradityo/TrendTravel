package com.project_n.tourandtravelproject.activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.util.PreferenceHelper;

public class Account_Activity extends AppCompatActivity {
        TextView malertTittle, TampilNama, TampilNoTelp, TampilEmail, TampilPass, TampilanAlamat;
        EditText UserEdit;
        Button TmblSimpan;
        PreferenceHelper instance;
        AlertDialog.Builder mAlertAboutApp;
        LayoutInflater mAlertAboutAppInflater;
        View dialogView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_account_);

            TampilNama = (TextView) findViewById(R.id.tampilUserName);
            TampilNoTelp = (TextView) findViewById(R.id.tampilNoTelp);
            TampilEmail = (TextView) findViewById(R.id.tampilEmail);
            TampilPass = (TextView) findViewById(R.id.tampilPassword);
            TampilanAlamat = (TextView) findViewById(R.id.tampilAlamat);

            UserEdit = (EditText) findViewById(R.id.editAccount);

            instance = PreferenceHelper.getInstance(getApplicationContext());

            TampilNama.setText(instance.getName());
            TampilNoTelp.setText(instance.getNoTelp());
            TampilEmail.setText(instance.getEmail());
            TampilPass.setText(instance.getPass());
            TampilanAlamat.setText(instance.getAlamat());

        }


        public void Back(View view) {
            finish();
        }

        public void AkunUserName(View view) {
            DialogEditUser();
        }

        public void AkunPhone(View view) {
            DialogEditPhone();
        }
        public void AkunAlamat(View view) {
            DialogEditAlamat();

        }


        private void DialogEditUser(){
            mAlertAboutApp = new AlertDialog.Builder(Account_Activity.this);
            mAlertAboutAppInflater = getLayoutInflater();
            dialogView = mAlertAboutAppInflater.inflate(R.layout.alert_edit, null);
            mAlertAboutApp.setCancelable(true);

            malertTittle = dialogView.findViewById(R.id.alertTittle);
            malertTittle.setText("Ubah Username");

            instance = PreferenceHelper.getInstance(getApplicationContext());

            UserEdit = dialogView.findViewById(R.id.editAccount);
            UserEdit.setText(instance.getName());

            TmblSimpan = dialogView.findViewById(R.id.alertSimpan);
            TmblSimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String User = UserEdit.getText().toString();
                    instance.setName(User);
                    UserEdit.setText(instance.getName());
                    startActivity(new Intent(Account_Activity.this, Account_Activity.class));
                    finish();
                }
            });
            mAlertAboutApp.setView(dialogView);
            mAlertAboutApp.create();
            mAlertAboutApp.show();
        }
        private void DialogEditPhone(){
            mAlertAboutApp = new AlertDialog.Builder(Account_Activity.this);
            mAlertAboutAppInflater = getLayoutInflater();
            dialogView = mAlertAboutAppInflater.inflate(R.layout.alert_edit, null);

            mAlertAboutApp.setCancelable(true);
            instance = PreferenceHelper.getInstance(getApplicationContext());

            malertTittle = dialogView.findViewById(R.id.alertTittle);
            malertTittle.setText("Ubah Nomor Telephone");
            UserEdit = dialogView.findViewById(R.id.editAccount);
            UserEdit.setText(instance.getNoTelp());

            TmblSimpan = dialogView.findViewById(R.id.alertSimpan);
            TmblSimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Phone = UserEdit.getText().toString();
                    instance.setNoTelp(Phone);
                    UserEdit.setText(instance.getNoTelp());
                    startActivity(new Intent(Account_Activity.this, Account_Activity.class));
                    finish();
                }
            });
            mAlertAboutApp.setView(dialogView);
            mAlertAboutApp.create();
            mAlertAboutApp.show();
        }
        private void DialogEditAlamat(){
            mAlertAboutApp = new AlertDialog.Builder(Account_Activity.this);
            mAlertAboutAppInflater = getLayoutInflater();
            dialogView = mAlertAboutAppInflater.inflate(R.layout.alert_edit, null);
            mAlertAboutApp.setCancelable(true);

            malertTittle = dialogView.findViewById(R.id.alertTittle);
            malertTittle.setText("Ubah Alamat");

            instance = PreferenceHelper.getInstance(getApplicationContext());

            UserEdit = dialogView.findViewById(R.id.editAccount);
            UserEdit.setText(instance.getAlamat());

            TmblSimpan = dialogView.findViewById(R.id.alertSimpan);
            TmblSimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Alamat = UserEdit.getText().toString();
                    instance.setAlamat(Alamat);
                    UserEdit.setText(instance.getAlamat());
                    startActivity(new Intent(Account_Activity.this, Account_Activity.class));
                    finish();
                }
            });
            mAlertAboutApp.setView(dialogView);
            mAlertAboutApp.create();
            mAlertAboutApp.show();
        }

    }
