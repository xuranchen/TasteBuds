package com.hackgteeny.tastebuds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText confirm_password;
    private EditText email;
    private EditText confirm_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        confirm_email = (EditText) findViewById(R.id.confirm_email);
        password = (EditText) findViewById(R.id.password);
        confirm_password = (EditText) findViewById(R.id.confirm_password);

    }
}
