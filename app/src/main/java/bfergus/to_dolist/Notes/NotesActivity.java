package bfergus.to_dolist.Notes;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
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

    @Bind(R.id.red_paint_button)
    Button redPaintButton;

    @Bind(R.id.purple_paint_button)
    Button purplePaintButton;

    @Bind(R.id.blue_paint_button)
    Button bluePaintButton;

    @Bind(R.id.green_paint_button)
    Button greenPaintButton;

    @Bind(R.id.yellow_paint_button)
    Button yellowPaintButton;

    @Bind(R.id.orange_paint_button)
    Button orangePaintButton;

    @Bind(R.id.brown_paint_button)
    Button brownPaintButton;

    @Bind(R.id.white_paint_button)
    Button whitePaintButton;



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
        presenter.closePaintButtons();
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.fab:
                presenter.animateFab();
                presenter.closePaintButtons();
                break;
            case R.id.fabColorPicker:
                presenter.animatePaintButtons();
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
            case R.id.red_paint_button:
                presenter.changeEditTextColor(ContextCompat.getColor(this,R.color.edit_text_red));
                presenter.closePaintButtons();
                break;
            case R.id.blue_paint_button:
                presenter.changeEditTextColor(ContextCompat.getColor(this,R.color.edit_text_blue));
                presenter.closePaintButtons();
                break;
            case R.id.yellow_paint_button:
                presenter.changeEditTextColor(ContextCompat.getColor(this,R.color.edit_text_yellow));
                presenter.closePaintButtons();
                break;
            case R.id.purple_paint_button:
                presenter.changeEditTextColor(ContextCompat.getColor(this,R.color.edit_text_purple));
                presenter.closePaintButtons();
                break;
            case R.id.green_paint_button:
                presenter.changeEditTextColor(ContextCompat.getColor(this,R.color.edit_text_green));
                presenter.closePaintButtons();
                break;
            case R.id.orange_paint_button:
                presenter.changeEditTextColor(ContextCompat.getColor(this,R.color.edit_text_orange));
                presenter.closePaintButtons();
                break;
            case R.id.brown_paint_button:
                presenter.changeEditTextColor(ContextCompat.getColor(this,R.color.edit_text_brown));
                presenter.closePaintButtons();
                break;
            case R.id.white_paint_button:
                presenter.changeEditTextColor(ContextCompat.getColor(this,R.color.edit_text_white));
                presenter.closePaintButtons();
                break;
        }
    }

    public void changeEditTextColor(int color) {
        View root = fab.getRootView();
        System.out.println(color);
        root.setBackgroundColor(color);

    }

    public void openFab() {
        Animation fabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        Animation rotateForward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_rotate_forward);

        startFabAnimations(rotateForward, fab);
        startFabAnimations(fabOpen, fabColorPicker);
        startFabAnimations(fabOpen, fabDatePicker);
        startFabAnimations(fabOpen, fabDone);
    }

    public void closeFab() {
        Animation fabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        Animation rotateBack = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate_back);

        startFabAnimations(rotateBack, fab);
        startFabAnimations(fabClose, fabColorPicker);
        startFabAnimations(fabClose, fabDatePicker);
        startFabAnimations(fabClose, fabDone);
    }


    public void changeSubFabEnabledStatus(Boolean status) {
        fabColorPicker.setEnabled(status);
        fabDatePicker.setEnabled(status);
        fabDone.setEnabled(status);
    }

   public void changePaintButtonsEnabledStatus(Boolean status) {
       redPaintButton.setEnabled(status);
       bluePaintButton.setEnabled(status);
       purplePaintButton.setEnabled(status);
       greenPaintButton.setEnabled(status);
       brownPaintButton.setEnabled(status);
       orangePaintButton.setEnabled(status);
       whitePaintButton.setEnabled(status);
       yellowPaintButton.setEnabled(status);
   }

    public void openPaintButtons() {
        Animation paintOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.paint_buttons_open);
        startPaintButtonAnimations(paintOpen, redPaintButton);
        startPaintButtonAnimations(paintOpen, bluePaintButton);
        startPaintButtonAnimations(paintOpen, greenPaintButton);
        startPaintButtonAnimations(paintOpen, brownPaintButton);
        startPaintButtonAnimations(paintOpen, orangePaintButton);
        startPaintButtonAnimations(paintOpen, purplePaintButton);
        startPaintButtonAnimations(paintOpen, whitePaintButton);
        startPaintButtonAnimations(paintOpen, yellowPaintButton);
    }

    public void closePaintButtons() {
        Animation paintClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.paint_buttons_close);
        startPaintButtonAnimations(paintClose, redPaintButton);
        startPaintButtonAnimations(paintClose, bluePaintButton);
        startPaintButtonAnimations(paintClose, greenPaintButton);
        startPaintButtonAnimations(paintClose, brownPaintButton);
        startPaintButtonAnimations(paintClose, orangePaintButton);
        startPaintButtonAnimations(paintClose, purplePaintButton);
        startPaintButtonAnimations(paintClose, whitePaintButton);
        startPaintButtonAnimations(paintClose, yellowPaintButton);

    }

    private void startPaintButtonAnimations(Animation anim, Button bt) {
        bt.startAnimation(anim);
    }

    private void startFabAnimations(Animation anim, FloatingActionButton fab) {
        fab.startAnimation(anim);
    }
    public void setOnClickListeners() {
        fab.setOnClickListener(this);
        fabColorPicker.setOnClickListener(this);
        fabDatePicker.setOnClickListener(this);
        fabDone.setOnClickListener(this);
        redPaintButton.setOnClickListener(this);
        bluePaintButton.setOnClickListener(this);
        greenPaintButton.setOnClickListener(this);
        brownPaintButton.setOnClickListener(this);
        orangePaintButton.setOnClickListener(this);
        purplePaintButton.setOnClickListener(this);
        whitePaintButton.setOnClickListener(this);
        yellowPaintButton.setOnClickListener(this);
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
                presenter.closePaintButtons();
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
