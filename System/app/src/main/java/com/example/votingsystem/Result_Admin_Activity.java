package com.example.votingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Result_Admin_Activity extends AppCompatActivity {
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference condRef = rootRef.child("condition_result");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_admin);
    }

    public void Show(View view) {
        Button show = findViewById(R.id.button2);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condRef.setValue("1");
            }
        });
    }
    public void End (View view)
    {
        Button end = findViewById(R.id.button3);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condRef.setValue("0");
            }
        });
    }
}
