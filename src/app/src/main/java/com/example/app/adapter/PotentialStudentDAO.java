package com.example.app.adapter;

import android.content.Context;

public class PotentialStudentDAO {
    public static PotentialStudentDAO instance;
    private PotentialStudentDAO(Context context) {}
    public static synchronized PotentialStudentDAO getInstance(Context context) {
        if (instance == null) {
            instance = new PotentialStudentDAO(context);
        }
        return instance;
    }
}
