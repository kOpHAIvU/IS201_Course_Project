package com.example.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.app.R;
import com.example.app.model.List_Adapter;
import com.example.app.model.ClassroomDTO;
import com.example.app.model.CertificateDTO;
import com.example.app.model.List_Notifications;
import com.example.app.model.ExamScoreDTO;
import com.example.app.model.PotentialStudentDTO;

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
                dataArrayList.add(new List_Notifications("Test", "Vũ","Test thông báo đầu tiên"));
                dataArrayList.add(new List_Notifications("Test", "Thiện","Test thông báo thứ 2"));
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
            //Nhân viên ghi danh
            case "Quản lý thông tin học viên":
                dataArrayList.add(new PotentialStudentDTO("Tuyết Loan", "0912345678"
                        , "Nam", "Ký túc xá khu A"
                        , "Chưa học", "10"));
                listAdapter = new List_Adapter(Activity_Notifications.this, R.layout.list_talented_student_item, dataArrayList);
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