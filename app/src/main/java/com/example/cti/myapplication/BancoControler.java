package com.example.cti.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
}
