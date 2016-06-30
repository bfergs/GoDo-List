package bfergus.to_dolist.Notes;


import bfergus.to_dolist.Enums.PaintColor;

public interface NotesPresenter {
    void animateFab();
    void closeFab();
    void textHasBeenEdited();
    void onCreate();
    void onBackPressed();
    void animatePaintButtons();
    void closePaintButtons();
    void changeBackgroundColor(PaintColor color);
    int getCurrentColor();

}
