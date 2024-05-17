package com.example.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.app.R;
import com.example.app.model.ClassDTO;

public class Activity_Add_Class extends AppCompatActivity {
    EditText classID, className, startDate, endDate, programID, teacherName, staffID;
    Button exitBtn, doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        classID = findViewById(R.id.classID);
        className = findViewById(R.id.class_name);
        startDate = findViewById(R.id.start_date);
        endDate = findViewById(R.id.end_date);
        programID = findViewById(R.id.programID);
        teacherName = findViewById(R.id.teacher_name);
        staffID = findViewById(R.id.staffID);

        String message = getIntent().getStringExtra("classID");
        if (!message.equals("")) {
            /*classID.setText();
            className.setText();
            startDate.setText();
            endDate.setText();
            programID.setText();
            teacherName.setText();
            staffID.setText();
            toolbar.setTitle(className.getText().toString()  + classID.getText().toString());*/
        }


        exitBtn = findViewById(R.id.exit_btn);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        doneBtn = findViewById(R.id.done_btn);
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (className.getText().toString().equals("") || classID.getText().toString().equals("")
                        || startDate.getText().toString().equals("") || teacherName.getText().toString().equals("")
                        || endDate.getText().toString().equals("") || programID.getText().toString().equals("")
                        || staffID.getText().toString().equals("")) {
                    Toast.makeText(Activity_Add_Class.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.normal_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}