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
import com.example.app.adapter.OfficialStudentDAO;
import com.example.app.adapter.StaffDAO;
import com.example.app.model.OfficialStudentDTO;
import com.example.app.model.StaffDTO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fragment_Setting extends Fragment {
    private ImageButton settingBtn, logoutBtn;
    private View view;
    private Activity context;
    TextView genderText;
    TextView phoneNumberText;
    TextView addressText;
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

        genderText = context.findViewById(R.id.gender);
        phoneNumberText = context.findViewById(R.id.phone_number);
        addressText = context.findViewById(R.id.address);
        name = context.findViewById(R.id.name);
        position = context.findViewById(R.id.position);

        String idUser = Activity_Login.idUser;
        String titleIdAccount = idUser.substring(0, idUser.length() - 1) ;

        String fullName = "";
        String address = "";
        String phoneNumber = "";
        String gender = "";
        int type = 0;
        String positionText = "";

        if (titleIdAccount.equals("STU")) {
            Log.d("Student Yeah", "success");

            String whereClause = "ID_STUDENT = ?";
            String[] whereArgs = new String[] {idUser};
            Cursor cursor = OfficialStudentDAO.getInstance(context).SelectStudent(context, whereClause, whereArgs);

            if (cursor.moveToFirst()) {
                do {

                    int fullNameIndex = cursor.getColumnIndex("FULLNAME");
                    if (fullNameIndex!= -1) {
                        fullName = cursor.getString(fullNameIndex);
                    }
                    int addressIndex = cursor.getColumnIndex("ADDRESS");
                    if (addressIndex!= -1) {
                        address = cursor.getString(addressIndex);
                    }
                    int phoneNumberIndex = cursor.getColumnIndex("PHONE_NUMBER");
                    if (phoneNumberIndex != -1) {
                        phoneNumber = cursor.getString(phoneNumberIndex);
                    }
                    int genderIndex = cursor.getColumnIndex("GENDER");
                    if (genderIndex != -1) {
                        gender = cursor.getString(genderIndex);
                    }
                    positionText = "Học viên";
                    Log.d("Find Student", fullName + " " + address + " " + phoneNumber + " " + gender);

                } while (cursor.moveToNext());
            }

        }else {
            Log.d("Shift Staff X", "success");
            String whereClause = "ID_STAFF = ?";
            String[] whereArgs = new String[] {idUser};
            Cursor cursor = StaffDAO.getInstance(context).SelectStaff(context, whereClause, whereArgs);

            if (cursor.moveToFirst()) {
                do {
                    int fullNameIndex = cursor.getColumnIndex("FULLNAME");
                    if (fullNameIndex!= -1) {
                        fullName = cursor.getString(fullNameIndex);
                    }
                    int addressIndex = cursor.getColumnIndex("ADDRESS");
                    if (addressIndex!= -1) {
                        address = cursor.getString(addressIndex);
                    }
                    int phoneNumberIndex = cursor.getColumnIndex("PHONE_NUMBER");
                    if (phoneNumberIndex != -1) {
                        phoneNumber = cursor.getString(phoneNumberIndex);
                    }
                    int genderIndex = cursor.getColumnIndex("GENDER");
                    if (genderIndex != -1) {
                        gender = cursor.getString(genderIndex);
                    }
                    int typeIndex = cursor.getColumnIndex("TYPE");
                    if (typeIndex != -1) {
                        type = cursor.getInt(typeIndex);
                        if (type == 1) {
                            positionText = "Quản lý";
                        } else if (type == 2) {
                            positionText = "Nhân viên học vụ";
                        } else {
                            positionText = "Nhân viên điểm danh";
                        }
                    }
                } while (cursor.moveToNext());
            }
        }

        genderText.setText(gender);
        phoneNumberText.setText(phoneNumber);
        addressText.setText(address);
        name.setText(fullName);
        position.setText(positionText);

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