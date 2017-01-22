package com.hackgteeny.tastebuds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackgteeny.tastebuds.Model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private EditText confirm_password;
    private EditText email;
    private EditText confirm_email;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    private Button registerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        confirm_email = (EditText) findViewById(R.id.confirm_email);
        password = (EditText) findViewById(R.id.password);
        confirm_password = (EditText) findViewById(R.id.confirm_password);
        mDatabase.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                registerButton = (Button) findViewById(R.id.register_button);
                registerButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        register(dataSnapshot);
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    private void makeToast(String message) {
        Toast t = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        t.show();
    }
    private boolean userExists(String user, DataSnapshot dataSnapshot) {
        for (DataSnapshot child : dataSnapshot.getChildren()) {
            if (child.getKey().equals(user)) {
                return true;
            }
        }
        return false;
    }

    public void register(DataSnapshot dataSnapshot) {
        if (isValid()) {
            User newUser = new User(username.getText().toString(),
                                    email.getText().toString(),
                                    password.getText().toString());
            if (!userExists(newUser.getUsername(), dataSnapshot)) {
                //register user
                Log.d("ij", "onAuthStateChanged:signed_in:" + newUser);
                mDatabase.child("Users").updateChildren(userToMap(newUser));
                makeToast("Successfully Registered!");
                finish();

            } else {
                makeToast("Username already exists! Please select another username!");
            }
        }

    }

    private  Map<String, Object> userToMap(User u) {
        Map<String, Object> tempMap = new HashMap<>();
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("email", u.getEmail());
        retMap.put("password", u.getPassword());
//        retMap.put("favefood", u.getFaveFood());
        retMap.put("groups", u.getGroups());
        retMap.put("friends", u.getFriends());
        tempMap.put(u.getUsername(), retMap);

        return tempMap;
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
        if (!password.getText().toString().equals(confirm_password.getText().toString())) {
            createError("The passwords given do not match");
            return false;
        }
        if (!email.getText().toString().equals(confirm_email.getText().toString())) {
            createError("The emails given do not match");
            return false;
        }
        if (false) {//TODO Query server to see if user is already registered
            createError("User is already registered, please choose another username");
            return false;
        }
        // check in firebase

        return true;
    }
    private void createError(String text) {
        Toast t = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        t.show();
    }
}
