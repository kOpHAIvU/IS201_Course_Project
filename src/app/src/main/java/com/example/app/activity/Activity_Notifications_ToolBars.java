package com.example.app.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.health.connect.datatypes.units.Length;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.app.R;
import com.example.app.adapter.PotentialStudentDAO;
import com.example.app.model.List_Adapter;
import com.example.app.model.PotentialStudentDTO;

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
                toolbar.setTitle("Danh sách học viên tiềm năng");
                /*dataArrayList.add(new PotentialStudentDTO("Tuyết Loan", "0912345678"
                        , "Nam", "Ký túc xá khu A"
                        , "Chưa học", "Đại học","10"));
                dataArrayList.add(new PotentialStudentDTO("Hoàng Thiện", "0912345678"
                        , "Nữ", "Ký túc xá khu A"
                        , "Chưa học", "Mẫu giáo","10"));*/
                String[] whereArgs = new String[] {"0"};
                List<PotentialStudentDTO> listPotentialStudent = PotentialStudentDAO.getInstance(Activity_Notifications_ToolBars.this).SelectStudent(
                        Activity_Notifications_ToolBars.this, "STATUS = ?", whereArgs
                );
                for (int i = 0; i < listPotentialStudent.size(); i++) {
                    Log.d("List potential Student: " ,listPotentialStudent.get(i).toString());
                    dataArrayList.add(listPotentialStudent.get(i));
                }

                listAdapter = new List_Adapter(Activity_Notifications_ToolBars.this, R.layout.list_potential_student_item, dataArrayList);
                break;
        }
        listView.setAdapter(listAdapter);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onStart() {
        super.onStart();

        dataArrayList.clear();

        switch (message) {
            //Nhân viên ghi danh
            case "Quản lý thông tin học viên":
                toolbar.setTitle("Danh sách học viên tiềm năng");
                /*dataArrayList.add(new PotentialStudentDTO("Tuyết Loan", "0912345678"
                        , "Nam", "Ký túc xá khu A"
                        , "Chưa học", "Đại học","10"));
                dataArrayList.add(new PotentialStudentDTO("Hoàng Thiện", "0912345678"
                        , "Nữ", "Ký túc xá khu A"
                        , "Chưa học", "Mẫu giáo","10"));*/
                String[] whereArgs = new String[] {"0"};
                List<PotentialStudentDTO> listPotentialStudent = PotentialStudentDAO.getInstance(Activity_Notifications_ToolBars.this).SelectStudent(
                        Activity_Notifications_ToolBars.this, "STATUS = ?", whereArgs
                );
                for (int i = 0; i < listPotentialStudent.size(); i++) {
                    Log.d("List potential Student: " ,listPotentialStudent.get(i).toString());
                    dataArrayList.add(listPotentialStudent.get(i));
                }

                listAdapter = new List_Adapter(Activity_Notifications_ToolBars.this, R.layout.list_potential_student_item, dataArrayList);
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
                startActivity(addPotential);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}