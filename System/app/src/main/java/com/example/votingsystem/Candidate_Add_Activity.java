package com.example.votingsystem;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Candidate_Add_Activity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference condRef = rootRef.child("CandidateC");

    protected static final String TAG = "Done";
    public int candy = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_candidate);



        condRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                candy = dataSnapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    public void send_data(View view)
    {
        final EditText Name = findViewById(R.id.CandidateName);
        final EditText Party = findViewById(R.id.PartyName);
        final EditText Des = findViewById(R.id.Description);
        final Button addc = findViewById(R.id.AddC);



        if(candy<5) {
            String name = Name.getText().toString();
            String party = Party.getText().toString();
            String des = Des.getText().toString();

            Map<String, Object> dataToSave = new HashMap<>();
            dataToSave.put("Name", name);
            dataToSave.put("Party", party);
            dataToSave.put("Description", des);

            db.collection("Candidate").document("Candidate " + candy).set(dataToSave)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG, "Data Fetched");
                            Name.setText("");
                            Party.setText("");
                            Des.setText("");
                            candy = candy + 1;
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.w(TAG, "Error", e);
                }
            });
            condRef.setValue(candy);
        }
        else
        {
            addc.setEnabled(false);
        }
    }
}