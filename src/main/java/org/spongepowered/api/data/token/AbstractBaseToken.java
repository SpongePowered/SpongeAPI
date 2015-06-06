/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.data.token;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.data.Component;
import org.spongepowered.api.data.DataQuery;

public abstract class AbstractBaseToken<V> implements BaseToken<V> {

    private final Class<V> valueClass;
    private final Class<Component<?>> componentClass;
    private final DataQuery query;


    protected AbstractBaseToken(Class<V> valueClass, Class<Component<?>> componentClass, DataQuery query) {
        this.valueClass = checkNotNull(valueClass);
        this.componentClass = checkNotNull(componentClass);
        this.query = checkNotNull(query);
    }

    @Override
    public Class<V> getValueClass() {
        return this.valueClass;
    }

    @Override
    public Class<Component<?>> getComponentClass() {
        return this.componentClass;
    }

    @Override
    public DataQuery getQuery() {
        return this.query;
    }
}
