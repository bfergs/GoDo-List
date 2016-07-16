package bfergus.to_dolist.Notes;


import bfergus.to_dolist.Enums.NoteColor;
import bfergus.to_dolist.Utils.ConvertNoteColors;
import bfergus.to_dolist.Controllers.Events.NoteColorSelectEvent;
import bfergus.to_dolist.Controllers.Events.NoteEditedEvent;

public class NotesPresenterImpl implements  NotesPresenter {

    NotesView view;

    boolean fabOpen = false;
    boolean paintButtonsOpen = false;

    private NoteEditedEvent mNoteEditedEvent = new NoteEditedEvent(false);

    private NoteColorSelectEvent mNoteColorSelectEvent = new NoteColorSelectEvent(NoteColor.WHITE);

    public NotesPresenterImpl(NotesView view) {
        this.view = view;
    }

    public void onCreate() {
     intializeViews();
    }

    private void intializeViews() {
        view.initializeClickListeners();
        view.initializeEditTexts();
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

    public void textHasBeenEdited() {
        mNoteEditedEvent = new NoteEditedEvent(true);
    }

    public void onBackPressed() {
        if(!mNoteEditedEvent.getStatus()){
            view.displayNoteNotSavedMessage();
        }
        view.endActivity(mNoteEditedEvent.getStatus());
    }

    public void changeNoteColor(NoteColor color) {
        view.changeBackgroundColor(ConvertNoteColors.noteColorToIntValue(color));
        saveNoteColor(color);
    }
    private void saveNoteColor(NoteColor color) {
        mNoteColorSelectEvent = new NoteColorSelectEvent(color);
    }

    public int getCurrentColor() {
        return ConvertNoteColors.noteColorToIntValue(mNoteColorSelectEvent.getSeletedNoteColor());
    }
}
