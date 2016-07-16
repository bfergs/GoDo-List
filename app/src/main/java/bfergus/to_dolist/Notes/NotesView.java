package bfergus.to_dolist.Notes;

public interface NotesView {

    void openFab();
    void closeFab();
    void initializeEditTexts();
    void initializeClickListeners();
    void displayNoteNotSavedMessage();
    void endActivity(boolean noteEdited);
    void openPaintButtons();
    void closePaintButtons();
    void changeSubFabEnabledStatus(Boolean status);
    void changePaintButtonsEnabledStatus(Boolean status);
    void changeBackgroundColor(int color);
}
