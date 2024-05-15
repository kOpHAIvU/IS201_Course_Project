package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.app.model.StaffDTO;
import com.example.app.model.TeacherDTO;

public class TeacherDAO {
    public static TeacherDAO instance;
    private TeacherDAO(Context context) {}
    public static synchronized TeacherDAO getInstance(Context context) {
        if (instance == null) {
            instance = new TeacherDAO(context);
        }
        return instance;
    }

    public void insertTeacher(Context context, TeacherDTO teacher) {
        ContentValues values = new ContentValues();

        int maxId = DataProvider.getInstance(context).getMaxId("TEACHER", "ID_TEACHER");

        values.put("ID_TEACHER", "TEA" + String.valueOf(maxId + 1));
        values.put("FULLNAME", teacher.getFullName());
        values.put("ADDRESS",teacher.getAddress());
        values.put("PHONE_NUMBER", teacher.getPhoneNumber());
        values.put("GENDER", teacher.getGender());
        values.put("SALARY", teacher.getSalary());
        values.put("STATUS", teacher.getStatus());

        try {
            int rowEffect = DataProvider.getInstance(context).insertData("TEACHERS", values);
            if (rowEffect > 0 ) {
                Log.d("Insert Teacher: ", "success");
            } else {
                Log.d("Insert Teacher: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert Teacher Error: ", e.getMessage());
        }
    }

    public void deleteTeacher(Context context, String whereClause, String[] whereArgs)  {
        try {
            int rowEffect = DataProvider.getInstance(context).deleteData("TEACHERS",whereClause, whereArgs);
            if (rowEffect > 0) {
                Log.d("Delete Teacher: ", "success");
            } else {
                Log.d("Delete Teacher: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert Teacher Error: ", e.getMessage());
        }
    }

    public void updateTeacher(Context context, TeacherDTO teacher, String whereClause, String[] whereArgs) {
        ContentValues values = new ContentValues();
        values.put("ID_TEACHER", teacher.getIdTeacher());
        values.put("FULLNAME", teacher.getFullName());
        values.put("ADDRESS",teacher.getAddress());
        values.put("PHONE_NUMBER", teacher.getPhoneNumber());
        values.put("GENDER", teacher.getGender());
        values.put("SALARY", teacher.getSalary());
        values.put("STATUS", teacher.getStatus());

        try {
            int rowsUpdated = DataProvider.getInstance(context).updateData("TEACHERS", values, whereClause, whereArgs);
            if (rowsUpdated > 0) {
                Log.d("Update Teacher: ", "Success");
            } else {
                Log.d("Update Teacher: ", "No rows updated");
            }
        } catch (Exception e) {
            Log.e("Update Teacher Error: ", e.getMessage());
        }
    }
}
