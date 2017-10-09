package com.example.cti.myapplication;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    ArrayAdapter<String> adapter;
    ListView listItems;
    ArrayList<String> palavras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = (EditText) findViewById(R.id.editText2);
        listItems = (ListView) findViewById(R.id.Lista);

        String[] items = {"Louco","Doido","Maluco"};

        palavras=new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtitem,palavras);
        listItems.setAdapter(adapter);

        listItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                palavras.remove(palavras.get(position));
                adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.list_item,R.id.txtitem,palavras);
                adapter.notifyDataSetChanged();
                listItems.setAdapter(adapter);

                return false;
            }
        });

    }

    public void insereRegistro(View v){
        Button b = (Button)findViewById(R.id.bAdd);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoControler crud = new BancoControler(getBaseContext());
                EditText nome = (EditText) findViewById(R.id.editText2);
                String nomeString = nome.getText().toString();
                String resultado;

                resultado = crud.insereDado(nomeString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
