package com.hackgteeny.tastebuds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    public void register() {
        if (isValid()) {

            //TODO Serialize to server

        }
        finish();
    }
    public void cancel() {
        finish();
    }
    private boolean isValid() {
        if (username.getText().toString().isEmpty()
                || email.getText().toString().isEmpty()
                || confirm_email.getText().toString().isEmpty()
                || password.getText().toString().isEmpty()
                || confirm_password.getText().toString().isEmpty()) {
            createError("One or more fields are not complete");
            return false;
        }
        if (password.getText().toString() != confirm_password.getText().toString()) {
            createError("The passwords given do not match");
            return false;
        }
        if (email.getText().toString() != confirm_email.getText().toString()) {
            createError("The emails given do not match");
            return false;
        }
        if (false) {//TODO Query server to see if user is already registered
            createError("User is already registered, please choose another username");
            return false;
        }
        return true;
    }
    private void createError(String text) {
        Toast t = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();
    }
}
