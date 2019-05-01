package com.example.votingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainAdminLogin extends AppCompatActivity {

    private String Username = "admin";
    private String Password = "Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin_login);
    }

    public void Login(View view)
    {
        EditText username = findViewById(R.id.UserName);
        EditText password = findViewById(R.id.Password);

        if(username.getText().toString().equals(Username) && password.getText().toString().equals(Password))
        {
            Intent intent = new Intent(this, Dashboard_Admin_Activity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(MainAdminLogin.this, "Username or Password is Incorrect", Toast.LENGTH_LONG).show();
        }
    }

}
