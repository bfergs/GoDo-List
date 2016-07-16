package bfergus.to_dolist.Controllers.Events;


import bfergus.to_dolist.Enums.NoteColor;

public class NoteColorSelectEvent {
    private NoteColor mNoteColor;

    public NoteColorSelectEvent(NoteColor color) {
        mNoteColor = color;
    }
    public NoteColor getSeletedNoteColor() {
        return mNoteColor;
    }
}
