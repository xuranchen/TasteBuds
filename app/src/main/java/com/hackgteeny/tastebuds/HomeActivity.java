package com.hackgteeny.tastebuds;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hackgteeny.tastebuds.Model.User;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
    }

    public void viewProfile(View v) {
        Intent i = getIntent();
        User u = (User) i.getSerializableExtra("curUser");
        Intent intent = new Intent(this, ProfileActivity.class);
        intent.putExtra("curUser", u);
        startActivity(intent);
    }


    public void viewFriendList(View v) {
        Intent i = getIntent();
        User u = (User) i.getSerializableExtra("curUser");
        Intent intent = new Intent(this, FriendActivity.class);
        intent.putExtra("curUser", u);
        startActivity(intent);
    }

    public void logout(View v) {
        finish();
    }
}
