package com.example.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.adapter.AccountDAO;
import com.example.app.adapter.DataProvider;
import com.example.app.adapter.OfficialStudentDAO;
import com.example.app.adapter.StaffDAO;
import com.example.app.adapter.TeacherDAO;
import com.example.app.model.AccountDTO;
import com.example.app.model.OfficialStudentDTO;
import com.example.app.model.StaffDTO;
import com.example.app.model.TeacherDTO;

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

        // Initialize database

        DataProvider.getInstance(Activity_Login.this).recreateDatabase(Activity_Login.this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // handle login event
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Activity_Login.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(Activity_Login.this, Activity_Main_Screen.class);
                startActivity(intent);

            }
        });

        // Insert data in OFFICIAL_STUDENT

        OfficialStudentDTO student1 = new OfficialStudentDTO("STU1", "Nguyen Van A", "Binh Dinh", "034343434", "Nam", 0);
        OfficialStudentDAO.getInstance(Activity_Login.this).insertOfficialStudent(Activity_Login.this, student1);

        OfficialStudentDTO student2 = new OfficialStudentDTO("STU2", "Le Thi B", "Binh Duong","0232323222", "Nu", 0 );
        OfficialStudentDAO.getInstance(Activity_Login.this).insertOfficialStudent(Activity_Login.this, student2);

        // Insert data in STAFF

        StaffDTO staff1 = new StaffDTO("STA1", "Nguyen Thi C", "TP HCM", "034333333", "1", 0);
        StaffDAO.getInstance(Activity_Login.this).insertOfficialStudent(Activity_Login.this, staff1);

        StaffDTO staff2 = new StaffDTO("STA2", "Nguyen Thi D", "TP HCM", "0343555533", "1", 0);
        StaffDAO.getInstance(Activity_Login.this).insertOfficialStudent(Activity_Login.this, staff2);

        // Insert data in TEACHERS

        TeacherDTO teacher1 = new TeacherDTO("TEA1", "Nguyen Thi E", "Binh Duong", "0346655566", "Nu", 50000000, 0);
        TeacherDAO.getInstance(Activity_Login.this).insertTeacher(Activity_Login.this, teacher1);

        TeacherDTO teacher2 = new TeacherDTO("TEA2", "Nguyen Thi G", "Binh Duong", "0346699966", "Nam", 50000000, 0);
        TeacherDAO.getInstance(Activity_Login.this).insertTeacher(Activity_Login.this, teacher2);

        // Insert data ACCOUNT

        AccountDTO account1 = new AccountDTO("ACC1", "STA1", "nguyenthic", "thic123");


    }
}