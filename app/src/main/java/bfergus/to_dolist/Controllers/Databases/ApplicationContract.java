package bfergus.to_dolist.Controllers.Databases;


public final class ApplicationContract {
    public static final String DATABASE_NAME = "GoDoListDB";
    public static final int DATABASE_VERSION = 1;

    private ApplicationContract() {
        throw new AssertionError();
    }

    public static final class Notes {
        public static final String TABLE_NAME = "Notes";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMNN_TITLE = "Title";
        public static final String COLUMN_DESCRIPTION = "Description";
        public static final String COLUMN_NOTE_COLOR = "NoteColor";

        private Notes() {
            throw new AssertionError();
        }


    }


}
