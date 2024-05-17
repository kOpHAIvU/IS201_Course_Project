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
    EditText id, name, address, phoneNum, gender, level, appointmentNum;
    Button doneBtn, exitBtn;
    TextView nameErr, addrErr, phoneErr, genderErr, missingField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_potential_student);

        String message = getIntent().getStringExtra("studentID");
        if (!message.equals("")) {
            id.setText(message);
            /*name.setText();
            address.setText();
            phoneNum.setText();
            gender.setText();
            level.setText();
            appointmentNum.setText();*/
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

                if (id.equals("") || address.equals("") || level.equals("") || appointmentNum.equals("")) {
                    acceptSwitch = false;
                    missingField.setVisibility(View.VISIBLE);
                } else missingField.setVisibility(View.GONE);

                if (name.equals("")) {
                    acceptSwitch = false;
                    nameErr.setText("Không để trống tên");
                } else nameErr.setText("Học viên tiềm năng");

                String genderInp = gender.getText().toString();
                if (!genderInp.equals("Nam") && !genderInp.equals("Nữ")) {
                    acceptSwitch = false;
                    genderErr.setVisibility(View.VISIBLE);
                } else genderErr.setVisibility(View.GONE);

                String regexPhone = "^(\\+[0-9]{1,3}[- ]?)?([0-9]{10,12})$";
                String phone = phoneNum.getText().toString();
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
                                        id.getText().toString(),
                                        name.getText().toString(),
                                        phoneNum.getText().toString(),
                                        gender.getText().toString(),
                                        address.getText().toString(),
                                        level.getText().toString(),
                                        appointmentNum.getText().toString())
                        );

                        if (rowEffect > 0) {
                            Toast.makeText(Activity_Add_Potential_Student.this,
                                    "Thêm học viên tiềm năng mới thành công", Toast.LENGTH_SHORT).show();
                            Log.d("Add potential student:", "success");
                        }else {
                            Log.d("Add potential student:", "fail");
                        }
                        id.setText(null);
                        name.setText(null);
                        address.setText(null);
                        phoneNum.setText(null);
                        gender.setText(null);
                        level.setText(null);
                        appointmentNum.setText(null);

                    } catch (Exception e) {
                        Log.d("Add potential student error:", "fail");
                    }
                }
                else Toast.makeText(Activity_Add_Potential_Student.this, "Nhập lại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}