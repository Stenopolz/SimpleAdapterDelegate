package com.stenopolz.adapterdelegate.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stenopolz.adapterdelegate.R;
import com.stenopolz.adapterdelegate.models.Colored;
import com.stenopolz.simpleadapterdelegate.BaseAdapterDelegate;

/**
 * Created by Pavel Shchors on 16.03.2016.
 * <p/>
 * Adapter delegate for red
 */
public class ColoredAdapterDelegate extends BaseAdapterDelegate<Colored, ColoredAdapterDelegate.ColoredViewHolder> {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new ColoredViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_colored, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Colored dataObject, @NonNull ColoredViewHolder viewHolder) {
        viewHolder.itemView.setBackgroundColor(dataObject.getColor());
    }

    protected static class ColoredViewHolder extends RecyclerView.ViewHolder {

        public ColoredViewHolder(View itemView) {
            super(itemView);
        }
    }
}
