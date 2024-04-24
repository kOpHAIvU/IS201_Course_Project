package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                //M xử lý nhập xuất dữ liệu xong, nếu có lỗi thì mấy biến TextView
                // thêm .setVisibility(View.VISIBLE); để nó báo lỗi
                finish();
            }
        });
    }
}