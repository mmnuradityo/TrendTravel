package com.project_n.tourandtravelproject.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.util.PreferenceHelper;

public class RegistrasiActivity extends AppCompatActivity {

    EditText Registrasi_Nama, Registrasi_NoTelp, Registrasi_Email, Registrasi_Password, Registrasi_Alamat;
    Button TombolRegistrasi;
    PreferenceHelper instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        Registrasi_Nama = (EditText) findViewById(R.id.RegistrasiNama);
        Registrasi_NoTelp = (EditText) findViewById(R.id.RegistrasiNoTelpfon);
        Registrasi_Email = (EditText) findViewById(R.id.RegistrasiEmail);
        Registrasi_Password = (EditText) findViewById(R.id.RegistrasiPassword);
        Registrasi_Alamat = (EditText) findViewById(R.id.RegistrasiAlamat);

        TombolRegistrasi = (Button) findViewById(R.id.RegistrasiTombol);

        Bundle BundleRegistrasi = getIntent().getExtras();
        Registrasi_Email.setText(BundleRegistrasi.getString("dataEmail"));
        Registrasi_Password.setText(BundleRegistrasi.getString("dataPassword"));

        instance = PreferenceHelper.getInstance(getApplicationContext());

        TombolRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Registrasi_Nama.getText().toString().isEmpty()&&!Registrasi_NoTelp.getText().toString().isEmpty()&&
                        !Registrasi_Email.getText().toString().isEmpty()&&!Registrasi_Password.getText().toString().isEmpty()
                        &&!Registrasi_Alamat.getText().toString().isEmpty()){

                    String User = Registrasi_Nama.getText().toString();
                    String Phone = Registrasi_NoTelp.getText().toString();
                    String Almat = Registrasi_Alamat.getText().toString();
                    String Email = Registrasi_Email.getText().toString();
                    String Pass = Registrasi_Password.getText().toString();

                    instance.setName(User);
                    instance.setNoTelp(Phone);
                    instance.setAlamat(Almat);
                    instance.setEmail(Email);
                    instance.setPass(Pass);
                    instance.setLogin(true);

                    Toast.makeText(getApplicationContext(), "Registrasi Berhasil", Toast.LENGTH_SHORT).show();
                    finish();

                }else {
                    Toast.makeText(getApplicationContext(), "Mohon masukkan dengan benar", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
