package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.app.model.ClassDTO;

public class ClassDAO {
    //private String classID, className, level, lectureName, schoolTime, tuition, roomID, programID, staffID;
    public static ClassDAO instance;
    private ClassDAO(Context context) {}
    public static synchronized ClassDAO getInstance(Context context) {
        if (instance == null) {
            instance = new ClassDAO(context);
        }
        return instance;
    }
    public int InsertClass(Context context, ClassDTO classDTO) {
        int rowEffect = -1;
        int maxId = DataProvider.getInstance(context).getMaxId("CLASS", "ID_CLASS");

        ContentValues values = new ContentValues();

        values.put("ID_CLASS", "CLS" + String.valueOf(maxId + 1));
        values.put("NAME", classDTO.getClassName());
        values.put("LEVEL", classDTO.getLevel());
        values.put("STUDY_TIME", classDTO.getSchoolTime());
        values.put("TUITION_FEES", classDTO.getTuition());
        values.put("ID_CLASSROOM", classDTO.getRoomID());
        values.put("ID_PROGRAM", classDTO.getProgramID());
        values.put("ID_TEACHER", classDTO.getLectureName());
        values.put("ID_STAFF", classDTO.getStaffID());

        try {
            rowEffect = DataProvider.getInstance(context).insertData("CLASS", values);
            if (rowEffect > 0 ) {
                Log.d("Insert Class: ", "success");
            } else {
                Log.d("Insert Class: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert Class Error: ", e.getMessage());
        }

        return rowEffect;
    }

    public int UpdateClass(Context context, ClassDTO classDTO, String whereClause, String[] whereArgs) {
        int rowEffect = -1;

        ContentValues values = new ContentValues();

        values.put("ID_CLASS", classDTO.getClassID());
        values.put("NAME", classDTO.getClassName());
        values.put("LEVEL", classDTO.getLevel());
        values.put("STUDY_TIME", classDTO.getSchoolTime());
        values.put("TUITION_FEES", classDTO.getTuition());
        values.put("ID_CLASSROOM", classDTO.getRoomID());
        values.put("ID_PROGRAM", classDTO.getProgramID());
        values.put("ID_TEACHER", classDTO.getLectureName());
        values.put("ID_STAFF", classDTO.getStaffID());

        try {
            rowEffect = DataProvider.getInstance(context).updateData("CLASS", values, whereClause, whereArgs);
            if (rowEffect > 0 ) {
                Log.d("Update Class: ", "success");
            } else {
                Log.d("Update Class: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Update Class Error: ", e.getMessage());
        }

        return rowEffect;
    }
}
