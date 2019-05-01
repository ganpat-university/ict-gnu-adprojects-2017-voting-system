package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(this, MainVerification.class);
//        startActivity(intent);

        editText = findViewById(R.id.EditTextNumber);

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = editText.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editText.setError("Valid number is required");
                    editText.requestFocus();
                    return;
                }

                String phoneNumber = "+" + "91" + number;

                Intent intent = new Intent(MainActivity.this, MainVerification.class);
                intent.putExtra("PhoneNumber", phoneNumber);
                startActivity(intent);
            }
        });
    }

    public void goToAdminLogin(View view) {
        Intent intent = new Intent(this, MainAdminLogin.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, Dashboard_Voter_Activity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
