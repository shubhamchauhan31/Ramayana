package com.example.ramayan.apptheme;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

import com.example.ramayan.R;

public class Utils {
    private static int sTheme;
    public final static int DARK_THEME = 0;
    public final static int APP_THEME = 1;
    public final static int THEME_BLUE = 2;
    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }
    /** Set the theme of the activity, according to the configuration. */
    @SuppressLint("ResourceType")
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case DARK_THEME:
                activity.setTheme(R.color.black);
                break;
            case APP_THEME:
                activity.setTheme(R.color.purple_500);

                break;
        }
    }
}
