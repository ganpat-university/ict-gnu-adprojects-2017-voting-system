package com.example.votingsystem;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Result_Activity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    DocumentReference candi1 = db.collection("Vote").document("Candidate 1");
    DocumentReference candi2 = db.collection("Vote").document("Candidate 2");
    DocumentReference candi3 = db.collection("Vote").document("Candidate 3");
    DocumentReference candi4 = db.collection("Vote").document("Candidate 4");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
    }

    public void show_result(View view)
    {
        final TextView textDisplay = findViewById(R.id.First);
        candi1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    assert doc != null;
                    String fields = "Candidate 1: "+
                            "\nvotes are " + doc.get("count");
                    textDisplay.setText(fields);
                }
            }
        });

        final TextView textDisplay1 = findViewById(R.id.Second);
        candi2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    assert doc != null;
                    String fields = "Candidate 2: "+
                            "\nvotes are " + doc.get("count");
                    textDisplay1.setText(fields);
                }

            }
        });

        final TextView textDisplay2 = findViewById(R.id.Third);
        candi3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    assert doc != null;
                    String fields = "Candidate 3: "+
                            "\nvotes are " + doc.get("count");
                    textDisplay2.setText(fields);
                }

            }
        });

        final TextView textDisplay3 = findViewById(R.id.Fourth);
        candi4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    assert doc != null;
                    String fields = "Candidate 4: "+
                            "\nvotes are " + doc.get("count");
                    textDisplay3.setText(fields);
                }

            }
        });

    }
}