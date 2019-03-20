package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dashboard_Voter_Activity extends AppCompatActivity {
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference condRef = rootRef.child("condition_result");
    DatabaseReference condref = rootRef.child("condition");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_voter);
        disableVote();
        disableResult();
    }

    public void goToCandi(View view) {
        Intent intent = new Intent(this, Candidate_Info_Activity.class);
        startActivity(intent);
    }

    public void goToVote(View view) {
        Intent intent = new Intent(this, Vote_Activity.class);
        startActivity(intent);
    }

    public void goToResult(View view) {
        Intent intent = new Intent(this, Result_Activity.class);
        startActivity(intent);
    }

    public void disableVote() {
        final Button Vote = findViewById(R.id.vote);
        condref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                if (text.equals("0")) {
                    Vote.setEnabled(false);
                } else if (text.equals("1")) {
                    Vote.setEnabled(true);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void disableResult() {
        final Button Result = findViewById(R.id.showresult);
        condRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                if (text.equals("1")) {
                    Result.setEnabled(true);
                }
                else if (text.equals("0")) {
                    Result.setEnabled(false);
                }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
