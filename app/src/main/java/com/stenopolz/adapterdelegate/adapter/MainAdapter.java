package com.stenopolz.adapterdelegate.adapter;

import android.support.annotation.NonNull;

import com.stenopolz.adapterdelegate.models.Ads;
import com.stenopolz.adapterdelegate.models.Colored;
import com.stenopolz.adapterdelegate.models.Header;
import com.stenopolz.simpleadapterdelegate.BaseDelegateAdapter;
import com.stenopolz.simpleadapterdelegate.RowDataHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Shchors on 16.03.2016.
 * <p/>
 * Main adapter
 */
public class MainAdapter extends BaseDelegateAdapter {

    private static int COLORED_TYPE = 0;
    private static int ADS_TYPE = 1;
    private static int HEADER_TYPE = 2;

    public MainAdapter() {
        addDelegate(new ColoredAdapterDelegate(), COLORED_TYPE);
        addDelegate(new HeaderAdapterDelegate(), HEADER_TYPE);
        addDelegate(new AdsAdapterDelegate(), ADS_TYPE);
    }

    /**
     * Sets data to the adapter
     */
    @SuppressWarnings("unchecked")
    public void setData(@NonNull List<Colored> coloredList, @NonNull Ads ads, @NonNull Header header) {
        List<RowDataHolder> rowDataHolders = new ArrayList<>();
        rowDataHolders.add(new RowDataHolder(header, HEADER_TYPE));
        int adsCounter = 0;
        for (Colored colored : coloredList) {
            rowDataHolders.add(new RowDataHolder(colored, COLORED_TYPE));
            if (adsCounter == 3) {
                rowDataHolders.add(new RowDataHolder(ads, ADS_TYPE));
                adsCounter = 0;
            } else {
                adsCounter++;
            }
        }
        setRowDataHolders(rowDataHolders);
    }
}
