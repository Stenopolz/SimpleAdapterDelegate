package com.stenopolz.adapterdelegate.models;

import android.graphics.Color;
import android.support.annotation.ColorInt;

/**
 * Created by Stenopolz on 16.03.2016.
 * <p/>
 * model for red color
 */
public class Red implements Colored {

    @Override
    @ColorInt
    public int getColor() {
        return Color.RED;
    }
}
