package com.example.votingsystem;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Candidate_Info_Activity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    protected static final String TAG = "Done";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_info);
        setCandi_1();
        setCandi_2();
        setCandi_3();
        setCandi_4();
    }

    public void setCandi_1() {
        final TextView textDisplay = findViewById(R.id.Candidate_1);
        DocumentReference user = db.collection("Candidate").document("Candidate 1");
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    assert doc != null;
                    String fields = "Name: " + doc.get("Name") +
                            "\nParty " + doc.get("Party") +
                            "\nDescription " + doc.get("Description");
                    textDisplay.setText(fields);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error", e);
                    }
                });
    }

    public void setCandi_2() {
        final TextView textDisplay = findViewById(R.id.Candidate_2);
        DocumentReference user = db.collection("Candidate").document("Candidate 2");
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    assert doc != null;
                    String fields = "Name: " + doc.get("Name") +
                            "\nParty " + doc.get("Party") +
                            "\nDescription " + doc.get("Description");
                    textDisplay.setText(fields);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error", e);
            }
        });
    }

    public void setCandi_3() {
        final TextView textDisplay = findViewById(R.id.Candidate_3);
        DocumentReference user = db.collection("Candidate").document("Candidate 3");
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    assert doc != null;
                    String fields = "Name: " + doc.get("Name") +
                            "\nParty " + doc.get("Party") +
                            "\nDescription " + doc.get("Description");
                    textDisplay.setText(fields);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error", e);
            }
        });
    }

    public void setCandi_4() {
        final TextView textDisplay = findViewById(R.id.Candidate_4);
        DocumentReference user = db.collection("Candidate").document("Candidate");
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    assert doc != null;
                    String fields = "Name: " + doc.get("Name") +
                            "\nParty " + doc.get("Party") +
                            "\nDescription " + doc.get("Description");
                    textDisplay.setText(fields);
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error", e);
            }
        });
    }
}
