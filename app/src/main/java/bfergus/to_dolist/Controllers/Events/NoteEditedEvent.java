package bfergus.to_dolist.Controllers.Events;


public class NoteEditedEvent {
    private boolean mNoteEdited = false;

    public NoteEditedEvent(Boolean noteEdited) {
        mNoteEdited = noteEdited;
    }

    public boolean getStatus() {
        return mNoteEdited;
    }
}
