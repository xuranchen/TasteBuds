package com.hackgteeny.tastebuds;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
public class FriendActivity extends ListActivity {
    LinearLayout ll;
    ArrayList<String> FL = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
        ll = (LinearLayout) findViewById(R.id.fl);
        String[] fl = {"lol", "This", "is", "snek"};
        for (String s : fl) {
            TextView t = new TextView(this);
            t.setText(s);
            ll.addView(t);
        }


    }
}
