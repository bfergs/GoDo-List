package bfergus.to_dolist.Notes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import bfergus.to_dolist.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class NotesActivity extends AppCompatActivity  implements NotesView, View.OnClickListener{
    NotesPresenter presenter;

    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Bind(R.id.fabColorPicker)
    FloatingActionButton fabColorPicker;

    @Bind(R.id.fabDatePicker)
    FloatingActionButton fabDatePicker;

    @Bind(R.id.fabDone)
    FloatingActionButton fabDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        ButterKnife.bind(this);

        presenter = new NotesPresenterImpl(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setOnClickListenters();

    }

    private void setOnClickListenters() {
        fab.setOnClickListener(this);
        fabColorPicker.setOnClickListener(this);
        fabDatePicker.setOnClickListener(this);
        fabDone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id) {
            case R.id.fab:
                presenter.animateFab();
                System.out.println("hello");
                break;
            case R.id.fabColorPicker:
                Snackbar.make(v, "color", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
            case R.id.fabDatePicker:
                Snackbar.make(v, "date", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
            case R.id.fabDone:
                Snackbar.make(v, "done", Snackbar.LENGTH_LONG).setAction("Action", null).show();
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



}
