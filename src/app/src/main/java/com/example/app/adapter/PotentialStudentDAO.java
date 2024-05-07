package com.example.app.adapter;

import android.content.Context;

import com.example.app.model.PotentialStudentDTO;

public class PotentialStudentDAO {
    public static PotentialStudentDAO instance;
    private DataProvider dbHelper;
    private PotentialStudentDAO(Context context) {}
    public static synchronized PotentialStudentDAO getInstance(Context context) {
        if (instance == null) {
            instance = new PotentialStudentDAO(context);
        }
        return instance;
    }
}
