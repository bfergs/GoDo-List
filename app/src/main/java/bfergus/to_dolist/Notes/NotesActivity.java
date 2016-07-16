package bfergus.to_dolist.Notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bfergus.to_dolist.Enums.NoteColor;
import bfergus.to_dolist.R;
import bfergus.to_dolist.Utils.ConvertNoteColors;
import butterknife.Bind;
import butterknife.ButterKnife;


public class NotesActivity extends AppCompatActivity  implements NotesView, View.OnClickListener{
    NotesPresenter presenter;

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

    @Bind(R.id.red_color_button)
    Button redColorButton;

    @Bind(R.id.purple_color_button)
    Button purpleColorButton;

    @Bind(R.id.blue_color_button)
    Button blueColorButton;

    @Bind(R.id.green_color_button)
    Button greenColorButton;

    @Bind(R.id.yellow_color_button)
    Button yellowColorButton;

    @Bind(R.id.orange_color_button)
    Button orangeColorButton;

    @Bind(R.id.brown_color_button)
    Button brownColorButton;

    @Bind(R.id.white_color_button)
    Button whiteColorButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ButterKnife.bind(this);
        presenter = new NotesPresenterImpl(this);
        presenter.onCreate();
        setSupportActionBar(toolbar);
        if(savedInstanceState!= null) {
            presenter.changeNoteColor(ConvertNoteColors.intValueToNoteColor(savedInstanceState.getInt("currentColor")));
        }
    }

    @Override
    public void onBackPressed() {
        presenter.onBackPressed();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("currentColor",presenter.getCurrentColor());
    }

    public void endActivity(boolean noteEdited) {
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
                startActivity(new Intent(this, SchedulingActivity.class));
                presenter.closeFab();
                break;
            case R.id.fabDone:
                Snackbar.make(v, "done", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                presenter.closeFab();
                break;
            case R.id.red_color_button:
                presenter.changeNoteColor(NoteColor.RED);
                presenter.closePaintButtons();
                break;
            case R.id.blue_color_button:
                presenter.changeNoteColor(NoteColor.BLUE);
                presenter.closePaintButtons();
                break;
            case R.id.yellow_color_button:
                presenter.changeNoteColor(NoteColor.YELLOW);
                presenter.closePaintButtons();
                break;
            case R.id.purple_color_button:
                presenter.changeNoteColor(NoteColor.PURPLE);
                presenter.closePaintButtons();
                break;
            case R.id.green_color_button:
                presenter.changeNoteColor(NoteColor.GREEN);
                presenter.closePaintButtons();
                break;
            case R.id.orange_color_button:
                presenter.changeNoteColor(NoteColor.ORANGE);
                presenter.closePaintButtons();
                break;
            case R.id.brown_color_button:
                presenter.changeNoteColor(NoteColor.BROWN);
                presenter.closePaintButtons();
                break;
            case R.id.white_color_button:
                presenter.changeNoteColor(NoteColor.WHITE);
                presenter.closePaintButtons();
                break;
        }
    }

    public void changeBackgroundColor(int color) {
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
       redColorButton.setEnabled(status);
       blueColorButton.setEnabled(status);
       purpleColorButton.setEnabled(status);
       greenColorButton.setEnabled(status);
       brownColorButton.setEnabled(status);
       orangeColorButton.setEnabled(status);
       whiteColorButton.setEnabled(status);
       yellowColorButton.setEnabled(status);
   }

    public void openPaintButtons() {
        Animation paintOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.paint_buttons_open);
        startPaintButtonAnimations(paintOpen, redColorButton);
        startPaintButtonAnimations(paintOpen, blueColorButton);
        startPaintButtonAnimations(paintOpen, greenColorButton);
        startPaintButtonAnimations(paintOpen, brownColorButton);
        startPaintButtonAnimations(paintOpen, orangeColorButton);
        startPaintButtonAnimations(paintOpen, purpleColorButton);
        startPaintButtonAnimations(paintOpen, whiteColorButton);
        startPaintButtonAnimations(paintOpen, yellowColorButton);
    }

    public void closePaintButtons() {
        Animation paintClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.paint_buttons_close);
        startPaintButtonAnimations(paintClose, redColorButton);
        startPaintButtonAnimations(paintClose, blueColorButton);
        startPaintButtonAnimations(paintClose, greenColorButton);
        startPaintButtonAnimations(paintClose, brownColorButton);
        startPaintButtonAnimations(paintClose, orangeColorButton);
        startPaintButtonAnimations(paintClose, purpleColorButton);
        startPaintButtonAnimations(paintClose, whiteColorButton);
        startPaintButtonAnimations(paintClose, yellowColorButton);

    }

    private void startPaintButtonAnimations(Animation anim, Button bt) {
        bt.startAnimation(anim);
    }

    private void startFabAnimations(Animation anim, FloatingActionButton fab) {
        fab.startAnimation(anim);
    }
    public void initializeClickListeners() {
        fab.setOnClickListener(this);
        fabColorPicker.setOnClickListener(this);
        fabDatePicker.setOnClickListener(this);
        fabDone.setOnClickListener(this);
        redColorButton.setOnClickListener(this);
        blueColorButton.setOnClickListener(this);
        greenColorButton.setOnClickListener(this);
        brownColorButton.setOnClickListener(this);
        orangeColorButton.setOnClickListener(this);
        purpleColorButton.setOnClickListener(this);
        whiteColorButton.setOnClickListener(this);
        yellowColorButton.setOnClickListener(this);
    }

    public void initializeEditTexts() {
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

    public void displayNoteNotSavedMessage() {
        Toast toast = Toast.makeText(this, getText(R.string.Not_Saved), Toast.LENGTH_SHORT);
        toast.show();
    }
}
