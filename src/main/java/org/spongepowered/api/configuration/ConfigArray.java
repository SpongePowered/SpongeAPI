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
package org.spongepowered.api.configuration;

/**
 * Represents an array in a config.
 */
public interface ConfigArray<T> extends ConfigElement<T[]>, Iterable<T> {

    /**
     * Gets the element at the specified index.
     * 
     * @param index The index number
     * @return The element
     */
    T getElement(int index);

    /**
     * Adds the object to the end of this array.
     * 
     * @param object The object to add
     */
    void add(T object);

    /**
     * Inserts the object at the index.
     * 
     * @param object The object to add
     * @param index The index to add it at
     */
    void add(T object, int index);

    /**
     * Adds all items to the element.
     * 
     * @param objects The objects to add
     */
    void addAll(T... objects);

    /**
     * Removes the first instance of the element.
     * 
     * @param object The object to remove
     */
    void remove(T object);

    /**
     * Removes the element at the index.
     * 
     * @param index The index to remove
     */
    void remove(int index);

    /**
     * Removes all elements in this array.
     */
    void clear();

    /**
     * Checks if this array contains the specified object.
     * 
     * @param object The object to check for
     * @return True if yes, false if no.
     */
    boolean contains(T object);

    /**
     * Gets the index of the object.
     * 
     * @param object The object to check
     * @return The index or -1 if it doesn't exist
     */
    int getIndexOf(T object);
}
