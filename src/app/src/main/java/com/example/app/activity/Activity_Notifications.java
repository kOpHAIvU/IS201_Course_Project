package com.example.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.app.R;
import com.example.app.adapter.AccountDAO;
import com.example.app.adapter.NotificationDAO;
import com.example.app.adapter.StaffDAO;
import com.example.app.model.List_Adapter;
import com.example.app.model.ClassroomDTO;
import com.example.app.model.CertificateDTO;
import com.example.app.model.NotificationDTO;
import com.example.app.model.ExamScoreDTO;

import java.util.ArrayList;

public class Activity_Notifications extends AppCompatActivity {
    private List_Adapter listAdapter;
    private ListView listView;
    private ArrayList<Object> dataArrayList;
    private ImageButton returnBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        String message = getIntent().getStringExtra("message");

        listView = findViewById(R.id.notification_listview);
        returnBtn = findViewById(R.id.return_to_frag_btn);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        dataArrayList = new ArrayList<>();

        switch (message) {
            //Học viên
            case "Thông báo hệ thống":

                Cursor cursor = NotificationDAO.instance.SelectNotification(Activity_Notifications.this, null, null);

                String fullName = "";
                String title = "";
                String content = "";
                String idNotification = "";


                if (cursor.moveToFirst()) {
                    do {
                        int idNotificationIndex = cursor.getColumnIndex("ID_NOTIFICATION");
                        if (idNotificationIndex!= -1) {
                            idNotification = cursor.getString(idNotificationIndex);
                        }

                        String idAccount = "";
                        int idAccountIndex = cursor.getColumnIndex("ID_ACCOUNT");
                        if (idAccountIndex!= -1) {
                            idAccount = cursor.getString(idAccountIndex);
                        }
                        String idUser = "";
                        String whereClauseFindUser = "ID_ACCOUNT = ?";
                        String[] whereArgsFindUser = new String[] {idAccount};
                        Cursor fullRow = AccountDAO.getInstance(Activity_Notifications.this).selectAccount(Activity_Notifications.this, whereClauseFindUser, whereArgsFindUser);

                        Log.d("ID_ACCOUNT: ", idAccount);

                        if (fullRow!= null && fullRow.moveToFirst()) {
                            do {
                                int idUserIndex = fullRow.getColumnIndex("ID_USER");
                                if (idUserIndex!= -1) {
                                    idUser = fullRow.getString(idUserIndex);
                                    Log.d("idUser: ", idUser);
                                }
                            } while (fullRow.moveToNext());
                        } else {
                            // Handle case where no user is found
                            Log.w("NotificationProcessor", "No user found for account ID: " + idAccount);
                        }
                        String whereClauseFindFullName = "ID_STAFF = ?";
                        String[] whereArgsFindFullName = new String[] {idUser};
                        Cursor fullRowFullName = StaffDAO.getInstance(Activity_Notifications.this).SelectStaff(Activity_Notifications.this, whereClauseFindFullName, whereArgsFindFullName);

                        if (fullRowFullName.moveToFirst()) {
                            do {
                                int fullNameIndex = fullRowFullName.getColumnIndex("FULLNAME");
                                if (fullNameIndex!= -1) {
                                    fullName = fullRowFullName.getString(fullNameIndex);
                                }
                            } while (fullRowFullName.moveToNext());
                        }

                        int titleIndex = cursor.getColumnIndex("TITLE");
                        if (titleIndex!= -1) {
                            title = cursor.getString(titleIndex);
                        }

                        int contentIndex = cursor.getColumnIndex("CONTENT");
                        if (contentIndex!= -1) {
                            content = cursor.getString(contentIndex);
                        }

                        dataArrayList.add(new NotificationDTO(idNotification, fullName, title, content));

                    } while (cursor.moveToNext());
                }

                listAdapter = new List_Adapter(Activity_Notifications.this, R.layout.list_notification_item, dataArrayList);
                break;
            case "Tra cứu điểm":
                dataArrayList.add(new ExamScoreDTO("IS201", "10","9","8","9"));
                dataArrayList.add(new ExamScoreDTO("NT106", "9","8","10","10"));
                listAdapter = new List_Adapter(Activity_Notifications.this, R.layout.list_score_item, dataArrayList);
                break;
            case "Tra cứu chương trình đào tạo":
                dataArrayList.add(new CertificateDTO("IS201",
                        "Hê hê",
                        "10", "10", "10", "10",
                        "Còn chỗ",
                        "Tôi ghét môn này"));
                listAdapter = new List_Adapter(Activity_Notifications.this, R.layout.list_education_program_item, dataArrayList);
                break;
            case "Tra cứu lớp học":
                dataArrayList.add(new ClassroomDTO("IS201","Môn gì đó",
                        "Đại học", "Tuyết Loan",
                        "10 buổi", "10.000.000",
                        "B4.04","Đoán coi","Nhật Quỳnh"));
                listAdapter = new List_Adapter(Activity_Notifications.this, R.layout.list_class_item, dataArrayList);
                break;
            //Nhân viên học vụ
            case "Quản lý lớp học":
                break;
            case "Quản lý chương trình học":
                break;
            //Quản lys
            case "Quản lý tài khoản":
                break;
            case "Quản lý thông tin phòng học":
                break;
            case "Quản lý thông tin nhân viên/giáo viên":
                break;

        }
        listView.setAdapter(listAdapter);
    }
}