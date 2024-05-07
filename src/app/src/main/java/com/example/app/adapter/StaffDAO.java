package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.app.model.OfficialStudentDTO;
import com.example.app.model.StaffDTO;

public class StaffDAO {
    public static StaffDAO instance;
    private DataProvider dbHelper;
    private StaffDAO(Context context) {}
    public static synchronized StaffDAO getInstance(Context context) {
        if (instance == null) {
            instance = new StaffDAO(context);
        }
        return instance;
    }

    public void insertOfficialStudent(Context context, StaffDTO staff) {
        ContentValues values = new ContentValues();
        values.put("ID_STAFF", staff.getIdStaff());
        values.put("FULLNAME", staff.getFullName());
        values.put("ADDRESS",staff.getAddress());
        values.put("PHONE_NUMBER", staff.getPhoneNumber());
        values.put("TYPE", staff.getType());
        values.put("STATUS", staff.getStatus());

        try {
            int rowEffect = DataProvider.getInstance(context).insertData("STAFF", values);
            if (rowEffect > 0 ) {
                Log.d("Insert Staff: ", "success");
            } else {
                Log.d("Insert Staff: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert Staff Error: ", e.getMessage());
        }
    }

    public void deleteStaff(Context context, String whereClause, String[] whereArgs)  {
        try {
            int rowEffect = DataProvider.getInstance(context).deleteData("STAFF",whereClause, whereArgs);
            if (rowEffect > 0) {
                Log.d("Delete Staff: ", "success");
            } else {
                Log.d("Delete Staff: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert Staff Error: ", e.getMessage());
        }
    }

    public void updateStaff(Context context, StaffDTO staff, String whereClause, String[] whereArgs) {
        ContentValues values = new ContentValues();
        values.put("ID_STAFF", staff.getIdStaff());
        values.put("FULLNAME", staff.getFullName());
        values.put("ADDRESS",staff.getAddress());
        values.put("PHONE_NUMBER", staff.getPhoneNumber());
        values.put("TYPE", staff.getType());
        values.put("STATUS", staff.getStatus());

        try {
            int rowsUpdated = DataProvider.getInstance(context).updateData("STAFF", values, whereClause, whereArgs);
            if (rowsUpdated > 0) {
                Log.d("Update Staff: ", "Success");
            } else {
                Log.d("Update Staff: ", "No rows updated");
            }
        } catch (Exception e) {
            Log.e("Update Staff Error: ", e.getMessage());
        }
    }
}