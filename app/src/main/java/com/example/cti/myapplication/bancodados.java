package com.example.cti.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.ParcelUuid;
import android.provider.BaseColumns;
import android.database.sqlite.*;

/**
 * Created by Cti on 06/10/2017.
 */

public final class bancodados {
    private bancodados() {}
    public static class FeedEntry implements BaseColumns {
        public static final String table_nome = "Nomes";
        public static final String column_nome = "nome";

    }
}

