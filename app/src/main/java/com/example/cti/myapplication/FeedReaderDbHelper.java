package com.example.cti.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.AccessControlContext;

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    public static final String table_nome = "Nomes";
    public static final String column_nome = "nome";
    public static final String ID = "id";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " +table_nome + " (" +
            ID + " integer primary key autoincrement,"+
            column_nome + " text)";

    private static final String SQL_DELETE_POSTS =
            "DROP TABLE IF EXISTS " + table_nome;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "primeiroBanco.db";

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
}
