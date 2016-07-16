package bfergus.to_dolist.Controllers.Databases;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import bfergus.to_dolist.Enums.NoteColor;
import bfergus.to_dolist.Utils.ConvertNoteColors;

public class DatabaseAdapterNotes {
    private SQLiteDatabase mDatabase;

    private static final String[] ALL_COLUMNS = new String[]{
            ApplicationContract.Notes.COLUMN_ID,
            ApplicationContract.Notes.COLUMNN_TITLE,
            ApplicationContract.Notes.COLUMN_DESCRIPTION,
            ApplicationContract.Notes.COLUMN_NOTE_COLOR
    };

    public DatabaseAdapterNotes() {
        mDatabase = DatabaseHelper.getInstance().getWritableDatabase();
    }

    public void insertNote(String title, String description, NoteColor color) {
        ContentValues values = new ContentValues();
        values.put(ApplicationContract.Notes.COLUMNN_TITLE, title);
        values.put(ApplicationContract.Notes.COLUMN_DESCRIPTION, description);
        values.put(ApplicationContract.Notes.COLUMN_NOTE_COLOR, ConvertNoteColors.noteColorToString(color));
        mDatabase.insert(ApplicationContract.Notes.TABLE_NAME, null, values);
    }

    public void insertNote(){}

    public Cursor getAllNotes() {
        return mDatabase.query(ApplicationContract.Notes.TABLE_NAME,ALL_COLUMNS, null, null, null, null, null);
    }

    //todo: this
    public void deleteNote(int NoteColumnId) {
        //String selection =
    }



    public void close() {
        mDatabase.close();
    }
}
