package com.example.votingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToAdmin(View view)
    {
        Intent intent = new Intent(this, Dashboard_Admin_Activity.class);
        startActivity(intent);
    }

    public void goToVoters(View view)
    {
        Intent intent = new Intent(this, Dashboard_Voter_Activity.class);
        startActivity(intent);
    }
}
