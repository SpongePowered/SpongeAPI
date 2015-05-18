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

import org.spongepowered.api.data.Component;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataQuery;

/**
 * A token is a key to a value of information that a {@link DataHolder}
 * is carrying. All values that are contained in {@link Component}s
 * can be tokenized such that the underlying values can be easily retrieved
 * by {@link DataHolder#get(GetterToken)} bypassing the necessity of retrieving
 * the {@link Component} and getting the value from the component.
 *
 * {@link BaseToken} should not be used as it is a marker interface for the
 * base of {@link GetterToken}, {@link SetterToken}, and {@link Token}. It
 * should be noted that while {@link Token} is excellent at marking a piece of
 * information as mutable, the recommended use of tokens are for simple
 * access to single information.
 *
 * @param <V> The type of value
 */
public interface BaseToken<V> {

    /**
     * Gets the value class.
     *
     * @return The value class
     */
    Class<V> getValueClass();

    /**
     * Gets the component related class that this token originates from.
     *
     * @return The component class
     */
    Class<Component<?>> getComponentClass();

    /**
     * Gets the usable {@link DataQuery} for this {@link BaseToken}. The
     * {@link DataQuery} can be used from {@link DataContainer}s that are
     * generated from {@link Component}s.
     *
     * @return The default data query used to store and retrieve values
     */
    DataQuery getQuery();

}
