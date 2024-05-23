package com.example.app.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.app.R;
import com.example.app.adapter.ClassDAO;
import com.example.app.adapter.PotentialStudentDAO;
import com.example.app.model.AccountDTO;
import com.example.app.model.CertificateDTO;
import com.example.app.model.ClassDTO;
import com.example.app.model.ClassDTO_Manage;
import com.example.app.model.List_Adapter;
import com.example.app.model.PotentialStudentDTO;
import com.example.app.model.ProgramDTO;
import com.example.app.model.ScheduleDTO;

import java.util.ArrayList;
import java.util.List;

public class Activity_Notifications_ToolBars extends AppCompatActivity {
    Toolbar toolbar;
    private List_Adapter listAdapter;
    private ListView listView;
    private ArrayList<Object> dataArrayList;
    private ImageButton returnBtn;
    private String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_tool_bars);
        toolbar = findViewById(R.id.toolbar);
        listView = findViewById(R.id.notification_listview);
        returnBtn = findViewById(R.id.return_to_frag_btn);
        message = getIntent().getStringExtra("message");
        dataArrayList = new ArrayList<>();

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        switch (message) {
            //Nhân viên ghi danh
            case "Quản lý thông tin học viên":
                toolbar.setTitle("Học viên tiềm năng");
                /*dataArrayList.add(new PotentialStudentDTO("Tuyết Loan", "0912345678"
                        , "Nam", "Ký túc xá khu A"
                        , "Chưa học", "Đại học","10"));*/
                dataArrayList.add(new PotentialStudentDTO("1","Hoàng Thiện", "0912345678"
                        , "Nữ", "Ký túc xá khu A"
                        , "Mẫu giáo","10"));
                /*String[] whereArgs = new String[] {"0"};
                List<PotentialStudentDTO> listPotentialStudent = PotentialStudentDAO.getInstance(Activity_Notifications_ToolBars.this).SelectStudent(
                        Activity_Notifications_ToolBars.this, "STATUS = ?", whereArgs
                );
                for (int i = 0; i < listPotentialStudent.size(); i++) {
                    Log.d("List potential Student: " ,listPotentialStudent.get(i).toString());
                    dataArrayList.add(listPotentialStudent.get(i));
                }*/
                String[] whereArgs = new String[] {"0"};
                String whereClause = "STATUS = ?";
                List<PotentialStudentDTO> listPotentialStudent = PotentialStudentDAO.getInstance(
                        Activity_Notifications_ToolBars.this).SelectStudent(Activity_Notifications_ToolBars.this, whereClause, whereArgs);

                for(int i = 0; i < listPotentialStudent.size(); i++) {
                    dataArrayList.add(listPotentialStudent.get(i));
                }

                listAdapter = new List_Adapter(Activity_Notifications_ToolBars.this, R.layout.list_potential_student_item, dataArrayList);
                break;
            case "Quản lý lớp học":
                toolbar.setTitle("Lớp học");
                dataArrayList.add(new ClassDTO_Manage("IS201","Môn gì đó",
                        "Đại học", "Tuyết Loan",
                        "10 buổi", "10.000.000",
                        "Hehe","Đoán coi"));
                dataArrayList.add(new ClassDTO_Manage("IS201","Môn gì đó",
                        "Đại học", "Tuyết Loan",
                        "10 buổi", "10.000.000",
                        "Hehe","Đoán coi"));
                listAdapter = new List_Adapter(Activity_Notifications_ToolBars.this, R.layout.list_class_to_manage_item, dataArrayList);
                break;
        }
        listView.setAdapter(listAdapter);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onStart() {
        super.onStart();
        dataArrayList.clear();

        String[] whereArgs = new String[] {"0"};
        String whereClause = "STATUS = ?";

        switch (message) {
            //Nhân viên ghi danh
            case "Quản lý thông tin học viên":
                toolbar.setTitle("Học viên tiềm năng");
                /*dataArrayList.add(new PotentialStudentDTO("Tuyết Loan", "0912345678"
                        , "Nam", "Ký túc xá khu A"
                        , "Chưa học", "Đại học","10"));*/
                /*dataArrayList.add(new PotentialStudentDTO("1","Hoàng Thiện", "0912345678"
                        , "Nữ", "Ký túc xá khu A"
                        , "Mẫu giáo","10"));*/
                /*List<PotentialStudentDTO> listPotentialStudent = PotentialStudentDAO.getInstance(Activity_Notifications_ToolBars.this).SelectStudent(
                        Activity_Notifications_ToolBars.this, "STATUS = ?", whereArgs
                );
                for (int i = 0; i < listPotentialStudent.size(); i++) {
                    Log.d("List potential Student: " ,listPotentialStudent.get(i).toString());
                    dataArrayList.add(listPotentialStudent.get(i));
                }*/
                List<PotentialStudentDTO> listPotentialStudent = PotentialStudentDAO.getInstance(
                        Activity_Notifications_ToolBars.this).SelectStudent(Activity_Notifications_ToolBars.this, whereClause, whereArgs);

                for(int i = 0; i < listPotentialStudent.size(); i++) {
                    dataArrayList.add(listPotentialStudent.get(i));
                }

                listAdapter = new List_Adapter(Activity_Notifications_ToolBars.this, R.layout.list_potential_student_item, dataArrayList);
                break;
            case "Quản lý lớp học":
                toolbar.setTitle("Lớp học");
                dataArrayList.add(new ClassDTO_Manage("IS201","Môn gì đó",
                        "Đại học", "Tuyết Loan",
                        "10 buổi", "10.000.000",
                        "Hehe","Đoán coi"));
                dataArrayList.add(new ClassDTO_Manage("IS201","Môn gì đó",
                        "Đại học", "Tuyết Loan",
                        "10 buổi", "10.000.000",
                        "Hehe","Đoán coi"));

                List<ClassDTO> listClass = ClassDAO.getInstance(
                        Activity_Notifications_ToolBars.this).selectClass(Activity_Notifications_ToolBars.this,
                        whereClause, whereArgs);
                for (int i = 0; i < listClass.size(); i++) {
                    dataArrayList.add(listClass.get(i));
                }

                listAdapter = new List_Adapter(Activity_Notifications_ToolBars.this, R.layout.list_class_to_manage_item, dataArrayList);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(Activity_Notifications_ToolBars.this, Activity_Notifications_ToolBars_Second_Layer.class);
                        intent.putExtra("classID","1");
                        startActivity(intent);
                    }
                });
                break;
            case "Quản lý lịch học":
                toolbar.setTitle("Lịch học");
                dataArrayList.add(new ScheduleDTO("1", "1", "1", "1", "1", "1"));
                listAdapter = new List_Adapter(Activity_Notifications_ToolBars.this, R.layout.list_schedule_manage_item, dataArrayList);
                break;
            case "Quản lý chứng chỉ":
                toolbar.setTitle("Chương trình");
                dataArrayList.add(new CertificateDTO("1", "1", "1"));
                listAdapter = new List_Adapter(Activity_Notifications_ToolBars.this, R.layout.list_certificate_item, dataArrayList);
                break;
            case "Quản lý tài khoản":
                toolbar.setTitle("Tài khoản");
                dataArrayList.add(new AccountDTO("1", "1", "1", "1"));
                listAdapter = new List_Adapter(Activity_Notifications_ToolBars.this, R.layout.list_account_item, dataArrayList);
                break;
        }
        listView.setAdapter(listAdapter);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (message) {
            case "Quản lý thông tin học viên":
                Intent addPotential = new Intent(Activity_Notifications_ToolBars.this, Activity_Add_Potential_Student.class);
                addPotential.putExtra("studentID", "");
                startActivity(addPotential);
                break;
            case "Quản lý lớp học":
                Intent addClass = new Intent(Activity_Notifications_ToolBars.this, Activity_Add_Class.class);
                addClass.putExtra("classID", "1");
                startActivity(addClass);
                break;
            case "Quản lý lịch học":
                Intent addSchedule = new Intent(Activity_Notifications_ToolBars.this, Activity_Add_Schedule.class);
                addSchedule.putExtra("idSchedule", "");
                startActivity(addSchedule);
                break;
            case "Quản lý chứng chỉ":
                Intent addCertificate = new Intent(Activity_Notifications_ToolBars.this, Activity_Add_Certificate.class);
                addCertificate.putExtra("idCertificate", "1");
                startActivity(addCertificate);
                break;
            case "Quản lý tài khoản":
                Intent addAccount = new Intent();
                addAccount.putExtra("idAccount", "");
                startActivity(addAccount);
        }
        return super.onOptionsItemSelected(item);
    }
}