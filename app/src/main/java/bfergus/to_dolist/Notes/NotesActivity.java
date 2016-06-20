package bfergus.to_dolist.Notes;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import bfergus.to_dolist.R;
import butterknife.Bind;
import butterknife.ButterKnife;


public class NotesActivity extends AppCompatActivity  implements NotesView, View.OnClickListener{
    NotesPresenter presenter;

    MaterialDialog notesNotSavedDialog;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.fabColorPicker)
    FloatingActionButton fabColorPicker;

    @Bind(R.id.fabDatePicker)
    FloatingActionButton fabDatePicker;

    @Bind(R.id.fabDone)
    FloatingActionButton fabDone;

    @Bind(R.id.titleEditText)
    EditText noteTitle;

    @Bind(R.id.descriptionEditText)
    EditText noteDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ButterKnife.bind(this);
        presenter = new NotesPresenterImpl(this);
        presenter.onCreate();
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        if(notesNotSavedDialog == null || !notesNotSavedDialog.isShowing()) presenter.onBackPressed();
        else presenter.finish();
    }

    public void endActivity() {
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        presenter.closeFab();
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.fab:
                presenter.animateFab();
                break;
            case R.id.fabColorPicker:
                Snackbar.make(v, "color", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                presenter.closeFab();
                break;
            case R.id.fabDatePicker:
                Snackbar.make(v, "date", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                presenter.closeFab();
                break;
            case R.id.fabDone:
                Snackbar.make(v, "done", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                presenter.closeFab();
                break;
        }
    }


    public void openFab() {
        Animation fabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        Animation rotateForward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_rotate_forward);
        fab.startAnimation(rotateForward);
        fabColorPicker.startAnimation(fabOpen);
        fabDatePicker.startAnimation(fabOpen);
        fabDone.startAnimation(fabOpen);
    }

    public void closeFab() {
        Animation fabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        Animation rotateBack = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_rotate_back);

        fab.startAnimation(rotateBack);
        fabColorPicker.startAnimation(fabClose);
        fabDatePicker.startAnimation(fabClose);
        fabDone.startAnimation(fabClose);

    }
    public void setOnClickListeners() {
        fab.setOnClickListener(this);
        fabColorPicker.setOnClickListener(this);
        fabDatePicker.setOnClickListener(this);
        fabDone.setOnClickListener(this);
    }

    public void handleEditTexts() {
        setTextWatchers(noteTitle);
        setTextWatchers(noteDescription);
    }

    private void setTextWatchers(EditText et) {
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.closeFab();
            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.textHasBeenEdited();
            }
        });
    }

    public void displayNoteNotSavedAlert() {
        notesNotSavedDialog = new MaterialDialog.Builder(this)
                .title(getString(R.string.Not_Saved_Title))
                .content(getString(R.string.Not_Saved_Content))
                .positiveText(getString(R.string.Not_Saved_Positive))
                .negativeText(getString(R.string.Not_Saved_Negative))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        presenter.finish();
                    }
                })
                .build();
        notesNotSavedDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_BACK) {
                    notesNotSavedDialog.dismiss();
                    finish();
                }
                return true;
            }
        });
        notesNotSavedDialog.show();

    }



}
