package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Activity_Login.this, "All fileds are mandatory", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(new Intent(Activity_Login.this, Activity_Main_Screen.class));
            }
        });
    }
}