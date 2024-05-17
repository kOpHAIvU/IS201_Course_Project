package com.example.app.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.app.R;
import com.example.app.model.List_Adapter;
import com.example.app.model.OfficialStudentDTO;

import java.util.ArrayList;

public class Activity_Notifications_ToolBars_Second_Layer extends AppCompatActivity {
    private String message;
    //Toolbar toolbar;
    private List_Adapter listAdapter;
    private ListView listView;
    private ArrayList<Object> dataArrayList;
    private ImageButton returnBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_tool_bars_second_layer);

        //toolbar = findViewById(R.id.toolbar);
        listView = findViewById(R.id.notification_listview);
        returnBtn = findViewById(R.id.return_btn);
        message = getIntent().getStringExtra("classID");
        dataArrayList = new ArrayList<>();

        /*returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        if (!message.equals("")) {
            //toolbar.setTitle("Chi tiết lớp học");
            dataArrayList.add(new OfficialStudentDTO("1", "1","1", "1", "1", "1", 1));
            listAdapter = new List_Adapter(Activity_Notifications_ToolBars_Second_Layer.this, R.layout.list_offfical_student_item, dataArrayList);
        }

        listView.setAdapter(listAdapter);
        //setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (!message.equals("")) {
            Intent addOffical = new Intent(Activity_Notifications_ToolBars_Second_Layer.this, Activity_Add_Official_Student.class);
            addOffical.putExtra("classID", "");
            startActivity(addOffical);
        }
        return super.onOptionsItemSelected(item);
    }
}