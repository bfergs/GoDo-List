package bfergus.to_dolist.Notes;


public class NotesPresenterImpl implements  NotesPresenter {

    NotesView view;

    boolean fabOpen = false;
    boolean paintButtonsOpen = false;
    boolean textEdited = false;

    public NotesPresenterImpl(NotesView view) {
        this.view = view;
    }

    public void onCreate() {
        view.setOnClickListeners();
        view.handleEditTexts();
    }

    public void animateFab() {
        if (fabOpen) {
            view.closeFab();
            view.changeSubFabEnabledStatus(false);
            fabOpen = false;
        }
        else {
            view.openFab();
            view.changeSubFabEnabledStatus(true);
            fabOpen = true;
        }
    }

    //unlike animate fab this is called for any click on the screen.
    public void closeFab() {
        if(fabOpen) {
            view.closeFab();
            view.changeSubFabEnabledStatus(false);
            fabOpen = false;
        }
    }


    public void animatePaintButtons() {
        if(paintButtonsOpen) {
            view.closePaintButtons();
            view.changePaintButtonsEnabledStatus(false);
            paintButtonsOpen = false;

        }
        else {
            view.openPaintButtons();
            view.changePaintButtonsEnabledStatus(true);
            paintButtonsOpen = true;
        }
    }

    public void closePaintButtons() {
        if(paintButtonsOpen) {
            view.closePaintButtons();
            view.changePaintButtonsEnabledStatus(false);
            paintButtonsOpen = false;
        }
    }

    //used to display an alert dialog that will show when a note isn't saved.
    public void textHasBeenEdited() {
        textEdited = true;
    }

    public void onBackPressed() {
        if(textEdited){
            view.displayNoteNotSavedAlert();
        }
        else view.endActivity();
    }

    public void finish() {
        view.endActivity();
    }

    public void changeEditTextColor(int color) {
        view.changeEditTextColor(color);
    }
}
