package com.example.votingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class Candidate_Admin_Activity extends AppCompatActivity {
   // FirebaseFirestore db = FirebaseFirestore.getInstance();
    protected static final String TAG = "Done";
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference condRef = rootRef.child("Candidate");
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);
        condRef.setValue(0);
        canSelect();
    }
    public void canSelect() {
        start = findViewById(R.id.Edit);
        final RadioGroup rg = findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton3) {
                    Toast.makeText(Candidate_Admin_Activity.this, "Candidate 1 selected!", Toast.LENGTH_LONG).show();
                    condRef.setValue("1");

                } else if (checkedId == R.id.radioButton4) {
                    Toast.makeText(Candidate_Admin_Activity.this, "Candidate 2 selected!", Toast.LENGTH_LONG).show();
                    condRef.setValue("2");

                } else if (checkedId == R.id.radioButton5) {
                    Toast.makeText(Candidate_Admin_Activity.this, "Candidate 3 selected!", Toast.LENGTH_LONG).show();
                    condRef.setValue("3");

                } else if (checkedId == R.id.radioButton6) {

                    Toast.makeText(Candidate_Admin_Activity.this, "Candidate 4 selected!", Toast.LENGTH_LONG).show();
                    condRef.setValue("4");
                }
                rg.getCheckedRadioButtonId();
            }
        });
    }
    public void goToCandidateEdit(View view) {
        Intent intent = new Intent(this, Candidate_Edit_Activity.class);
        startActivity(intent);
    }
    public void goToCandidateAdd(View view) {
        Intent intent = new Intent(this, Candidate_Add_Activity.class);
        startActivity(intent);
    }
}
