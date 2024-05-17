package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.app.model.ProgramDTO;
import com.example.app.model.ScheduleDTO;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {
    public static ScheduleDAO instance;
    private ScheduleDAO(Context context) {}
    public static synchronized ScheduleDAO getInstance(Context context) {
        if (instance == null) {
            instance = new ScheduleDAO(context);
        }
        return instance;
    }

    public int InsertSchedule(Context context, ScheduleDTO schedule) {
        int rowEffect = -1;
        ContentValues values = new ContentValues();
        int maxId = DataProvider.getInstance(context).getMaxId("SCHEDULE", "ID_SCHEDULE");

        values.put("ID_SCHEDULE", "SCH" + String.valueOf(maxId + 1));
        values.put("DAY_OF_WEEK", schedule.getDay());
        values.put("START_TIME",schedule.getStart());
        values.put("END_TIME", schedule.getEnd());
        values.put("ID_CLASS", schedule.getIdClass());
        values.put("ID_CLASSROOM", schedule.getIdClassroom());

        try {
            rowEffect = DataProvider.getInstance(context).insertData("SCHEDULE", values);
            Log.d("Schedule information: ", schedule.toString());
            if (rowEffect > 0 ) {
                Log.d("Insert Schedule: ", "success");
            } else {
                Log.d("Insert Schedule: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert Schedule Error: ", e.getMessage());
        }

        return rowEffect;
    }

    public int UpdateSchedule(Context context, ScheduleDTO schedule, String whereClause, String[] whereArg) {
        int rowEffect = -1;

        ContentValues values = new ContentValues();
        int maxId = DataProvider.getInstance(context).getMaxId("SCHEDULE", "ID_SCHEDULE");

        values.put("ID_SCHEDULE", "SCH" + String.valueOf(maxId + 1));
        values.put("DAY_OF_WEEK", schedule.getDay());
        values.put("START_TIME",schedule.getStart());
        values.put("END_TIME", schedule.getEnd());
        values.put("ID_CLASS", schedule.getIdClass());
        values.put("ID_CLASSROOM", schedule.getIdClassroom());

        try {
            rowEffect = DataProvider.getInstance(context).updateData("SCHEDULE", values, whereClause, whereArg);
            Log.d("Schedule information: ", schedule.toString());
            if (rowEffect > 0 ) {
                Log.d("Update Schedule: ", "success");
            } else {
                Log.d("Update Schedule: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Update Schedule Error: ", e.getMessage());
        }

        return rowEffect;
    }

    public List<ScheduleDTO> SelectSchedule(Context context, String whereClause, String[] whereArgs) {
        List<ScheduleDTO> listSchedule = new ArrayList<>();
        Cursor cursor = null;

        try {
            cursor = DataProvider.getInstance(context).selectData("SCHEDULE", new String[]{"*"},  whereClause, whereArgs, null);
        }catch(Exception e) {
            Log.d("Select Program: ", e.getMessage());
        }
//    private String idSchedule, day, start, end, idClass, idClassroom;
       String idSchedule = "", day = "", start = "", end = "", idClass = "", idClassroom = "";

        if (cursor.moveToFirst()) {
            do {
                int idScheduleIndex = cursor.getColumnIndex("ID_SCHEDULE");
                if (idScheduleIndex!= -1) {
                    idSchedule = cursor.getString(idScheduleIndex);
                }
                int dayIndex = cursor.getColumnIndex("DAY_OF_WEEK");
                if (dayIndex != -1) {
                    day = cursor.getString(dayIndex);
                }
                int startIndex = cursor.getColumnIndex("START_TIME");
                if (startIndex != -1) {
                    start = cursor.getString(startIndex);
                }
                int endIndex = cursor.getColumnIndex("END_TIME");
                if (endIndex!= -1) {
                    end = cursor.getString(endIndex);
                }
                int classIndex = cursor.getColumnIndex("ID_CLASS");
                if (classIndex != -1) {
                    idClass = cursor.getString(classIndex);
                }
                int classroomIndex = cursor.getColumnIndex("ID_CLASSROOM");
                if (classroomIndex != -1) {
                    idClassroom = cursor.getString(classroomIndex);
                }
                listSchedule.add(new ScheduleDTO(idSchedule, day, start, end, idClass, idClassroom));
            } while (cursor.moveToNext());
        }

        return listSchedule;
    }

}
