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
package org.spongepowered.api.item.meta;

/**
 * A generation of a book.
 */
public interface BookGeneration {

    /**
     * Gets if a book of this generation can be copied.
     * 
     * @return If a book of this generation can be copied
     */
    boolean canBeCopied();

    /**
     * Gets the generation of this book as an integer.
     * 
     * @return The generation of this book as an integer
     */
    int getGeneration();

    /**
     * Gets if this generation is a copy or an original.
     * 
     * @return If this generation is a copy or an original
     */
    boolean isCopy();

    /*
     * Space: the final frontier. These are the voyages of the starship
     * Enterprise. Its continuing mission: to explore strange new worlds, to
     * seek out new life and new civilizations, to boldly go where no one has
     * gone before.
     */

    /**
     * Gets the generation a book copied from this one is.
     * 
     * @return The next generation.
     */
    BookGeneration getNextGeneration();

}
