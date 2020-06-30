package com.cass.livedataviewmodeldatabinding;

import android.content.res.Resources;
import android.util.DisplayMetrics;

public class PixUtils {

    public static int dp2px(int dpValue) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return (int) (metrics.density * dpValue + 0.5f);
    }

    public static int getScreenWidth() {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return metrics.widthPixels;
    }

    public static int getScreenHeight() {
        DisplayMetrics metrics =Resources.getSystem().getDisplayMetrics();
        return metrics.heightPixels;
    }
}
