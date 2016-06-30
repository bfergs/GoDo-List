package bfergus.to_dolist.Utils;

import android.support.v4.content.ContextCompat;

import bfergus.to_dolist.Enums.PaintColor;
import bfergus.to_dolist.GoDoListApplication;
import bfergus.to_dolist.R;

public class ConvertPaintColors {

    public static int getIntValueFromPaintColor(PaintColor color) {
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
    public static PaintColor getPaintColorFromIntValue(int color) {
        if (color == ContextCompat.getColor(GoDoListApplication.getInstance(),R.color.edit_text_red)) return PaintColor.RED;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(),R.color.edit_text_blue)) return PaintColor.BLUE;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_purple)) return PaintColor.PURPLE;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_green)) return PaintColor.GREEN;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_yellow)) return PaintColor.YELLOW;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(),R.color.edit_text_brown)) return  PaintColor.BROWN;
        else if(color == ContextCompat.getColor(GoDoListApplication.getInstance(), R.color.edit_text_orange)) return PaintColor.ORANGE;
        else return PaintColor.WHITE;
    }
}

