package com.example.cti.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    ArrayAdapter<String> adapter;
    ListView listItems;
    ArrayList<String> palavras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText) findViewById(R.id.editText);
        listItems = (ListView) findViewById(R.id.Lista);

        String[] items = {"Louco","Doido","Maluco"};

        palavras=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtitem,palavras);
        listItems.setAdapter(adapter);

    }

    public void addNome(View view){
        try {
            Button b = (Button) view;
            String nome = txtNome.getText().toString();


            palavras.add(nome);
            adapter.notifyDataSetChanged();
        }catch (Exception ex){
            Log.d("Lista",ex.getMessage());
        }

    }
}
