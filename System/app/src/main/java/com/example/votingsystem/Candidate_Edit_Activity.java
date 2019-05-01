package com.example.votingsystem;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Candidate_Edit_Activity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    protected static final String TAG = "Done";
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference condRef = rootRef.child("Candidate");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate_edit);
        fetchData();
    }
    public void fetchData() {
        condRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final EditText n = findViewById(R.id.Candidate_Name);
                final EditText pn = findViewById(R.id.Party_Name);
                final EditText d = findViewById(R.id.Description);
                String text = dataSnapshot.getValue(String.class);
                if (text.equals("1")) {
                    DocumentReference user = db.collection("Candidate").document("Candidate 1");
                    user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot doc = task.getResult();
                                assert doc != null;
                                String name = doc.get("Name").toString();
                                String pname = doc.get("Party").toString();
                                String des = doc.get("Description").toString();
                                n.setText(name);
                                pn.setText(pname);
                                d.setText(des);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error", e);
                        }
                    });
                } else if (text.equals("2")) {
                    DocumentReference user = db.collection("Candidate").document("Candidate 2");
                    user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot doc = task.getResult();
                                assert doc != null;
                                String name = doc.get("Name").toString();
                                String pname = doc.get("Party").toString();
                                String des = doc.get("Description").toString();
                                n.setText(name);
                                pn.setText(pname);
                                d.setText(des);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error", e);
                        }
                    });
                } else if (text.equals("3")) {
                    DocumentReference user = db.collection("Candidate").document("Candidate 3");
                    user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot doc = task.getResult();
                                assert doc != null;
                                String name = doc.get("Name").toString();
                                String pname = doc.get("Party").toString();
                                String des = doc.get("Description").toString();
                                n.setText(name);
                                pn.setText(pname);
                                d.setText(des);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error", e);
                        }
                    });
                } else if (text.equals("4")) {
                    DocumentReference user = db.collection("Candidate").document("Candidate 4");
                    user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                            if (task.isSuccessful()) {
                                DocumentSnapshot doc = task.getResult();
                                assert doc != null;
                                String name = doc.get("Name").toString();
                                String pname = doc.get("Party").toString();
                                String des = doc.get("Description").toString();
                                n.setText(name);
                                pn.setText(pname);
                                d.setText(des);
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
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void UpdateData(View view) {

        final EditText Name = findViewById(R.id.Candidate_Name);
        final EditText Party = findViewById(R.id.Party_Name);
        final EditText Des = findViewById(R.id.Description);

        String name = Name.getText().toString();
        String party = Party.getText().toString();
        String des = Des.getText().toString();


       final Map<String,Object> datatoUpdate = new HashMap<>();
        datatoUpdate.put("Name",name);
        datatoUpdate.put("Party",party);
        datatoUpdate.put("Description",des);

        condRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                if(text.equals("1")) {
                    DocumentReference c = db.collection("Candidate").document("Candidate 1");
                    c.update(datatoUpdate)
                            .addOnSuccessListener(new OnSuccessListener< Void >() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Candidate_Edit_Activity.this, "Updated Successfully",
                                            Toast.LENGTH_SHORT).show();
                                    condRef.setValue(0);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error", e);

                        }
                    });
                } else if(text.equals("2")) {
                    DocumentReference c = db.collection("Candidate").document("Candidate 2");
                    c.update(datatoUpdate)
                            .addOnSuccessListener(new OnSuccessListener< Void >() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Candidate_Edit_Activity.this, "Updated Successfully",
                                            Toast.LENGTH_SHORT).show();
                                    condRef.setValue(0);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error", e);

                        }
                    });
                } else if(text.equals("3")) {
                    DocumentReference c = db.collection("Candidate").document("Candidate 3");
                    c.update(datatoUpdate)
                            .addOnSuccessListener(new OnSuccessListener< Void >() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Candidate_Edit_Activity.this, "Updated Successfully",
                                            Toast.LENGTH_SHORT).show();
                                    condRef.setValue(0);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error", e);

                        }
                    });
                } else if(text.equals("4")) {
                    DocumentReference c = db.collection("Candidate").document("Candidate 4");
                    c.update(datatoUpdate)
                            .addOnSuccessListener(new OnSuccessListener< Void >() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Candidate_Edit_Activity.this, "Updated Successfully",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG, "Error", e);

                        }
                    });
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
