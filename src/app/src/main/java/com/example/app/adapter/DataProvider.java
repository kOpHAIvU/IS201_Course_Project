package com.example.app.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;

public class DataProvider extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ENGLISH_CENTER_MANAGEMENT";
    private static final int DATABASE_VERSION = 1;

    public DataProvider(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create tables here
        db.execSQL("CREATE TABLE IF NOT EXISTS ACCOUNT (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "username TEXT NOT NULL, " +
                "password TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xử lý việc nâng cấp cơ sở dữ liệu
    }

    public boolean isDatabaseExists(Context context) {
        File dbFile = context.getDatabasePath("ENGLISH_CENTER_MANAGEMENT");
        return dbFile.exists();
    }
}
