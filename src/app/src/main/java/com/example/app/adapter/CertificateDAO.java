package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;

import com.example.app.model.CertificateDTO;

public class CertificateDAO {
    public static CertificateDAO instance;
    private CertificateDAO(Context context) {}
    public static synchronized CertificateDAO getInstance(Context context) {
        if (instance == null) {
            instance = new CertificateDAO(context);
        }
        return instance;
    }
    public int InsertCertificate(Context context, CertificateDTO certificate) {
        int rowEffect = -1;

        // private String programID, programName, speak, write, read, listen, state, description;
        /*"ID_CERTIFICATE TEXT PRIMARY KEY, " +
                "NAME TEXT, " +
                "CONTENT TEXT, " +
                "MINIMUM_SCORE REAL, " +
                "STATUS INTEGER)");*/
        ContentValues values = new ContentValues();

        return rowEffect;
    }
}
