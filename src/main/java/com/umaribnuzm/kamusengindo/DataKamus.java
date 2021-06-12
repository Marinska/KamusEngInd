package com.umaribnuzm.kamusengindo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataKamus extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbkamus";
    private static final String INGGRIS = "inggris";
    private static final String INDONESIA = "indonesia";

    //Constructor DataKamus untuk initiate database
    public DataKamus(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    //method createTable untuk membuat table kamus
    public void createTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS kamus");
        db.execSQL("CREATE TABLE if not exists kamus(id INTEGER PRIMARY KEY AUTOINCREMENT,inggris TEXT, indonesia TEXT);");
    }

    //method generateData untuk mengisikan data ke kamus.
    public void generateData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(INGGRIS, "run");
        cv.put(INDONESIA, "lari");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "walk");
        cv.put(INDONESIA, "jalan");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "read");
        cv.put(INDONESIA, "membaca");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "study");
        cv.put(INDONESIA, "belajar");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "source");
        cv.put(INDONESIA, "sumber");
        db.insert("kamus", INGGRIS, cv);
        cv.put(INGGRIS, "code");
        cv.put(INDONESIA, "kode");
        db.insert("kamus", INGGRIS, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO Auto-generated method stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO Auto-generated method stub
    }
}
