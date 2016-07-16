package bfergus.to_dolist.Utils;

import android.support.v4.content.ContextCompat;

import bfergus.to_dolist.Enums.NoteColor;
import bfergus.to_dolist.GoDoListApplication;
import bfergus.to_dolist.R;

public class ConvertNoteColors {

    public static int noteColorToIntValue(NoteColor color) {
        switch(color) {
            case RED:
                return ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_red);
            case BLUE:
                return ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_blue);
            case PURPLE:
                return ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_purple);
            case GREEN:
                return ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_green);
            case YELLOW:
                return ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_yellow);
            case BROWN:
                return ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_brown);
            case ORANGE:
                return ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_orange);
            case WHITE:
                return ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_white);
            default:
                return -1; //white
        }
    }
    public static NoteColor intValueToNoteColor(int color) {
        if (color == ContextCompat.getColor(GoDoListApplication.getInstance(),R.color.edit_text_red)) return NoteColor.RED;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(),R.color.edit_text_blue)) return NoteColor.BLUE;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_purple)) return NoteColor.PURPLE;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_green)) return NoteColor.GREEN;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_yellow)) return NoteColor.YELLOW;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(),R.color.edit_text_brown)) return  NoteColor.BROWN;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_orange)) return NoteColor.ORANGE;
        else return NoteColor.WHITE;
    }

    public static String noteColorToString(NoteColor color) {
        switch(color){
            case RED:
                return"RED";
            case BLUE:
                return "BLUE";
            case PURPLE:
                return "PURPLE";
            case GREEN:
                return "GREEN";
            case YELLOW:
                return "YELLOW";
            case BROWN:
                return "BROWN";
            case ORANGE:
                return"ORANGE";
            case WHITE:
                return "WHITE";
            default:
                return"WHITE";
        }
    }
}

