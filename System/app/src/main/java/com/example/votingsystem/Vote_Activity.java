package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Vote_Activity extends AppCompatActivity {

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference condRef = rootRef.child("Candidate");
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    final String TAG="Done";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
        canrad();
        final Button btn = findViewById(R.id.Vote);
        btn.setEnabled(false);
    }

    public void canrad(){
        final RadioGroup rg = findViewById(R.id.radioGroup2);
        final Button btn = findViewById(R.id.Vote);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.candi_1) {
                    Toast.makeText(Vote_Activity.this, "Candidate 1 selected!", Toast.LENGTH_LONG).show();
                    condRef.setValue("1");
                    btn.setEnabled(true);

                } else if (checkedId == R.id.candi_2) {
                    Toast.makeText(Vote_Activity.this, "Candidate 2 selected!", Toast.LENGTH_LONG).show();
                    condRef.setValue("2");
                    btn.setEnabled(true);

                } else if (checkedId == R.id.candi_3) {
                    Toast.makeText(Vote_Activity.this, "Candidate 3 selected!", Toast.LENGTH_LONG).show();
                    condRef.setValue("3");
                    btn.setEnabled(true);

                } else if (checkedId == R.id.candi_4) {
                    Toast.makeText(Vote_Activity.this, "Candidate 4 selected!", Toast.LENGTH_LONG).show();
                    condRef.setValue("4");
                    btn.setEnabled(true);

                }
                rg.getCheckedRadioButtonId();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = rg.indexOfChild(findViewById(rg.getCheckedRadioButtonId()));
                if(index==0){
                    DocumentReference c1 = db.collection("Vote").document("Candidate 1");
                    c1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot val = task.getResult();
                                assert val != null;
                                int mat = Integer.parseInt(val.get("Count").toString());
                                mat = mat + 1;
                                String put = String.valueOf(mat);
                                Map<String,Object> dataToSave = new HashMap<>();
                                dataToSave.put("Count",put);
                                db.collection("Vote").document("Candidate 1").set(dataToSave)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "Data Updated");
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error", e);
                                    }
                                });
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error", e);
                        }
                    });
                }
                else if(index==1){
                    DocumentReference c1 = db.collection("Vote").document("Candidate 2");
                    c1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot val = task.getResult();
                                assert val != null;
                                int mat = Integer.parseInt(val.get("Count").toString());
                                mat = mat + 1;
                                String put = String.valueOf(mat);
                                Map<String,Object> dataToSave = new HashMap<>();
                                dataToSave.put("Count",put);
                                db.collection("Vote").document("Candidate 2").set(dataToSave)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "Data Updated");
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error", e);
                                    }
                                });
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error", e);
                        }
                    });
                }
                else if(index==2){
                    DocumentReference c1 = db.collection("Vote").document("Candidate 3");
                    c1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot val = task.getResult();
                                assert val != null;
                                int mat = Integer.parseInt(val.get("Count").toString());
                                mat = mat + 1;
                                String put = String.valueOf(mat);
                                Map<String,Object> dataToSave = new HashMap<>();
                                dataToSave.put("Count",put);
                                db.collection("Vote").document("Candidate 3").set(dataToSave)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "Data Updated");
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error", e);
                                    }
                                });
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error", e);
                        }
                    });
                }
                else if(index==3){
                    DocumentReference c1 = db.collection("Vote").document("Candidate 4");
                    c1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot val = task.getResult();
                                assert val != null;
                                int mat = Integer.parseInt(val.get("Count").toString());
                                mat = mat + 1;
                                String put = String.valueOf(mat);
                                Map<String,Object> dataToSave = new HashMap<>();
                                dataToSave.put("Count",put);
                                db.collection("Vote").document("Candidate 4").set(dataToSave)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG, "Data Updated");
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error", e);
                                    }
                                });
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
        });
    }

    public void Logout(View view){
        Intent intent = new Intent(this, Dashboard_Voter_Activity.class);
        startActivity(intent);
    }
}