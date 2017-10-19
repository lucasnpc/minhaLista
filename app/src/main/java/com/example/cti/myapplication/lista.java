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
import java.util.List;

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
        setContentView(R.layout.lista);
        listItems = (ListView) findViewById(R.id.lista2);
        banco = new FeedReaderDbHelper(getBaseContext());

        BancoControler crud = new BancoControler(getBaseContext());
        List<String> nomes = crud.carregaDados();

        if (nomes == null) {
            Toast.makeText(this, "Não Existem Elementos!", Toast.LENGTH_SHORT).show();
        }
        else {
            ArrayAdapter adapter=new ArrayAdapter<String>(lista.this,R.layout.list_item,R.id.txtitem,nomes);
            adapter.notifyDataSetChanged();
            listItems.setAdapter(adapter);
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
