package com.example.votingsystem;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Candidate_Add_Activity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    protected static final String TAG = "Done";
    public int candy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_candidate);
    }

    public void send_data(View view)
    {
        final EditText Name = findViewById(R.id.CandidateName);
        final EditText Party = findViewById(R.id.PartyName);
        final EditText Des = findViewById(R.id.Description);

        String name = Name.getText().toString();
        String party = Party.getText().toString();
        String des = Des.getText().toString();

        Map<String,Object> dataToSave = new HashMap<>();
        dataToSave.put("Name",name);
        dataToSave.put("Party",party);
        dataToSave.put("Description",des);

        db.collection("Candidate").document("Candidate "+candy).set(dataToSave)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "Data Fetched");
                Name.setText("");
                Party.setText("");
                Des.setText("");
                candy = candy +1;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error", e);
            }
        });
    }
}
