package com.example.app.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.app.model.AccountDTO;

public class AccountDAO {
    public static AccountDAO instance;
    private AccountDAO(Context context) {}
    public static synchronized AccountDAO getInstance(Context context) {
        if (instance == null) {
            instance = new AccountDAO(context);
        }
        return instance;
    }

    public void insertAccount(Context context, AccountDTO accountDTO) {
        ContentValues values = new ContentValues();

        int maxId = DataProvider.getInstance(context).getMaxId("ACCOUNT", "ID_ACCOUNT");

        values.put("ID_ACCOUNT", "ACC" + String.valueOf(maxId + 1));
        values.put("ID_USER", accountDTO.getIdUser());
        values.put("USERNAME", accountDTO.getUserName());
        values.put("PASSWORD", accountDTO.getPassWord());
        try {
            int rowEffect = DataProvider.getInstance(context).insertData("ACCOUNT", values);
            if (rowEffect > 0 ) {
                Log.d("Insert Account: ", "success");
            } else {
                Log.d("Insert Account: ", "Fail");
            }
        } catch (Exception e) {
            Log.d("Insert Account Error: ", e.getMessage());
        }
    }

    public int deleteAccount(Context context, String whereClause, String[] whereArgs)  {
        try {
            int rowEffect = DataProvider.getInstance(context).deleteData("ACCOUNT",whereClause, whereArgs);
            return rowEffect;
        } catch (Exception e) {
            Log.d("Delete Account Error: ", e.getMessage());
        }
        return 0;
    }

    public int updateAccount(Context context, AccountDTO accountDTO, String whereClause, String[] whereArgs) {
        ContentValues values = new ContentValues();
        values.put("ID_ACCOUNT", accountDTO.getIdAccount());
        values.put("ID_USER", accountDTO.getIdUser());
        values.put("USERNAME", accountDTO.getUserName());
        values.put("PASSWORD", accountDTO.getPassWord());

        try {
            int rowsUpdated = DataProvider.getInstance(context).updateData("ACCOUNT", values, whereClause, whereArgs);
            return rowsUpdated;
        } catch (Exception e) {
            Log.e("Update Account Error: ", e.getMessage());
        }
        return 0;
    }

    //String tableName, String[] columns, String whereClause, String[] whereArgs, String groupBy
    public Cursor selectAccount(Context context, String whereClause, String[] whereArgs) {
        Cursor cursor = null;
        try {
            cursor = DataProvider.getInstance(context).selectData("ACCOUNT", new String[]{"*"},  whereClause, whereArgs, null);
        }catch(Exception e) {
            Log.d("Select Account: ", e.getMessage());
        }
        return cursor;
    }

}
