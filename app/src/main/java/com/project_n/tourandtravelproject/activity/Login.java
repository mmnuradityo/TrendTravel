package com.project_n.tourandtravelproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.project_n.tourandtravelproject.Main;
import com.project_n.tourandtravelproject.R;
import com.project_n.tourandtravelproject.util.PreferenceHelper;


public class Login extends AppCompatActivity {

    Button Registrasi, Login;
    EditText Login_Email, Login_Password;
    PreferenceHelper instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Registrasi = (Button) findViewById(R.id.LoginRegistrasi);
        Login = (Button) findViewById(R.id.LoginTombol);

        Login_Email= (EditText) findViewById(R.id.LoginEmail);
        Login_Password = (EditText) findViewById(R.id.LoginPassword);

        instance = PreferenceHelper.getInstance(getApplicationContext());

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = Login_Email.getText().toString();
                String Pass = Login_Password.getText().toString();
                String mEmail = instance.getEmail();
                String mPass = instance.getPass();
                boolean cekEmail = Email.equals(mEmail);
                boolean cekPass = Pass.equals(mPass);

                if ( cekEmail && cekPass ) {
                    //jika login berhasil
                    instance.setLogin(true);
                    Toast.makeText( getApplicationContext(), "Login Berhasil",
                            Toast.LENGTH_SHORT ).show();
                    Intent intent = new Intent( Login.this, Main.class );
                    Login.this.startActivity( intent );
                    finish();
                } else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setMessage("Alamat E-mail atau Password Anda salah!")
                            .setNegativeButton("Retry", null).create().show();
                }
            }
        });

        Registrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle BundleLogin = new Bundle();
                BundleLogin.putString("dataEmail", Login_Email.getText().toString());
                BundleLogin.putString("dataPassword", Login_Password.getText().toString());
                Intent i = new Intent(Login.this, RegistrasiActivity.class);
                i.putExtras(BundleLogin);
                startActivity(i);
            }
        });

        CheckBox cekLogin = (CheckBox) findViewById(R.id.checkBoxLogin);

        cekLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b){
                    Login_Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    Login_Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }
}
