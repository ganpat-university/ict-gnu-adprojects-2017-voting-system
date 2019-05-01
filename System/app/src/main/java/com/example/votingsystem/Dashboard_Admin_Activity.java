package com.example.votingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard_Admin_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_admin);
    }
    public void goToCandidateInfo(View view)
    {
        Intent intent = new Intent(this, Candidate_Admin_Activity.class);
        startActivity(intent);
    }
    public void goVoteView(View view)
    {
        Intent intent = new Intent(this, Voting_Admin_Activity.class);
        startActivity(intent);
    }
    public void goToResultAdmin(View view)
    {
        Intent intent = new Intent(this, Result_Admin_Activity.class);
        startActivity(intent);
    }

    public void Logout(View view) {
        findViewById(R.id.Logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Dashboard_Admin_Activity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
            }
        });
    }


}
