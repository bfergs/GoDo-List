package bfergus.to_dolist.Controllers.Databases;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import bfergus.to_dolist.GoDoListApplication;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private static final String DATABASE_CREATE_NOTES =
            "CREATE TABLE " + ApplicationContract.Notes.TABLE_NAME + " (" +
                    ApplicationContract.Notes.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ApplicationContract.Notes.COLUMNN_TITLE + TEXT_TYPE + COMMA_SEP +
                    ApplicationContract.Notes.COLUMN_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    ApplicationContract.Notes.COLUMN_NOTE_COLOR + TEXT_TYPE +  ");";

    private static DatabaseHelper mInstance;

    public static synchronized DatabaseHelper getInstance() {
        if(mInstance == null) {
            mInstance = new DatabaseHelper(GoDoListApplication.getInstance());
        }
        return mInstance;
    }

    public DatabaseHelper(Context context) {
        super(context, ApplicationContract.DATABASE_NAME, null, ApplicationContract.DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_NOTES);
    }

    //todo: this
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){}


}
