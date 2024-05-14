package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.app.model.NotificationDTO;
import com.example.app.model.OfficialStudentDTO;

public class NotificationDAO {
    public static NotificationDAO instance;
    private NotificationDAO(Context context) {}
    public static synchronized NotificationDAO getInstance(Context context) {
        if (instance == null) {
            instance = new NotificationDAO(context);
        }
        return instance;
    }
    public int InsertNotification(Context context, NotificationDTO notification) {
        int rowEffect = -1;

        ContentValues values = new ContentValues();

        values.put("ID_NOTIFICATION", notification.getIdNotification());
        values.put("TITLE", notification.getTitle());
        values.put("ID_ACCOUNT", notification.getPoster());
        values.put("CONTENT", notification.getDescription());

        try {
            rowEffect = DataProvider.getInstance(context).insertData("NOTIFICATION", values);
            if (rowEffect > 0 ) {
                Log.d("Insert Notification: ", "success");
            } else {
                Log.d("Insert Notification: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert Notification Error: ", e.getMessage());
        }

        return rowEffect;
    }

    public int DeleteNotification(Context context, String whereClause, String[] whereArgs) {
        int rowEffect = -1;

        try {
            rowEffect = DataProvider.getInstance(context).deleteData("NOTIFICATION",whereClause, whereArgs);
            if (rowEffect > 0) {
                Log.d("Delete Notification: ", "success");
            } else {
                Log.d("Delete Notification: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert Notification: ", e.getMessage());
        }

        return rowEffect;
    }

    public int UpdateNotification(Context context, NotificationDTO notification, String whereClause, String[] whereArgs)  {
        int rowEffect = -1;

        ContentValues values = new ContentValues();
        values.put("ID_NOTIFICATION", notification.getIdNotification());
        values.put("ID_ACCOUNT", notification.getPoster());
        values.put("TITLE", notification.getTitle());
        values.put("CONTENT", notification.getDescription());

        try {
            int rowsUpdated = DataProvider.getInstance(context).updateData("NOTIFICATION", values, whereClause, whereArgs);
            return rowsUpdated;
        } catch (Exception e) {
            Log.e("Update Notification: ", e.getMessage());
        }

        return rowEffect;
    }
    public Cursor SelectNotification (Context context, String whereClause, String[] whereArgs) {
        Cursor cursor = null;
        try {
            cursor = DataProvider.getInstance(context).selectData("NOTIFICATION", new String[]{"*"},  whereClause, whereArgs, null);
        }catch(Exception e) {
            Log.d("Select Notification: ", e.getMessage());
        }
        return cursor;
    }
}
