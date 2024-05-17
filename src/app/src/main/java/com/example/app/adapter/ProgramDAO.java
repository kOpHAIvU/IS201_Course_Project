package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.app.model.ProgramDTO;

import java.util.ArrayList;
import java.util.List;

public class ProgramDAO {
    public static ProgramDAO instance;
    private ProgramDAO(Context context) {}
    public static synchronized ProgramDAO getInstance(Context context) {
        if (instance == null) {
            instance = new ProgramDAO(context);
        }
        return instance;
    }

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
        values.put("TUITION_FEES", program.getTuitionFees());
        values.put("STUDY_PERIOD", program.getStudy_period());
        values.put("ID_CERTIFICATE", program.getIdCertificate());
        values.put("STATUS", 0);

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

        /*    db.execSQL("CREATE TABLE IF NOT EXISTS PROGRAM (" +
            "ID_PROGRAM TEXT PRIMARY KEY, " +
            "NAME TEXT, " +
            "INPUT_SCORE REAL, " +
            "OUTPUT_SCORE REAL, " +
            "CONTENT TEXT, " +
            "SPEAKING_SCORE REAL, " +
            "WRITING_SCORE REAL, " +
            "LISTENING_SCORE REAL, " +
            "READING_SCORE REAL, " +
            "TUITION_FEES INTEGER, " +
            "STUDY_PERIOD INTEGER, " + // Lộ trình học kéo dài 6 tháng, 12 tháng,....
            "ID_CERTIFICATE TEXT, " +
            "STATUS INTEGER, " +
            "FOREIGN KEY (ID_CERTIFICATE) REFERENCES CERTIFICATE(ID_CERTIFICATE))");
            Log.d("CREATE PROGRAM", "Database created successfully");*/

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
        values.put("TUITION_FEES", program.getTuitionFees());
        values.put("STUDY_PERIOD", program.getStudy_period());
        values.put("ID_CERTIFICATE", program.getIdCertificate());
        values.put("STATUS", 0);

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

    public List<ProgramDTO> SelectProgram(Context context, String whereClause, String[] whereArgs) {
        List<ProgramDTO> listProgram = new ArrayList<>();
        Cursor cursor = null;

        try {
            cursor = DataProvider.getInstance(context).selectData("PROGRAM", new String[]{"*"},  whereClause, whereArgs, null);
        }catch(Exception e) {
            Log.d("Select Program: ", e.getMessage());
        }

        String id = "", name = "", input = "", output = "", content = "", speaking = "",
                writing = "", listening = "", reading = "", studyPeriod = "", idCertificate = "";
        int tuition = 0;

        if (cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex("ID_PROGRAM");
                if (idIndex!= -1) {
                    id = cursor.getString(idIndex);
                }
                int nameIndex = cursor.getColumnIndex("NAME");
                if (nameIndex != -1) {
                    name = cursor.getString(nameIndex);
                }
                int inputIndex = cursor.getColumnIndex("INPUT_SCORE");
                if (idIndex!= -1) {
                    input = cursor.getString(inputIndex);
                }
                int outputIndex = cursor.getColumnIndex("OUTPUT_SCORE");
                if (outputIndex!= -1) {
                    output = cursor.getString(outputIndex);
                }
                int contentIndex = cursor.getColumnIndex("CONTENT");
                if (contentIndex != -1) {
                    content = cursor.getString(contentIndex);
                }
                int speakingIndex = cursor.getColumnIndex("SPEAKING_SCORE");
                if (speakingIndex != -1) {
                    speaking = cursor.getString(speakingIndex);
                }
                int writingIndex = cursor.getColumnIndex("WRITING_SCORE");
                if (writingIndex != -1) {
                    writing = cursor.getString(writingIndex);
                }
                int listeningIndex = cursor.getColumnIndex("LISTENING_SCORE");
                if (listeningIndex!= -1) {
                    listening = cursor.getString(listeningIndex);
                }
                int readingIndex = cursor.getColumnIndex("READING_SCORE");
                if (readingIndex != -1) {
                    reading = cursor.getString(readingIndex);
                }
                int tuitionIndex = cursor.getColumnIndex("TUITION_FESS");
                if (tuitionIndex != -1) {
                    tuition = cursor.getInt(tuitionIndex);
                }
                int periodIndex = cursor.getColumnIndex("STUDY_PERIOD");
                if (periodIndex != -1) {
                    studyPeriod = cursor.getString(periodIndex);
                }
                int certificateIndex = cursor.getColumnIndex("ID_CERTIFICATE");
                if (certificateIndex != -1) {
                    idCertificate = cursor.getString(certificateIndex);
                }
                listProgram.add(new ProgramDTO(id, name, input, output, content, speaking, writing,
                        listening, reading, tuitionIndex, studyPeriod, idCertificate));
            } while (cursor.moveToNext());
        }
        return listProgram;
    }
}
