package com.example.votingsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Voting_Admin_Activity extends AppCompatActivity {
    Button start ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_admin);
    }

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference condRef = rootRef.child("condition");

    public void Start(View view) {

        //super.onStart();
         start = findViewById(R.id.votestart);


//        condRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String text = dataSnapshot.getValue(String.class);
//                conditionView.setText(text);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condRef.setValue("1");
            }
        });
    }
    public void End(View view)
    {
        Button end = findViewById(R.id.voteend);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condRef.setValue("0");
            }
        });
    }
}
