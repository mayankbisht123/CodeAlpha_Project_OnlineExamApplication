package com.example.codealpha_project_onlineexamapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.example.codealpha_project_onlineexamapplication.data.WrittenParams;
import com.example.codealpha_project_onlineexamapplication.model.WrittenDetails;

import java.util.ArrayList;
import java.util.List;

public class WrittenDbHandler extends SQLiteOpenHelper {

    public WrittenDbHandler(@Nullable Context context) {
        super(context, WrittenParams.DB_NAME,null,WrittenParams.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table="Create table "+WrittenParams.TABLE_NAME+"("+WrittenParams.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +WrittenParams.KEY_QUESTION+" text)";
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addQuestions(WrittenDetails writtenDetails)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(WrittenParams.KEY_QUESTION, writtenDetails.getQuestion());
            sqLiteDatabase.insert(WrittenParams.TABLE_NAME, null, contentValues);
        }
        catch (SQLiteException e)
        {
            e.printStackTrace();
        }
        finally {
            sqLiteDatabase.close();
        }


    }
    public List<WrittenDetails> getQuestions()
    {
        List<WrittenDetails> writtenDetailsList=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        try {
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + WrittenParams.TABLE_NAME, null);
            if (cursor.moveToFirst()) {
                do {
                    WrittenDetails writtenDetails = new WrittenDetails();
                    writtenDetails.setQuestion(cursor.getString(1));
                    writtenDetailsList.add(writtenDetails);
                } while (cursor.moveToNext());
            }
        }
        catch (SQLiteException e)
        {
            e.printStackTrace();
        }
        finally {
            sqLiteDatabase.close();
        }
        return writtenDetailsList;
    }
}
