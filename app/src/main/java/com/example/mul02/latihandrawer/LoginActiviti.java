package com.example.mul02.latihandrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by R_sap on 27/10/2016.
 */

public class LoginActiviti extends AppCompatActivity {
    EditText user, pass;

    private final String NAMA = "Belajar Session";
    private final String EMAIL = "enung@gmail.com";

    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";

    Button btnLogin;

    SessionManage session;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        session = new SessionManage(getApplicationContext());

        user = (EditText) findViewById(R.id.txtUsername);
        pass = (EditText) findViewById(R.id.txtPassword);

        Toast.makeText(getApplicationContext(), "User Login Status: "+ session.isLoggedIn(), Toast.LENGTH_LONG).show();

        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String username = user.getText().toString();
                String password = pass.getText().toString();

                if (username.trim().length() > 0 && password.trim().length() > 0) {
                    if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                        session.createLoginSession(NAMA, EMAIL);

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);

                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Login Gagal..\n" + "Username/Password anda salah", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Login Gagal..\n" + "Silakan masukan username dan password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}
