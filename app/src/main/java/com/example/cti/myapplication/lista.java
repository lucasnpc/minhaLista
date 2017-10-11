package com.example.cti.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Cti on 09/10/2017.
 */

public class lista extends MainActivity {

    ListView listItems;
    private SQLiteDatabase db;
    private CursorAdapter dataSource;
    private FeedReaderDbHelper banco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        listItems = (ListView) findViewById(R.id.ListView);
        banco = new FeedReaderDbHelper(getBaseContext());

        //BancoControler crud = new BancoControler(getBaseContext());
        String[] campos = {FeedReaderDbHelper.ID,FeedReaderDbHelper.column_nome};
        db = banco.getReadableDatabase();
        Cursor cursor = db.query(FeedReaderDbHelper.table_nome,campos,null,null,null,null,null,null);

        if(cursor != null) {
            cursor.moveToFirst();
        }

        if(cursor.getCount() > 0) {
            dataSource = new SimpleCursorAdapter(getBaseContext(), R.layout.list_view, cursor,
                    new String[]{FeedReaderDbHelper.ID,
                            FeedReaderDbHelper.column_nome},
                    new int[]{R.id.id, R.id.txtitem},0);
            listItems.setAdapter(dataSource);
        }
        else {
            Toast.makeText(this,"Nenhum registro encontrado", Toast.LENGTH_LONG).show();

        }
    }
}

        /*
        listItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                palavras.remove(palavras.get(position));
                adapter=new ArrayAdapter<String>(lista.this,R.layout.list_item,R.id.txtitem,palavras);
                adapter.notifyDataSetChanged();
                listItems.setAdapter(adapter);

                return false;
            }
        });
        */
