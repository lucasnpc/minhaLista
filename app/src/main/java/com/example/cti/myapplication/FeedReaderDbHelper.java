package com.example.cti.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.AccessControlContext;

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + bancodados.FeedEntry.table_nome + " (" +
                    bancodados.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    bancodados.FeedEntry.column_nome + TEXT_TYPE + COMMA_SEP + " )";

    private static final String SQL_DELETE_POSTS =
            "DROP TABLE IF EXISTS " + bancodados.FeedEntry.table_nome;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "banco1.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_POSTS);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
