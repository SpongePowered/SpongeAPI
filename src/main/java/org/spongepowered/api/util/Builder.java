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
package org.spongepowered.api.util;

/**
 * Base interface for creating a Builder.<br/>
 * <h1>Usage:</h1> <br/>
 * A Builder is used by creating an interface extending it.
 * 
 * @param B The builder type, usually the implementing class
 * @param T The type this builder is building
 */
public interface Builder<B extends Builder<B, T>, T> {

    /**
     * Builds the object.
     * 
     * @return The object built
     */
    T build();

    /**
     * Gets the object at the given index.
     * 
     * @param index The index of the object, starting at 0
     * @return The object at the given index.
     */
    T getObjectAt(int index);
    
    /**
     * Gets an iterable list of objects in this builder.
     * 
     * @return An iterable list.
     */
    Iterable<T> iterate();

    /**
     * Appends the object at the current index.
     * 
     * @param t
     * @return This object
     */
    B append(T t);
    
    /**
     * Sets the next Object to be inserted at the given index.
     * 
     * @param index The index of the object, starting at 0
     * @return This instance
     */
    B setIndex(int index);
    
    /**
     * Moves the index the given amount.
     * 
     * @param index
     * @return
     */
    B moveIndex(int move);
    
    /**
     * Gets the index the next object will be inserted at.
     * 
     * @return
     */
    int getIndex();
    
    /**
     * Sets the next object to be inserted at the end.
     * 
     * @return This instance
     */
    B setIndexLast();
    
    /**
     * Sets the next object to be inserted at the beginning.
     * 
     * @return This instance
     */
    B setIndexZero();
}
