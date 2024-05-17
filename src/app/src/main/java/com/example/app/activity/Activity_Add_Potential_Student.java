package com.example.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.adapter.PotentialStudentDAO;
import com.example.app.model.PotentialStudentDTO;

import java.time.LocalDate;

public class Activity_Add_Potential_Student extends AppCompatActivity {
    EditText studentID, studentName, phoneNumber, gender, address, level, appointmentNumber;
    Button doneBtn, exitBtn;
    TextView nameErr, addrErr, phoneErr, genderErr, missingField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_potential_student);

        studentID = findViewById(R.id.input_studentID);
        studentName = findViewById(R.id.input_name);
        phoneNumber = findViewById(R.id.input_phone);
        gender = findViewById(R.id.input_gender);
        level = findViewById(R.id.input_level);
        address = findViewById(R.id.input_addr);
        appointmentNumber = findViewById(R.id.input_appointment_number);

        String message = getIntent().getStringExtra("studentID");
        if (!message.equals("")) {
            studentID.setText(message);
            /*studentName.setText();
            address.setText();
            phoneNumber.setText();
            gender.setText();
            level.setText();
            appointmentNumber.setText();*/
        }

        missingField = findViewById(R.id.field_need_mandatory);
        missingField.setVisibility(View.GONE);

        phoneErr = findViewById(R.id.wrong_number);
        phoneErr.setVisibility(View.GONE);

        genderErr = findViewById(R.id.wrong_gender);
        genderErr.setVisibility(View.GONE);

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
                boolean acceptSwitch = true;    //Đúng thì mới trả về Fragmen_Setting

                if (studentID.equals("") || address.equals("") || level.equals("") || appointmentNumber.equals("")) {
                    acceptSwitch = false;
                    missingField.setVisibility(View.VISIBLE);
                } else missingField.setVisibility(View.GONE);

                if (studentName.equals("")) {
                    acceptSwitch = false;
                    nameErr.setText("Không để trống tên");
                } else nameErr.setText("Học viên tiềm năng");

                String genderInp = gender.getText().toString();
                if (!genderInp.equals("Nam") && !genderInp.equals("Nữ")) {
                    acceptSwitch = false;
                    genderErr.setVisibility(View.VISIBLE);
                } else genderErr.setVisibility(View.GONE);

                String regexPhone = "^(\\+[0-9]{1,3}[- ]?)?([0-9]{10,12})$";
                String phone = phoneNumber.getText().toString();
                if (!phone.matches(regexPhone)) {
                    acceptSwitch = false;
                    phoneErr.setVisibility(View.VISIBLE);
                } else phoneErr.setVisibility(View.GONE);

                String addressInp = address.getText().toString();
                if (addressInp.equals("")) {
                    acceptSwitch = false;
                    addrErr.setVisibility(View.VISIBLE);
                } else addrErr.setVisibility(View.GONE);

                if (acceptSwitch) {
                    try {
                        int rowEffect = PotentialStudentDAO.getInstance(Activity_Add_Potential_Student.this).InsertPotentialStudent(
                                Activity_Add_Potential_Student.this, new PotentialStudentDTO(
                                        studentID.getText().toString(),
                                        studentName.getText().toString(),
                                        phoneNumber.getText().toString(),
                                        gender.getText().toString(),
                                        address.getText().toString(),
                                        level.getText().toString(),
                                        appointmentNumber.getText().toString())
                        );

                        if (rowEffect > 0) {
                            Toast.makeText(Activity_Add_Potential_Student.this,
                                    "Thêm học viên tiềm năng mới thành công", Toast.LENGTH_SHORT).show();
                            Log.d("Add potential student:", "success");
                        }else {
                            Log.d("Add potential student:", "fail");
                        }
                        studentID.setText(null);
                        studentName.setText(null);
                        address.setText(null);
                        phoneNumber.setText(null);
                        gender.setText(null);
                        level.setText(null);
                        appointmentNumber.setText(null);

                    } catch (Exception e) {
                        Log.d("Add potential student error:", "fail");
                    }
                }
                else Toast.makeText(Activity_Add_Potential_Student.this, "Nhập lại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}