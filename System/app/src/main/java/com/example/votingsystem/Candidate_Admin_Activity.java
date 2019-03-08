package com.example.votingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Candidate_Admin_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);
    }
    public void goToCandidateEdit(View view) {
        Intent intent = new Intent(this, Candidate_Edit_Activity.class);
        startActivity(intent);
    }
}
