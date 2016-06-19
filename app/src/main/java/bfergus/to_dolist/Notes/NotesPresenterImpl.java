package bfergus.to_dolist.Notes;


public class NotesPresenterImpl implements  NotesPresenter {

    NotesView view;

    boolean fabOpen = false;

    public NotesPresenterImpl(NotesView view) {
        this.view = view;
    }

    public void animateFab() {
        if (fabOpen) {
            view.closeFab();
            fabOpen = false;
        }
        else {
            view.openFab();
            fabOpen = true;
        }
    }
}
