package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;

import com.example.app.model.ClassDTO;

import java.util.ArrayList;
import java.util.List;

public class ClassDAO {

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
        values.put("START_DATE", classDTO.getStartDate());
        values.put("END_DATE", classDTO.getEndDate());
        values.put("ID_PROGRAM", classDTO.getIdProgram());
        values.put("ID_TEACHER", classDTO.getIdTeacher());
        values.put("ID_STAFF", classDTO.getIdStaff());
        values.put("STATUS", "0");

        try {
            rowEffect = DataProvider.getInstance(context).insertData("CLASS", values);
            if (rowEffect > 0 ) {
                Log.d("Insert Class: ", "success");
            } else {
                Log.d("Insert Class: ", "Fail");
            }
        } catch (SQLException e) {
            Log.d("Insert Class Error: ", e.getMessage());
        }

        return rowEffect;
    }

    public int UpdateClass(Context context, ClassDTO classDTO, String whereClause, String[] whereArgs) {
        int rowEffect = -1;

        ContentValues values = new ContentValues();

        values.put("ID_CLASS", classDTO.getClassID());
        values.put("NAME", classDTO.getClassName());
        values.put("START_DATE", classDTO.getStartDate());
        values.put("END_DATE", classDTO.getEndDate());
        values.put("ID_PROGRAM", classDTO.getIdProgram());
        values.put("ID_TEACHER", classDTO.getIdTeacher());
        values.put("ID_STAFF", classDTO.getIdStaff());
        values.put("STATUS", "0");

        try {
            rowEffect = DataProvider.getInstance(context).updateData("CLASS", values, whereClause, whereArgs);
            if (rowEffect > 0 ) {
                Log.d("Update Class: ", "success");
            } else {
                Log.d("Update Class: ", "Fail");
            }
        } catch (SQLException e) {
            Log.d("Update Class Error: ", e.getMessage());
        }

        return rowEffect;
    }

    public List<ClassDTO> selectClass (Context context, String whereClause, String[] whereArgs) {
        List<ClassDTO> listClass = new ArrayList<>();
        Cursor cursor = null;

        try {
            cursor = DataProvider.getInstance(context).selectData("CLASS", new String[]{"*"},  whereClause, whereArgs, null);
        }catch(SQLException e) {
            Log.d("Select Class: ", e.getMessage());
        }

        //private String classID, className, level, lecturerName, schoolTime, tuition, roomID, programID, staffID;
        String id = "", name = "", start = "", end = "", idProgram = "", idTeacher = "", idStaff = "";

        if (cursor.moveToFirst()) {
            do {
                
                int idIndex = cursor.getColumnIndex("ID_CLASS");
                if (idIndex != -1) {
                    id = cursor.getString(idIndex);
                }
                int nameIndex = cursor.getColumnIndex("NAME");
                if (nameIndex!= -1) {
                    name = cursor.getString(nameIndex);
                }
                int startIndex = cursor.getColumnIndex("START_DATE");
                if (startIndex!= -1) {
                    start = cursor.getString(startIndex);
                }
                int endIndex = cursor.getColumnIndex("END_DATE");
                if (endIndex != -1) {
                    end = cursor.getString(endIndex);
                }
                int programIndex = cursor.getColumnIndex("ID_PROGRAM");
                if (programIndex!= -1) {
                    idProgram = cursor.getString(programIndex);
                }
                int teacherIndex = cursor.getColumnIndex("ID_TEACHER");
                if (teacherIndex != -1) {
                    idTeacher = cursor.getString(teacherIndex);
                }
                int staffIndex = cursor.getColumnIndex("ID_STAFF");
                if (staffIndex != -1) {
                    idStaff = cursor.getString(staffIndex);
                }
                listClass.add(new ClassDTO(id, name, start, end, idProgram, idTeacher, idStaff, "0"));

            } while (cursor.moveToNext());
        }
        return listClass;
    }
}
