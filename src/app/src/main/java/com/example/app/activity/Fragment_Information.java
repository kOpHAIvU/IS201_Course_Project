package com.example.app.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.app.R;
import com.example.app.adapter.List_Adapter;
import com.example.app.adapter.List_Information;

import java.util.ArrayList;

public class Fragment_Information extends Fragment implements AdapterView.OnItemClickListener {
    private List_Adapter listAdapter;
    private ListView listView;
    private ArrayList<Object> dataArrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        listView = view.findViewById(R.id.information_listview);
        dataArrayList = new ArrayList<>();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        //Học viên
        dataArrayList.add(new List_Information("Thông báo hệ thống", R.drawable.tb_he_thong));
        dataArrayList.add(new List_Information("Tra cứu điểm", R.drawable.score_icon));
        dataArrayList.add(new List_Information("Tra cứu chương trình đào tạo", R.drawable.chuong_trinh_dt));
        dataArrayList.add(new List_Information("Tra cứu lớp học", R.drawable.lophoc));

        //Nhân viên ghi danh
        dataArrayList.add(new List_Information("Quản lý thông tin học viên", R.drawable.quanlylophoc));

        //Nhân viên học vụ
        dataArrayList.add(new List_Information("Quản lý lớp học", R.drawable.lophoc));
        dataArrayList.add(new List_Information("Quản lý chương trình học", R.drawable.chuong_trinh_dt));

        //Quản lý
        dataArrayList.add(new List_Information("Quản lý tài khoản", R.drawable.quanlytaikhoan));
        dataArrayList.add(new List_Information("Quản lý thông tin phòng học", R.drawable.classroom));
        dataArrayList.add(new List_Information("Quản lý thông tin nhân viên/giáo viên", R.drawable.quanlynhansu));

        listAdapter = new List_Adapter(getActivity(), R.layout.list_item, dataArrayList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        List_Information selectedData = (List_Information) listAdapter.getItem(position);
        String selectedText = selectedData.getName();
        Intent intent = new Intent(getContext(), Activity_Notifications.class);
        intent.putExtra("message", selectedText);
        startActivity(intent);
    }
}