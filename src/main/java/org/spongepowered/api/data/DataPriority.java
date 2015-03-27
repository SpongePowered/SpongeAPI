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

package org.spongepowered.api.data;

/**
 * A data priority enum. When merging existing data from a {@link
 * DataHolder} and a {@link DataManipulator}, the priority defines which
 * data to retain, and or, merge.
 */
public enum DataPriority {
    /**
     * The data residing in the {@link DataHolder} should be retained,
     * ignoring all overlapping data from thie owning {@link
     * DataManipulator}.
     */
    DATA_HOLDER,
    /**
     * The data residing in the {@link DataManipulator} should be retained,
     * all overlapping data from the {@link DataHolder} is overwritten.
     */
    DATA_MANIPULATOR,
    /**
     * All overlapping data from the {@link DataManipulator} will be
     * added before the overlapping data existing from the {@link
     * DataHolder}. Examples may include prefixing display names,
     * adding enchantments at the beginning of an enchantment list, etc.
     */
    PRE_MERGE,
    /**
     * All overlapping data from the {@link DataManipulator} will be
     * added after the overlapping data existing from the {@link
     * DataHolder}. Examples may include suffixing display names,
     * adding enchantments at the end of an enchantment list, etc.
     */
    POST_MERGE,
    ;
}
