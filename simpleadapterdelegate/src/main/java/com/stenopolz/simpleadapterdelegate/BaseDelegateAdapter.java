/*
 * Copyright (c) 2016 Pavel Shchors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.stenopolz.simpleadapterdelegate;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Shchors on 16.03.2016.
 * <p/>
 * Base adapter to use with adapter delegates
 */
public abstract class BaseDelegateAdapter extends RecyclerView.Adapter {

    @NonNull
    private final SparseArrayCompat<BaseAdapterDelegate> delegates = new SparseArrayCompat<>();
    @NonNull
    private List<RowDataHolder> rowDataHolders = new ArrayList<>();

    /**
     * Call it to set data to be displayed
     *
     * @param rowDataHolders list of {@link RowDataHolder}
     */
    protected void setRowDataHolders(@NonNull List<RowDataHolder> rowDataHolders) {
        this.rowDataHolders = rowDataHolders;
        notifyDataSetChanged();
    }

    /**
     * Call it to add delegate for specified view type. It replaces previous delegate if any exists.
     *
     * @param delegate delegate to be added
     * @param viewType view type of the delegate
     */
    protected void addDelegate(@NonNull BaseAdapterDelegate delegate, int viewType) {
        delegates.append(viewType, delegate);
    }

    /**
     * Call it to remove adapter delegate for specified viewType
     *
     * @param viewType view type of the delegate
     */
    protected void removeDelegate(int viewType) {
        delegates.remove(viewType);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getDelegateForViewType(viewType).onCreateViewHolder(parent);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        getDelegateForViewType(holder.getItemViewType())
                .onBindViewHolder(rowDataHolders.get(position).getDataObject(), holder);
    }

    @Override
    public int getItemViewType(int position) {
        return rowDataHolders.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return rowDataHolders.size();
    }

    @NonNull
    private BaseAdapterDelegate getDelegateForViewType(int viewType) {
        BaseAdapterDelegate delegate = delegates.get(viewType, null);
        if (delegate == null) {
            throw new IllegalStateException("No adapter delegate provided for viewType " + viewType);
        }
        return delegate;
    }
}
