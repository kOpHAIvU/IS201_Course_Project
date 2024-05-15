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
    EditText name, address, phoneNum, gender, state, level, appointmentNum;
    Button doneBtn, exitBtn;
    TextView nameErr, addrErr, phoneErr, genderErr, stateLevelAppointErr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_potential_student);

        String message = "";
        name = findViewById(R.id.input_name);
        message = getIntent().getStringExtra("studentName");
        if (message != "")  name.setText(message);
        message = "";

        address = findViewById(R.id.input_addr);
        message = getIntent().getStringExtra("address");
        if (message != "")  address.setText(message);
        message = "";

        phoneNum = findViewById(R.id.input_phone);
        message = getIntent().getStringExtra("phoneNumber");
        if (message != "")  phoneNum.setText(message);
        message = "";

        gender = findViewById(R.id.input_gender);
        message = getIntent().getStringExtra("gender");
        if (message != "")  gender.setText(message);
        message = "";

        state = findViewById(R.id.input_state);
        message = getIntent().getStringExtra("state");
        if (message != "")  state.setText(message);
        message = "";

        level = findViewById(R.id.input_level);
        message = getIntent().getStringExtra("level");
        if (message != "")  level.setText(message);
        message = "";

        appointmentNum = findViewById(R.id.input_appointment_number);
        message = getIntent().getStringExtra("appointmentNumber");
        if (message != "")  appointmentNum.setText(message);
        message = "";

        nameErr = findViewById(R.id.student_type);
        addrErr = findViewById(R.id.wrong_address);
        addrErr.setVisibility(View.GONE);

        phoneErr = findViewById(R.id.wrong_number);
        phoneErr.setVisibility(View.GONE);

        genderErr = findViewById(R.id.wrong_gender);
        genderErr.setVisibility(View.GONE);

        stateLevelAppointErr = findViewById(R.id.wrong_state_level_appointment);
        stateLevelAppointErr.setVisibility(View.GONE);

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

                if (name.getText().toString() == "") {
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

                if (state.getText().toString().equals("") || level.getText().toString().equals("") || appointmentNum.getText().toString().equals("")) {
                    acceptSwitch = false;
                    stateLevelAppointErr.setVisibility(View.VISIBLE);
                } else stateLevelAppointErr.setVisibility(View.GONE);

                if (acceptSwitch) {
                    try {
                        int rowEffect = PotentialStudentDAO.getInstance(Activity_Add_Potential_Student.this).InsertPotentialStudent(
                                Activity_Add_Potential_Student.this, new PotentialStudentDTO(
                                        name.getText().toString(), phoneNum.getText().toString(), gender.getText().toString(),
                                        address.getText().toString(), "0", level.getText().toString(), appointmentNum.getText().toString()));

                        if (rowEffect > 0) {
                            Toast.makeText(Activity_Add_Potential_Student.this,
                                    "Thêm học viên tiềm năng mới thành công", Toast.LENGTH_SHORT).show();
                            Log.d("Add potential student:", "success");
                        }else {
                            Log.d("Add potential student:", "fail");
                        }
                        name.setText(null);
                        address.setText(null);
                        phoneNum.setText(null);
                        gender.setText(null);
                        state.setText(null);
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