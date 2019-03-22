package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Vote_Activity extends AppCompatActivity {
  //  DocumentReference demoRef = FirebaseFirestore.getInstance();
    protected String candidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);
    }

    public void canrad() {
        RadioGroup rg = findViewById(R.id.radioGroup2);
        RadioButton votebtn = findViewById(rg.getCheckedRadioButtonId());
        candidate = votebtn.getText().toString();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.radioButton2:
                        candidate = "Candidate 1";
                        break;
                    case R.id.radioButton3:
                        candidate = "Candidate 2";
                        break;
                    case R.id.radioButton4:
                        candidate = "Candidate 3";
                        break;
                    case R.id.radioButton5:
                        candidate = "Candidate 4";
                        break;
                }
            }
        });
    }

    public void gotomainActivity(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}