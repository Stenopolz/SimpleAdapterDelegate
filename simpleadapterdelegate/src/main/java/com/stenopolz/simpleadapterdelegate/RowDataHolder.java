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

/**
 * Created by Pavel Shchors on 16.03.2016.
 *
 * Data holder for objects to be displayed with the help of adapter delegates
 */
public class RowDataHolder<T> {

    @NonNull
    private T dataObject;
    private int viewType;

    /**
     * Default constructor.
     *
     * @param dataObject data object to be hold
     * @param viewType   type of the view which should display enclosed data
     */
    public RowDataHolder(@NonNull T dataObject, int viewType) {
        this.dataObject = dataObject;
        this.viewType = viewType;
    }

    /**
     * @return enclosed data object
     */
    @NonNull
    public T getDataObject() {
        return dataObject;
    }

    /**
     * @return view type
     */
    public int getViewType() {
        return viewType;
    }
}
