package bfergus.to_dolist;

import android.app.Application;

public class GoDoListApplication extends Application {
    private static GoDoListApplication sInstance;

    public GoDoListApplication() {sInstance = this;}
    public static synchronized  GoDoListApplication getInstance() {return sInstance;}
}
