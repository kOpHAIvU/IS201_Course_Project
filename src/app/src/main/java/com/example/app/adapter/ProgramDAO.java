package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.example.app.model.ProgramDTO;

public class ProgramDAO {
    public static ProgramDAO instance;
    private ProgramDAO(Context context) {}
    public static synchronized ProgramDAO getInstance(Context context) {
        if (instance == null) {
            instance = new ProgramDAO(context);
        }
        return instance;
    }

    /*ID_PROGRAM TEXT PRIMARY KEY, " +
            "NAME TEXT, " +
            "INPUT_SCORE REAL, " +
            "OUTPUT_SCORE REAL, " +
            "CONTENT TEXT, " +
            "SPEAKING_SCORE REAL, " +
            "WRITING_SCORE REAL, " +
            "LISTENING_SCORE REAL, " +
            "READING_SCORE REAL, " +
            "ID_CERTIFICATE REAL, " +
            "STATUS INTEGER," +*/
    public int InsertProgram(Context context, ProgramDTO program) {
        int rowEffect = -1;

        ContentValues values = new ContentValues();

        int maxId = DataProvider.getInstance(context).getMaxId("PROGRAM", "ID_PROGRAM");

        values.put("ID_PROGRAM", "PRO" + String.valueOf(maxId + 1));
        values.put("NAME", program.getNameProgram());
        values.put("INPUT_SCORE", program.getInputScore());
        values.put("OUTPUT_SCORE", program.getOutputScore());
        values.put("CONTENT", program.getContent());
        values.put("SPEAKING_SCORE", program.getSpeakingScore());
        values.put("WRITING_SCORE", program.getWritingScore());
        values.put("LISTENING_SCORE", program.getListeningScore());
        values.put("READING_SCORE", program.getReadingScore());
        values.put("ID_CERTIFICATE", program.getIdCertificate());

        try {
            rowEffect = DataProvider.getInstance(context).insertData("PROGRAM", values);
            Log.d("Insert program: ", String.valueOf(rowEffect));
            if (rowEffect > 0 ) {
                Log.d("Insert program ", "success");
            } else {
                Log.d("Insert program ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert program Error: ", e.getMessage());
        }

        return rowEffect;
    }

    public int UpdateProgram(Context context, ProgramDTO program, String whereClause, String[] whereArgs ) {
        int rowEffect = -1;

        ContentValues values = new ContentValues();

        int maxId = DataProvider.getInstance(context).getMaxId("PROGRAM", "ID_PROGRAM");

        values.put("ID_PROGRAM", "PRO" + String.valueOf(maxId));
        values.put("NAME", program.getNameProgram());
        values.put("INPUT_SCORE", program.getInputScore());
        values.put("OUTPUT_SCORE", program.getOutputScore());
        values.put("CONTENT", program.getContent());
        values.put("SPEAKING_SCORE", program.getSpeakingScore());
        values.put("WRITING_SCORE", program.getWritingScore());
        values.put("LISTENING_SCORE", program.getListeningScore());
        values.put("READING_SCORE", program.getReadingScore());
        values.put("ID_CERTIFICATE", program.getIdCertificate());

        try {
            rowEffect = DataProvider.getInstance(context).updateData("PROGRAM", values, whereClause, whereArgs);
            Log.d("Update program: ", String.valueOf(rowEffect));
            if (rowEffect > 0 ) {
                Log.d("Update program ", "success");
            } else {
                Log.d("Update program ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Update program Error: ", e.getMessage());
        }

        return rowEffect;
    }
}
