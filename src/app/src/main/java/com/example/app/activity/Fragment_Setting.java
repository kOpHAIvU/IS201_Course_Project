package com.example.app.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.app.R;
import com.example.app.adapter.AccountDAO;
import com.example.app.model.OfficialStudentDTO;
import com.example.app.model.StaffDTO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fragment_Setting extends Fragment {
    private ImageButton settingBtn, logoutBtn;
    private View view;
    private Activity context;
    TextView gender;
    TextView phoneNumber;
    TextView address;
    TextView name;
    TextView position;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity();

        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        gender = context.findViewById(R.id.gender);
        phoneNumber = context.findViewById(R.id.phone_number);
        address = context.findViewById(R.id.address);
        name = context.findViewById(R.id.name);
        position = context.findViewById(R.id.position);

        if (Activity_Main_Screen.flag == 1) {
            OfficialStudentDTO student = Activity_Main_Screen.student;
            gender.setText(student.getGender());
            phoneNumber.setText(student.getPhoneNumber());
            address.setText(student.getAddress());
            name.setText(student.getFullName());
            position.setText("Học viên");
        } else {
            StaffDTO staff = Activity_Main_Screen.staff;
            gender.setText(staff.getGender());
            phoneNumber.setText(staff.getPhoneNumber());
            address.setText(staff.getAddress());
            name.setText(staff.getFullName());
            position.setText("Nhân viên");
        }

        settingBtn = context.findViewById(R.id.setting_btn);
        logoutBtn = context.findViewById(R.id.logout_btn);

        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để chuyển sang Activity Change_Setting
                Intent intent = new Intent(getActivity(), Activity_Change_Setting.class);
                startActivity(intent);
            }
        });
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Bạn có chắc chắn muốn đăng xuất không?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), Activity_Login.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Hủy", null);
                builder.show();

            }
        });
    }
}