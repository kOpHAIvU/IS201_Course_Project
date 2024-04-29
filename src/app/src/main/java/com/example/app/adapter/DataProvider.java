package com.example.app.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class DataProvider extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "EnglishCenterManagement.db";
    private static final int DATABASE_VERSION = 1;

    public DataProvider(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create tables here
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS ACCOUNT (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "username TEXT NOT NULL, " +
                    "password TEXT NOT NULL)");
            Log.d("Database Creation", "Database created successfully");
        } catch ( Exception e) {
            Log.d("Database Creation",  e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xử lý việc nâng cấp cơ sở dữ liệu12
    }

    public String isDatabaseExists(Context context) {
        File dbFile = context.getDatabasePath(DATABASE_NAME);
        return dbFile.toString();
    }

}
