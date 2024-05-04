package com.example.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app.R;

import java.util.ArrayList;

public class List_Adapter extends ArrayAdapter {
    private Context mContext;
    private ArrayList<List_Data> arrayDataList;
    public List_Adapter(@NonNull Context context,int idLayout, ArrayList<List_Data> arrayDataList) {
        super(context, idLayout, arrayDataList);
        mContext = context;
        this.arrayDataList = arrayDataList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView listImage = convertView.findViewById(R.id.listImage);
        TextView listName = convertView.findViewById(R.id.listName);

        List_Data listData = arrayDataList.get(position);

        listImage.setImageResource(listData.getImg());
        listName.setText(listData.getName());

        return convertView;
    }
}
