package com.hackgteeny.tastebuds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hackgteeny.tastebuds.Model.User;

public class ProfileActivity extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private TextView food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent i = getIntent();
        User u = (User) i.getSerializableExtra("curUser");
        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);
        food = (TextView) findViewById(R.id.faveFood);

        name.setText(u.getName());
        email.setText(u.getEmail());
        food.setText(u.getFaveFood());

    }

    public void editProfile(View v) {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }
}
