package org.sfeirapp.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by tarekelchami on 28/04/14.
 */
public class MonumentDbHelper extends SQLiteOpenHelper {

    public static final String TAG = MonumentDbHelper.class.getSimpleName();

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Monuments.db";

    private static final String TEXT_TYPE  = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String CREATE_MONUMENT =
            "CREATE TABLE " +
             MonumentContract.MonumentEnty.TABLE_NAME +
             " (" + MonumentContract.MonumentEnty._ID + " INTEGER PRIMARY KEY," +
                    MonumentContract.MonumentEnty.COLUMN_NAME_MONUMENT_ID + TEXT_TYPE + COMMA_SEP +
                    MonumentContract.MonumentEnty.COLUMN_NAME_TITRE + TEXT_TYPE + COMMA_SEP +
                    MonumentContract.MonumentEnty.COLUMN_NAME_LIEU + TEXT_TYPE + COMMA_SEP +
                    MonumentContract.MonumentEnty.COLUMN_NAME_DESC + TEXT_TYPE  +
                    ")";
    private static final String DROP_MONUMENT =
            "DROP TABLE IF EXISTS " +
             MonumentContract.MonumentEnty.TABLE_NAME;

    public MonumentDbHelper(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG, "onCreate");
        sqLiteDatabase.execSQL(CREATE_MONUMENT);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        Log.d(TAG, "onUpgrade");
        sqLiteDatabase.execSQL(DROP_MONUMENT);
        onCreate(sqLiteDatabase);
    }
}
