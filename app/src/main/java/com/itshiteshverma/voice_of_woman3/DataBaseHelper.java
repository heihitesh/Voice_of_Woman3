package com.itshiteshverma.voice_of_woman3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by Hitesh Verma on 6/29/2015.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1; //any no
    private static final String DATABASE_NAME = "contacts.db"; // make sure u have .db
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";
    SQLiteDatabase db;

    //querry
    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null , " +
            "name text not null , email text not null , uname text not null , pass text not null);";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //params 1)context , 2)DB name , 3) factory , 4) DB version


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }

    public void insertContact(Contact c) {
        db = this.getWritableDatabase(); // writting in the Data Base
        ContentValues values = new ContentValues();
        String query = "select * from contacts"; // * means all the contact
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();



        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME, c.getname());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());

        //insert it now
        db.insert(TABLE_NAME, null, values); //this will insert the contact methdo in DB
        db.close(); //closing the database

    }

    public String searchPass(String uname) {
        db = this.getReadableDatabase(); //Reading form the data base
        String querry = "select uname, pass from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(querry, null);
        String ausername, bpassword;
        bpassword = "NOT FOUND"; //if not found it will display this


        if (cursor.moveToFirst()) {
            do {
                ausername = cursor.getString(0);


                if(ausername.equals(uname)){
                    bpassword = cursor.getString(1);
                    break;

                }
            } while (cursor.moveToNext());
        }
        return bpassword;
    }

    public String searchName(String uname) {
        db = this.getReadableDatabase(); //Reading form the data base
        String querry = "select uname, name from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(querry, null);
        String ausername, bname;
        bname = "NOT FOUND"; //if not found it will display this


        if (cursor.moveToFirst()) {
            do {
                ausername = cursor.getString(0);


                if(ausername.equals(uname)){
                    bname = cursor.getString(1);
                    break;

                }
            } while (cursor.moveToNext());
        }
        return bname;
    }


}
