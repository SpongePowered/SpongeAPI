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
package org.spongepowered.api.item.data;

/**
 * Represents an item that can be cloned or copied.
 *
 * <p>Some items can be cloned or copied with crafting.</p>
 *
 * <p>Some items may prevent further cloning after a specified generation.</p>
 */
public interface CloneableData extends ItemData<CloneableData> {

    /**
     * Gets the generation of this cloneable item.
     *
     * <p>The original always starts as generation 0.</p>
     *
     * @return The generation of the cloneable item
     */
    int getGeneration();

    /**
     * Sets the generation of this cloneable item.
     *
     * <p>The original always starts as generation 0.</p>
     *
     * @param generation The generation of this item
     */
    void setGeneration(int generation);

    /**
     * Gets the generational limit to which the item would no longer
     * be cloneable by normal means.
     *
     * @return The generational limit
     */
    int getGenerationLimit();

}
