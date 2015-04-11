package com.appsynopsis.shell.shell;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nila on 4/11/15.
 */
public class DBhelher extends SQLiteOpenHelper {
    public  static final  String DATABASE_NAME="alarms";
    public  static final  String TABLE_NAME="alarms";
    public  static final  String KEY_ID="id";
    public  static final  String KEY_TITLE="title";
    public  static final  String KEY_DESCRIPTION="description";
    public  static final  String KEY_TIME="time";
    public  static int DATABASE_VERSION=1;
    public DBhelher(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_QSDetails_TABLE = "CREATE TABLE " + TABLE_NAME + "("

                + KEY_ID + " INTEGER PRIMARY KEY AUTO INCREMENT,"
                + KEY_TITLE + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"
                + KEY_TIME + " TEXT" + ")";
        db.execSQL(CREATE_QSDetails_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }
    public void setAlarm(String title, String description, String date){

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE,title);
        values.put(KEY_DESCRIPTION,description);
        values.put(KEY_TIME,date);
    }


    public Cursor getAlarms(){
        SQLiteDatabase db=this.getReadableDatabase();


        return db.query(TABLE_NAME, new String[]{KEY_ID,KEY_TITLE,KEY_DESCRIPTION,KEY_DESCRIPTION} ,null,null,null,null,null);

    }
    public void deleteAlarm(int id){

        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME, "WHERE id="+id,null);
        db.close();


    }
}
