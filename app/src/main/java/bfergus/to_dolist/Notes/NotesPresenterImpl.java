package bfergus.to_dolist.Notes;


import bfergus.to_dolist.Enums.PaintColor;
import bfergus.to_dolist.Utils.ConvertPaintColors;

public class NotesPresenterImpl implements  NotesPresenter {

    NotesView view;

    boolean fabOpen = false;
    boolean paintButtonsOpen = false;
    boolean textEdited = false;

    PaintColor currentBackgroundColor = PaintColor.WHITE;

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

    public void changeBackgroundColor(PaintColor color) {
        view.changeBackgroundColor(ConvertPaintColors.getIntValueFromPaintColor(color));
        saveColor(color);
    }
    private void saveColor(PaintColor color) {
        currentBackgroundColor = color;
    }

    public int getCurrentColor() {
        return ConvertPaintColors.getIntValueFromPaintColor(currentBackgroundColor);
    }
}
