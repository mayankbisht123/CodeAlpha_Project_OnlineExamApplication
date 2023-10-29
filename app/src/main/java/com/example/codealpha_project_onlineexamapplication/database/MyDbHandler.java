package com.example.codealpha_project_onlineexamapplication.database;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import androidx.annotation.Nullable;


import com.example.codealpha_project_onlineexamapplication.data.Params;
import com.example.codealpha_project_onlineexamapplication.model.Details;

import java.util.ArrayList;
import java.util.List;


public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(@Nullable Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String table="CREATE TABLE "+Params.TABLE_NAME+" ("+Params.KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +Params.KEY_NAME+" TEXT, "+Params.KEY_EMAIL+" text,"+Params.KEY_PASSWORD+" text,"+Params.KEY_CPASSWORD+" text)";
        sqLiteDatabase.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addContacts(Details contacts){
        SQLiteDatabase sq=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(Params.KEY_NAME,contacts.getName());
        values.put(Params.KEY_EMAIL,contacts.getEmail());
        values.put(Params.KEY_PASSWORD,contacts.getPassword());
        values.put(Params.KEY_CPASSWORD,contacts.getCpassword());
        sq.insert(Params.TABLE_NAME,null,values);
        sq.close();
    }
    public List<Details> getContacts(){
        List<Details> list=new ArrayList<>();
        SQLiteDatabase sq=getReadableDatabase();
        Cursor cursor=sq.rawQuery("SELECT * FROM "+Params.TABLE_NAME,null);
        if(cursor.moveToFirst())
        {
            do{
                Details contacts=new Details();
                contacts.setId(cursor.getInt(0));
                contacts.setName(cursor.getString(1));
                contacts.setEmail(cursor.getString(2));
                contacts.setPassword(cursor.getString(3));
                contacts.setCpassword(cursor.getString(4));
                list.add(contacts);

            }while(cursor.moveToNext());
        }
        cursor.close();
        sq.close();
        return list;
    }
}


