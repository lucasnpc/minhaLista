package com.example.cti.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cti on 09/10/2017.
 */

public class BancoControler {
    private SQLiteDatabase db;
    private FeedReaderDbHelper banco;

    public BancoControler(Context context) {
        banco = new FeedReaderDbHelper(context);
    }

    public String insereDado(String nome) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(FeedReaderDbHelper.column_nome, nome);

        resultado = db.insert(FeedReaderDbHelper.table_nome, null, valores);
        db.close();

        if(resultado == -1)
            return  "Erro ao inserir registro.";
        else
            return "Registro inserido com sucesso.";
    }

    public List<String> carregaDados(){
        List<String> nomes = new ArrayList<>();
        Cursor cursor;
        String[] campos = {FeedReaderDbHelper.column_nome, "_id"};
        db = banco.getReadableDatabase();
        cursor = db.query(FeedReaderDbHelper.table_nome,campos, null, null, null, null, null, null);

        if(cursor != null) {
            cursor.moveToFirst();

            String nome;
            while (cursor.moveToNext()) {
                nome = cursor.getString(cursor.getColumnIndex("nome"));
                nomes.add(nome);
            }
            db.close();
            return nomes;
        }
        else {
            db.close();
            return null;
        }
    }
}
