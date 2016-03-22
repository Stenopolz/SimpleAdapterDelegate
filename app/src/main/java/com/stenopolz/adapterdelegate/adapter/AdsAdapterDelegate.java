package com.stenopolz.adapterdelegate.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stenopolz.adapterdelegate.R;
import com.stenopolz.adapterdelegate.models.Ads;
import com.stenopolz.simpleadapterdelegate.BaseAdapterDelegate;

/**
 * Created by Pavel Shchors on 16.03.2016.
 * <p/>
 * Adapter delegate for ads
 */
public class AdsAdapterDelegate extends BaseAdapterDelegate<Ads, AdsAdapterDelegate.AdsViewHolder> {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new AdsViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_ads, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Ads dataObject, @NonNull AdsViewHolder viewHolder) {
        viewHolder.label.setText(dataObject.getAdvertisement());
    }

    protected static class AdsViewHolder extends RecyclerView.ViewHolder {

        public TextView label;

        public AdsViewHolder(@NonNull View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.item_ads_label);
        }
    }
}
