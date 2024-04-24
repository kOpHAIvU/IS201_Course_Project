package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Change_Setting extends AppCompatActivity {
    private TextView birthErr, genderErr, phoneNumErr, addressErr, passErr;     //Hiển thị thông báo nhập sai dữ liệu
    private Button done;
    private EditText birthInp, genderInp, phoneInp, addrInp, passInp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_setting);

        birthErr = findViewById(R.id.wrong_birth);
        genderErr = findViewById(R.id.wrong_gender);
        phoneNumErr = findViewById(R.id.wrong_number);
        addressErr = findViewById(R.id.wrong_address);
        passErr = findViewById(R.id.wrong_password);

        birthErr.setVisibility(View.GONE);
        genderErr.setVisibility(View.GONE);
        phoneNumErr.setVisibility(View.GONE);
        addressErr.setVisibility(View.GONE);
        passErr.setVisibility(View.GONE);

        birthInp = findViewById(R.id.input_birth);
        genderInp = findViewById(R.id.input_gender);
        phoneInp = findViewById(R.id.input_phone);
        addrInp = findViewById(R.id.input_addr);
        passInp = findViewById(R.id.input_password);

        done = findViewById(R.id.doneBtn);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean acceptSwitch = true;    //Đúng thì mới trả về Fragmen_Setting

                String regexBirth = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
                String birth = birthInp.getText().toString();
                if (!birth.matches(regexBirth)) {
                    acceptSwitch = false;
                    birthErr.setVisibility(View.VISIBLE);
                } else birthErr.setVisibility(View.GONE);

                String gender = genderInp.getText().toString();
                if (!gender.equals("Nam") && !gender.equals("Nữ")) {
                    acceptSwitch = false;
                    genderErr.setVisibility(View.VISIBLE);
                } else genderErr.setVisibility(View.GONE);

                String regexPhone = "^(\\+[0-9]{1,3}[- ]?)?([0-9]{10,12})$";
                String phone = phoneInp.getText().toString();
                if (!phone.matches(regexPhone)) {
                    acceptSwitch = false;
                    phoneNumErr.setVisibility(View.VISIBLE);
                } else phoneNumErr.setVisibility(View.GONE);

                String address = addrInp.getText().toString();
                if (address.equals("")) {
                    acceptSwitch = false;
                    addressErr.setVisibility(View.VISIBLE);
                } else addressErr.setVisibility(View.GONE);

                String pass = passInp.getText().toString();
                if (pass.length() < 8) {
                    acceptSwitch = false;
                    passErr.setVisibility(View.VISIBLE);
                } else passErr.setVisibility(View.GONE);

                if (acceptSwitch)
                    finish();
                else Toast.makeText(Activity_Change_Setting.this, "Nhập lại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}