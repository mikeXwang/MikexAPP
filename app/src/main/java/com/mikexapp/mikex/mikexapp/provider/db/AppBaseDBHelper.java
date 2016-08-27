package com.mikexapp.mikex.mikexapp.provider.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by mike on 16-8-27.
 */

public abstract class AppBaseDBHelper extends SQLiteOpenHelper {

    public AppBaseDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
}
