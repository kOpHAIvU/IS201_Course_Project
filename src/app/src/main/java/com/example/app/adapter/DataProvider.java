package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class DataProvider extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ENGLISH_CENTER_MANAGEMENT.db";
    private static DataProvider instance;
    private static final int DATABASE_VERSION = 8;
    private DataProvider(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static synchronized DataProvider getInstance(Context context) {
        if (instance == null) {
            instance = new DataProvider(context);
        }
        return instance;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS CERTIFICATE (" +
                    "ID_CERTIFICATE TEXT PRIMARY KEY, " +
                    "NAME TEXT, " +
                    "CONTENT TEXT, " +
                    "MINIMUM_SCORE REAL, " +
                    "STATUS INTEGER)");
            Log.d("CREATE CERTIFICATE", "Database created successfully");
        } catch ( Exception e) {
            Log.d("EXCEPTION CREATE CERTIFICATE",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS STAFF (" +
                    "ID_STAFF TEXT PRIMARY KEY, " +
                    "FULLNAME TEXT, " +
                    "ADDRESS TEXT, " +
                    "PHONE_NUMBER TEXT, " +
                    "TYPE TEXT," +
                    "STATUS INTEGER)");
            Log.d("CREATE STAFF", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE STAFF",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS TEACHERS (" +
                    "ID_TEACHER TEXT PRIMARY KEY , " +
                    "FULLNAME TEXT, " +
                    "ADDRESS TEXT, " +
                    "PHONE_NUMBER TEXT, " +
                    "GENDER TEXT, " +
                    "SALARY INTEGER, " +
                    "STATUS INTEGER)");
            Log.d("CREATE TEACHERS", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE TEACHERS",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS CLASSROOM (" +
                    "ID_CLASSROOM TEXT PRIMARY KEY, " +
                    "NAME TEXT, " +
                    "STATUS INTEGER)");
            Log.d("CREATE EXAMINATION", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE EXAMINATION",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS POTENTIAL_STUDENT (" +
                    "ID_STUDENT INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "FULLNAME TEXT, " +
                    "ADDRESS TEXT, " +
                    "PHONE_NUMBER TEXT, " +
                    "GENDER TEXT," +
                    "LEVEL TEXT, " +
                    "NUMBER_OF_APPOINTMENTS INTEGER, " +
                    "STATUS INTEGER)");
            Log.d("CREATE POTENTIAL_STUDENTS", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE POTENTIAL_STUDENTS",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS OFFICIAL_STUDENT (" +
                    "ID_STUDENT TEXT PRIMARY KEY , " +
                    "FULLNAME TEXT, " +
                    "ADDRESS TEXT, " +
                    "PHONE_NUMBER TEXT, " +
                    "GENDER TEXT," +
                    "STATUS INTEGER)");
            Log.d("CREATE OFFICIAL_STUDENTS", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE OFFICIAL_STUDENTS",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS COLLECTING_TUITION_FEES (" +
                    "ID_BILL TEXT PRIMARY KEY , " +
                    "ID_STUDENT TEXT, " +
                    "COLLECTION_DATE TEXT, " +
                    "TOTAL_MONEY INTEGER, " +
                    "STATUS INTEGER," +
                    "FOREIGN KEY (ID_STUDENT) REFERENCES OFFICAL_STUDENT(ID_STUDENT))");
            Log.d("CREATE COLLECTING_TUITION_FEES", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE COLLECTING_TUITION_FEES",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS CLASS (" +
                    "ID_CLASS TEXT PRIMARY KEY , " +
                    "NAME TEXT, " +
                    "LEVEL TEXT, " +
                    "STUDY_TIME TEXT, " +
                    "TUITION_FEES INTEGER, " +
                    "ID_CLASSROOM TEXT, " +
                    "ID_PROGRAM TEXT, " +
                    "ID_STAFF TEXT, " +
                    "STATUS INTEGER," +
                    "FOREIGN KEY (ID_CLASSROOM) REFERENCES CLASSROOM(ID_CLASSROOM)," +
                    "FOREIGN KEY (ID_PROGRAM) REFERENCES PROGRAM(ID_PROGRAM)," +
                    "FOREIGN KEY (ID_STAFF) REFERENCES STAFF(ID_STAFF))");
            Log.d("CREATE CLASSROOM", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE CLASSROOM",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS EXAMINATION (" +
                    "ID_EXAM TEXT PRIMARY KEY, " +
                    "NAME TEXT, " +
                    "FORMAT TEXT, " +
                    "EXAM_DATE TEXT, " +
                    "ID_CLASSROOM TEXT, " +
                    "STATUS INTEGER," +
                    "FOREIGN KEY (ID_CLASSROOM) REFERENCES CLASSROOM(ID_CLASSROOM))");
            Log.d("CREATE EXAMINATION", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE EXAMINATION",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS EXAM_SCRORE (" +
                    "ID_EXAM_SCORE INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "ID_EXAM TEXT , " +
                    "ID_STUDENT TEXT, " +
                    "SPEAKING_SCORE REAL, " +
                    "WRITING_SCORE REAL, " +
                    "LISTENING_SCORE REAL, " +
                    "READING_SCORE REAL," +
                    "FOREIGN KEY (ID_EXAM) REFERENCES EXAMINATION(ID_EXAM)," +
                    "FOREIGN KEY (ID_STUDENT) REFERENCES OFFICAL_STUDENT(ID_STUDENT) )");
            Log.d("CREATE EXAM_SCORE", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE EXAM_SCORE",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS TEACHING (" +
                    "ID_TEACHING INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "ID_STUDENT TEXT , " +
                    "ID_CLASS TEXT, " +
                    "ID_TEACHER TEXT, " +
                    "START_DATE TEXT, " +
                    "END_DATE TEXT, " +
                    "FOREIGN KEY (ID_STUDENT) REFERENCES OFFICAL_STUDENT(ID_STUDENT)," +
                    "FOREIGN KEY (ID_CLASS) REFERENCES CLASS(ID_CLASS)," +
                    "FOREIGN KEY (ID_TEACHER) REFERENCES TEACHER(ID_TEACHER))");
            Log.d("CREATE EXAM_SCORE", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE EXAM_SCORE",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS PROGRAM (" +
                    "ID_PROGRAM TEXT PRIMARY KEY, " +
                    "NAME TEXT, " +
                    "INPUT_SCORE REAL, " +
                    "OUTPUT_SCORE REAL, " +
                    "CONTENT TEXT, " +
                    "SPEAKING_SCORE REAL, " +
                    "WRITING_SCORE REAL, " +
                    "LISTENING_SCORE REAL, " +
                    "READING_SCORE REAL, " +
                    "ID_CERTIFICATE REAL, " +
                    "STATUS INTEGER," +
                    "FOREIGN KEY (ID_CERTIFICATE) REFERENCES CERTIFICATE(ID_CERTIFICATE))");
            Log.d("CREATE PROGRAM", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE PROGRAM",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS ACCOUNT (" +
                    "ID_ACCOUNT TEXT PRIMARY KEY, " +
                    "ID_USER TEXT," +
                    "USERNAME TEXT, " +
                    "PASSWORD TEXT," +
                    "FOREIGN KEY (ID_USER) REFERENCES OFFICAL_STUDENT(ID_STUDENT)," +
                    "FOREIGN KEY (ID_USER) REFERENCES TEACHER(ID_TEACHER)," +
                    "FOREIGN KEY (ID_USER) REFERENCES STAFF(ID_STAFF) )");
            Log.d("CREATE ACCOUNT", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE ACCOUNT",  e.getMessage());
        }

        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS REPORT (" +
                    "ID_REPORT TEXT PRIMARY KEY, " +
                    "REPORT_TIME TEXT," +
                    "REVENUE INTEGER )");
            Log.d("CREATE REPORT", "Database created successfully");
        } catch ( Exception e) {
            Log.d("CREATE REPORT",  e.getMessage());
        }

    }

    public void recreateDatabase(Context context) {
        File dbFile = new File(getWritableDatabase().getPath());
        Log.d("Database path: ", dbFile.toString());
        if (!dbFile.exists()) {
            // Nếu file không tồn tại, khởi tạo lại cơ sở dữ liệu
            SQLiteDatabase db = getWritableDatabase();
            onCreate(db);
        }
    }

    public int insertData(String tableName, ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        int newRowId = (int)db.insert(tableName, null, contentValues);
        db.close();

        return newRowId;
    }

    public int deleteData(String tableName, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsDeleted = db.delete(tableName, whereClause, whereArgs);
        db.close();

        return rowsDeleted;
    }

    public int updateData(String tableName, ContentValues contentValues, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsUpdated = db.update(tableName, contentValues, whereClause, whereArgs);
        db.close();
        return rowsUpdated;
    }

    /*public void insertAccount(String idAccount, String idUser, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID_ACCOUNT", idAccount);
        values.put("ID_USER", idUser);
        values.put("USERNAME", username);
        values.put("PASSWORD", password);
        long newRowId = db.insert("ACCOUNT", null, values);
        db.close();
    }*/

    /*public void insertOfficialStudentDAO(String idStudent, String fullName, String address, String phoneNumber, String gender, int status) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID_STUDENT", idStudent);
        values.put("FULLNAME", fullName);
        values.put("ADDRESS", address);
        values.put("PHONE_NUMBER", phoneNumber);
        values.put("GENDER", gender);
        values.put("STATUS", status);
        long newRowId = db.insert("OFFICIAL_STUDENT", null, values);
        db.close();
    }*/

}