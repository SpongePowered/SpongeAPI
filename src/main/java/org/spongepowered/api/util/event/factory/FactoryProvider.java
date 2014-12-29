/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.util.event.factory;

/**
 * Creates event factories that can generate new instances of requested
 * events.
 */
public interface FactoryProvider {

    /**
     * Get whether there should be any checks on whether a parameter is
     * null when it should not be.
     *
     * @return The null policy
     */
    NullPolicy getNullPolicy();

    /**
     * Set whether there should be any checks on whether a parameter is
     * null when it should not be.
     *
     * @param policy The null policy
     */
    void setNullPolicy(NullPolicy policy);

    /**
     * Creates a function that takes a map of property names with their
     * values to create a new instance of a generated class that implements
     * the given type.
     *
     * @param type The type to generate a class for
     * @param parentType The parent type
     * @param <T> The type of the event
     * @return The function
     */
    <T> EventFactory<T> create(Class<T> type, Class<?> parentType);

}
