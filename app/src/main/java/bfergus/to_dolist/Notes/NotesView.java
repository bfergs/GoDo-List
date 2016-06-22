package bfergus.to_dolist.Notes;

public interface NotesView {

    void openFab();
    void closeFab();
    void handleEditTexts();
    void setOnClickListeners();
    void displayNoteNotSavedAlert();
    void endActivity();
    void openPaintButtons();
    void closePaintButtons();
    void changeSubFabEnabledStatus(Boolean status);
    void changePaintButtonsEnabledStatus(Boolean status);
    void changeEditTextColor(int color);
}
