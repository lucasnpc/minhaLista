package com.example.cti.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Cti on 09/10/2017.
 */

public class lista extends MainActivity {

    ListView listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        listItems = (ListView) findViewById(R.id.ListView);

        BancoControler crud = new BancoControler(getBaseContext());
        Cursor cursor = crud.carregaDados();

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(this, R.layout.list_item, cursor,
                new String[]{FeedReaderDbHelper.ID,
                        FeedReaderDbHelper.column_nome},
                new int[]{R.id.id, R.id.txtitem});
        adaptador.notifyDataSetChanged();
        listItems.setAdapter(adaptador);
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
