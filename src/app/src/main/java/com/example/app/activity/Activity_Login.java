package com.example.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.adapter.DataProvider;

public class Activity_Login extends AppCompatActivity {
    EditText usernameInput, passwordInput;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput = findViewById(R.id.input_username);
        passwordInput = findViewById(R.id.input_password);
        loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize database
                DataProvider database = new DataProvider(Activity_Login.this);
                if (database.isDatabaseExists(Activity_Login.this)) {
                    Log.d("Connect to database", "successfully");
                } else {
                    Log.d("Connect to database", "failed");
                }

                // handle login event
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Activity_Login.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(new Intent(Activity_Login.this, Activity_Main_Screen.class));

            }
        });
    }
}