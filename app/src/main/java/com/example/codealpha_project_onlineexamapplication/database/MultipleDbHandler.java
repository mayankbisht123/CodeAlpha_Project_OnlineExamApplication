package com.example.codealpha_project_onlineexamapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.codealpha_project_onlineexamapplication.data.MultipleParams;
import com.example.codealpha_project_onlineexamapplication.model.MultipleDetails;

import java.util.ArrayList;
import java.util.List;

public class MultipleDbHandler extends SQLiteOpenHelper {

    public MultipleDbHandler(@Nullable Context context) {
        super(context, MultipleParams.DB_NAME,null, Integer.parseInt(MultipleParams.DB_VERSION));
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String table="Create table "+MultipleParams.TABLE_NAME+"("+MultipleParams.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
               +MultipleParams.KEY_QUESTION+" text,"
               +MultipleParams.KEY_OPTION1+" text,"
                +MultipleParams.KEY_OPTION2+" text,"
                +MultipleParams.KEY_OPTION3+" text,"
                +MultipleParams.KEY_OPTION4+" text)";
       db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addQuestions(MultipleDetails multipleDetails)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MultipleParams.KEY_QUESTION, multipleDetails.getQuestion());
            contentValues.put(MultipleParams.KEY_OPTION1, multipleDetails.getOption1());
            contentValues.put(MultipleParams.KEY_OPTION2, multipleDetails.getOption2());
            contentValues.put(MultipleParams.KEY_OPTION3, multipleDetails.getOption3());
            contentValues.put(MultipleParams.KEY_OPTION4, multipleDetails.getOption4());
            sqLiteDatabase.insert(MultipleParams.TABLE_NAME, null, contentValues);
        }
        catch (SQLiteException e){
            e.printStackTrace();
        }
        finally {
            sqLiteDatabase.close();
        }

    }
    public List<MultipleDetails> getQuestions()
    {
        List<MultipleDetails> multipleDetailsList=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        try {
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + MultipleParams.TABLE_NAME, null);
            if (cursor.moveToFirst()) {
                do {
                    MultipleDetails multipleDetails = new MultipleDetails();
                    multipleDetails.setQuestion(cursor.getString(1));
                    multipleDetails.setOption1(cursor.getString(2));
                    multipleDetails.setOption2(cursor.getString(3));
                    multipleDetails.setOption3(cursor.getString(4));
                    multipleDetails.setOption4(cursor.getString(5));
                    multipleDetailsList.add(multipleDetails);
                } while (cursor.moveToNext());
            }
        }
        catch(SQLiteException e){
            e.printStackTrace();
        }
        finally {
            sqLiteDatabase.close();
        }

        return multipleDetailsList;
    }
}
