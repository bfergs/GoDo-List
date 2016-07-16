package bfergus.to_dolist.Notes;


import bfergus.to_dolist.Enums.NoteColor;

public interface NotesPresenter {
    void animateFab();
    void closeFab();
    void textHasBeenEdited();
    void onCreate();
    void onBackPressed();
    void animatePaintButtons();
    void closePaintButtons();
    void changeNoteColor(NoteColor color);
    int getCurrentColor();

}
