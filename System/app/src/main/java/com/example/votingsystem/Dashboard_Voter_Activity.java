package com.example.votingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Dashboard_Voter_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_voter);
    }

    public void goToCandi(View view)
    {
        Intent intent = new Intent(this, Candidate_Info_Activity.class);
        startActivity(intent);
    }
    public void goToVote(View view)
    {
        Intent intent = new Intent(this, Vote_Activity.class);
        startActivity(intent);
    }
    public void goToResult(View view)
    {
        Intent intent = new Intent(this, Result_Activity.class);
        startActivity(intent);
    }
}
