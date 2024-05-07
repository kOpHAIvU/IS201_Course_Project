package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.app.model.AccountDTO;
import com.example.app.model.OfficialStudentDTO;

public class OfficialStudentDAO {
    public static OfficialStudentDAO instance;
    private DataProvider dbHelper;
    private OfficialStudentDAO(Context context) {}
    public static synchronized OfficialStudentDAO getInstance(Context context) {
        if (instance == null) {
            instance = new OfficialStudentDAO(context);
        }
        return instance;
    }

    public void insertOfficialStudent(Context context, OfficialStudentDTO student) {
        String idStudent = student.getIdStudent();
        String fullName = student.getFullName();
        String address = student.getFullName();
        String phoneNumber = student.getPhoneNumber();
        String gender = student.getPhoneNumber();
        int status = student.getStatus();

        ContentValues values = new ContentValues();
        values.put("ID_STUDENT", idStudent);
        values.put("FULLNAME", fullName);
        values.put("ADDRESS", address);
        values.put("PHONE_NUMBER", phoneNumber);
        values.put("GENDER", gender);
        values.put("STATUS", status);

        try {
            int rowEffect = DataProvider.getInstance(context).insertData("OFFICIAL_STUDENT", values);
            if (rowEffect > 0 ) {
                Log.d("Insert Official Student: ", "success");
            } else {
                Log.d("Insert Official Student: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert Official Student Error: ", e.getMessage());
        }
    }

    public void deleteOfficialStudent(Context context, String whereClause, String[] whereArgs)  {
        try {
            int rowEffect = DataProvider.getInstance(context).deleteData("OFFICIAL_STUDENT",whereClause, whereArgs);
            if (rowEffect > 0) {
                Log.d("Delete Official Student: ", "success");
            } else {
                Log.d("Delete Official Student: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert Official Student Error: ", e.getMessage());
        }
    }

    public void updateOfficialStudent(Context context, OfficialStudentDTO student, String whereClause, String[] whereArgs) {
        String idStudent = student.getIdStudent();
        String fullName = student.getFullName();
        String address = student.getFullName();
        String phoneNumber = student.getPhoneNumber();
        String gender = student.getPhoneNumber();
        int status = student.getStatus();

        ContentValues values = new ContentValues();
        values.put("ID_STUDENT", idStudent);
        values.put("FULLNAME", fullName);
        values.put("ADDRESS", address);
        values.put("PHONE_NUMBER", phoneNumber);
        values.put("GENDER", gender);
        values.put("STATUS", status);

        try {
            int rowsUpdated = DataProvider.getInstance(context).updateData("OFFICIAL_STUDENT", values, whereClause, whereArgs);
            if (rowsUpdated > 0) {
                Log.d("Update Official Student: ", "Success");
            } else {
                Log.d("Update Official Student: ", "No rows updated");
            }
        } catch (Exception e) {
            Log.e("Update Official Student Error: ", e.getMessage());
        }
    }
}
