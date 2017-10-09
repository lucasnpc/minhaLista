package com.example.cti.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Cti on 09/10/2017.
 */

public class lista extends MainActivity {

    private EditText txtNome;
    ArrayAdapter<String> adapter;
    ListView listItems;
    ArrayList<String> palavras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);

        txtNome = (EditText) findViewById(R.id.editText2);
        listItems = (ListView) findViewById(R.id.listView);

        String[] items = {"Louco",
                "Doido",
                "Maluco"};

        palavras=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtitem,palavras);
        listItems.setAdapter(adapter);

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
    }
}
