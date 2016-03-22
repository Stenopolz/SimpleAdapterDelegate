package com.stenopolz.adapterdelegate.models;

import android.graphics.Color;
import android.support.annotation.ColorInt;

/**
 * Created by Stenopolz on 16.03.2016.
 * <p/>
 * Model for green color
 */
public class Green implements Colored {

    @Override
    @ColorInt
    public int getColor() {
        return Color.GREEN;
    }
}
