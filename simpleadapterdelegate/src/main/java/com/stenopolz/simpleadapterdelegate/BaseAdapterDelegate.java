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
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Pavel Shchors on 16.03.2016.
 *
 * Adapter delegate
 */
public abstract class BaseAdapterDelegate<ObjectType, ViewHolderType extends RecyclerView.ViewHolder> {

    /**
     * Called to create viewHolder
     *
     * @param parent ViewGroup to which our view will be added
     * @return subclass of {@link }
     */
    @NonNull
    public abstract RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent);

    /**
     * Called to bind data to the view holder. Type casting is up to you.
     * No checks are provided when calling this method.
     *
     * @param dataObject data to be bind to the view holder
     * @param viewHolder viewHolder object
     */
    public abstract void onBindViewHolder(@NonNull ObjectType dataObject, @NonNull ViewHolderType viewHolder);
}
