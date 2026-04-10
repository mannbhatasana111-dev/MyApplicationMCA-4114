package com.example.myapplicationmca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context) {
        super(context, "HospitalDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Doc_detail(doc_id TEXT PRIMARY KEY, firstname TEXT, lastname TEXT, mob TEXT, address TEXT, city TEXT, specialization TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Doc_detail");
        onCreate(db);
    }

    public boolean insertDoctor(String id, String fn, String ln, String mob, String add, String city, String spec) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("doc_id", id);
        cv.put("firstname", fn);
        cv.put("lastname", ln);
        cv.put("mob", mob);
        cv.put("address", add);
        cv.put("city", city);
        cv.put("specialization", spec);
        return db.insert("Doc_detail", null, cv) != -1;
    }

    public Cursor getDoctorById(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Doc_detail WHERE doc_id=?", new String[]{id});
    }
}