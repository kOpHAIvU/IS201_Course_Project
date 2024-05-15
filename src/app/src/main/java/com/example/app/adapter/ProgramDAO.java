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

        values.put("ID_PROGRAM", "PRO" + String.valueOf(maxId + 1));
        values.put("NAME", program.getNameProgram());
        values.put("INPUT_SCORE", program.getInputScore());
        values.put("OUTPUT_SCORE", program.getOutputScore());
        values.put("CONTENT", program.getContent());
        values.put("SPEAKING_SCORE", program.getSpeakingScore());
        values.put("WRITING_SCORE", program.getWritingScore());
        values.put("LISTENING_SCORE", program.getListeningScore());
        values.put("READING_SCORE", program.getReadingScore());

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
                writing = "", listening = "", reading = "";
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
                listProgram.add(new ProgramDTO(id, name, input, output, content, speaking, writing,
                        listening, reading));
            } while (cursor.moveToNext());
        }
        return listProgram;
    }
}
