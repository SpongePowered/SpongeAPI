/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.plugin.config;

/**
 * Represents an array in a config
 */
public interface ConfigArray<T> extends ConfigElement<T[]>, Iterable<T> {
    
    /**
     * Gets the element at the specified index.
     * 
     * @param index
     * @return
     */
    T getElement(int index);
    
    /**
     * Adds the object to the end of this array.
     * 
     * @param object
     */
    void add(T object);
    
    /**
     * Inserts the object at the index
     * 
     * @param object
     * @param index
     */
    void add(T object, int index);
    
    /**
     * Removes the first instance of the element
     * 
     * @param object
     */
    void remove(T object);
    
    /**
     * Removes the element at the index
     * 
     * @param index
     */
    void remove(int index);
    
    /**
     * Removes all instances of the element
     * 
     * @param object The element
     */
    void removeAll(T object);
    
    /**
     * Removes all elements in this array.
     */
    void clear();
    
    /**
     * Checks if this array contains the specified object.
     * 
     * @param object
     * @return True if yes, False if no.
     */
    boolean contains(T object);
    
    /**
     * Gets the index of the object.
     * 
     * @param object
     * @return The index
     */
    int getIndexOf(T object);
}
