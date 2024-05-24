package com.example.app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.app.R;
import com.example.app.adapter.AccountDAO;
import com.example.app.adapter.ClassDAO;
import com.example.app.adapter.ExamScoreDAO;
import com.example.app.adapter.NotificationDAO;
import com.example.app.adapter.ProgramDAO;
import com.example.app.adapter.ScheduleDAO;
import com.example.app.model.ClassDTO;
import com.example.app.model.List_Adapter;
import com.example.app.model.NotificationDTO;
import com.example.app.model.ExamScoreDTO;
import com.example.app.model.ProgramDTO;
import com.example.app.model.ScheduleDTO;

import java.util.ArrayList;
import java.util.List;

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
                String whereClause = "STATUS = ?";
                String[] whereArgs = new String[] {"0"};
                List<NotificationDTO> listNotification = NotificationDAO.getInstance(Activity_Notifications.this).SelectNotification(
                        Activity_Notifications.this, whereClause, whereArgs
                );

                for (int i = 0; i < listNotification.size(); i++) {
                    dataArrayList.add(listNotification.get(i));
                }

                listAdapter = new List_Adapter(Activity_Notifications.this, R.layout.list_notification_item, dataArrayList);
                break;
///private String idExamScore, idExam, idStudent, speaking, writing, listening, reading;
            case "Tra cứu điểm":
               //dataArrayList.add(new ExamScoreDTO("IS201", "5","9","8","9", "5", "6"));
                //dataArrayList.add(new ExamScoreDTO("NT106", "9","8","6","10", "5", "6"));

                int type = AccountDAO.getInstance(Activity_Notifications.this).GetObjectLogin(Activity_Notifications.this,
                        Activity_Login.username, Activity_Login.password);
                List<ExamScoreDTO> listExamScore = ExamScoreDAO.getInstance(Activity_Notifications.this).SelectExamScoreById(
                        Activity_Notifications.this, Activity_Login.idUser, type );

                for (int i = 0; i < listExamScore.size(); i++) {
                    dataArrayList.add(listExamScore.get(i));
                }

                listAdapter = new List_Adapter(Activity_Notifications.this, R.layout.list_score_item, dataArrayList);
                break;

            case "Tra cứu chương trình đào tạo":
                String whereClauseProgram = "STATUS = ?";
                String[] whereArgsProgram = new String[] {"0"};

                List<ProgramDTO> listProgram = ProgramDAO.getInstance(Activity_Notifications.this).SelectProgram(
                        Activity_Notifications.this, whereClauseProgram, whereArgsProgram);

                for (int i = 0; i < listProgram.size(); i++) {
                    dataArrayList.add(listProgram.get(i));
                }
/*
                dataArrayList.add(new ProgramDTO("PRO1",
                        "Hê hê",
                        "10", "10", "Đào tạo tiếng Anh", "10",
                        "10",
                        "10", "10"));*/
                listAdapter = new List_Adapter(Activity_Notifications.this, R.layout.list_education_program_item, dataArrayList);
                break;

            case "Lịch học":

                String whereClauseSchedule = "STATUS = ?" ;
                String[] whereArgsSchedule = new String[] {"0"};
                List<ScheduleDTO> listSchedule = ScheduleDAO.getInstance(
                        Activity_Notifications.this).SelectSchedule(Activity_Notifications.this,
                        whereClauseSchedule, whereArgsSchedule);
                for (int i = 0; i < listSchedule.size(); i++) {
                    dataArrayList.add(listSchedule.get(i));
                }

                dataArrayList.add(new ScheduleDTO("1", "1", "1", "1", "1", "1"));
                listAdapter = new List_Adapter(Activity_Notifications.this, R.layout.list_schedule_item, dataArrayList);
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