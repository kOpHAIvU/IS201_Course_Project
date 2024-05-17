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

public class Activity_Add_Class extends AppCompatActivity {
    Toolbar toolbar;
    EditText name, id, level, teacherName, schoolTime, tuition, roomID, programID, staffID;
    Button exitBtn, doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        toolbar = findViewById(R.id.toolbar);
        name = findViewById(R.id.class_name);
        id = findViewById(R.id.classID);
        level = findViewById(R.id.level);
        teacherName = findViewById(R.id.teacher_name);
        schoolTime = findViewById(R.id.school_time);
        tuition = findViewById(R.id.tuition);
        roomID = findViewById(R.id.roomID);
        programID = findViewById(R.id.programID);
        staffID = findViewById(R.id.staffID);

        toolbar.setTitle(name.getText().toString()  + id.getText().toString());

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
                if (name.getText().toString().equals("") || id.getText().toString().equals("")
                        || level.getText().toString().equals("") || teacherName.getText().toString().equals("")
                        || schoolTime.getText().toString().equals("") || tuition.getText().toString().equals("")
                        || roomID.getText().toString().equals("") || programID.getText().toString().equals("")
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