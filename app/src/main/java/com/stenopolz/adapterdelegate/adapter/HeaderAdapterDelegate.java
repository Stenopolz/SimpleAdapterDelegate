package com.stenopolz.adapterdelegate.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stenopolz.adapterdelegate.R;
import com.stenopolz.adapterdelegate.models.Header;
import com.stenopolz.simpleadapterdelegate.BaseAdapterDelegate;

/**
 * Created by Pavel Shchors on 16.03.2016.
 * <p/>
 * Adapter delegate for header
 */
public class HeaderAdapterDelegate extends BaseAdapterDelegate<Header, HeaderAdapterDelegate.HeaderViewHolder> {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        return new HeaderViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_header, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Header dataObject, @NonNull HeaderViewHolder viewHolder) {
        viewHolder.title.setText(dataObject.getTitle());
    }

    protected static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public TextView title;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_header_title);
        }
    }
}
