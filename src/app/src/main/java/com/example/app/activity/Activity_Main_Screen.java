package com.example.app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.example.app.R;
import com.example.app.adapter.AccountDAO;
import com.example.app.adapter.OfficialStudentDAO;
import com.example.app.adapter.StaffDAO;
import com.example.app.model.OfficialStudentDTO;
import com.example.app.model.StaffDTO;
import com.example.app.model.TeacherDTO;
import com.example.app.model.View_Pager_Adapter;
import com.google.android.material.tabs.TabLayout;

public class Activity_Main_Screen extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static OfficialStudentDTO student;
    public static StaffDTO staff;
    public static int flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        /*Intent intent = getIntent();
        String value = intent.getStringExtra("chucvu");*/

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPage);

        tabLayout.setupWithViewPager(viewPager);

        View_Pager_Adapter viewPagerAdapter = new View_Pager_Adapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragment(new Fragment_Information(), "                  Thông tin                  ");
        viewPagerAdapter.addFragment(new Fragment_Setting(), "                  Cài đặt                  ");
        viewPager.setAdapter(viewPagerAdapter);

        String idUser = Activity_Login.idAccount;
        String titleIdAccount = idUser.substring(0, idUser.length() - 1) ;

        if (titleIdAccount.equals("STU")) {
            Log.d("Student Yeah", "success");
            flag = 1;
            String whereClause = "ID_STUDENT = ?";
            String[] whereArgs = new String[] {idUser};
            Cursor cursor = OfficialStudentDAO.getInstance(this).SelectStudent(this, whereClause, whereArgs);

            if (cursor.moveToFirst()) {
                do {
                    String fullName = "";
                    String address = "";
                    String phoneNumber = "";
                    String gender = "";

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
                    student = new OfficialStudentDTO(idUser, fullName,
                            address, phoneNumber, gender, 0);
                    Log.d("Find Student", fullName + " " + address + " " + phoneNumber + " " + gender);
                } while (cursor.moveToNext());
            }

        } else {
            Log.d("Shift Staff X", "success");
            flag = 2;
            String whereClause = "ID_STAFF = ?";
            String[] whereArgs = new String[] {idUser};
            Cursor cursor = StaffDAO.getInstance(this).SelectStaff(this, whereClause, whereArgs);
            /*ID_STAFF TEXT PRIMARY KEY, " +
            "FULLNAME TEXT, " +
                    "ADDRESS TEXT, " +
                    "PHONE_NUMBER TEXT, " +
                    "TYPE TEXT," +
                    "STATUS INTEGER*/
            if (cursor.moveToFirst()) {
                do {
                    String fullName = "";
                    String address = "";
                    String phoneNumber = "";
                    String gender = "";
                    String type = "";
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
                        type = cursor.getString(typeIndex);
                    }
                    staff = new StaffDTO(idUser, fullName, address, phoneNumber, gender, type, 0);
                    Log.d("Find Staff", staff.toString());
                } while (cursor.moveToNext());
            }
        }
    }
}