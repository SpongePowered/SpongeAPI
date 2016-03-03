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

package org.spongepowered.api.item.inventory;

import org.spongepowered.api.ItemDictionary;
import org.spongepowered.api.data.ImmutableDataHolder;
import org.spongepowered.api.item.ItemType;

/**
 * Represents a snapshot of an {@link ItemStack} as an
 * {@link ImmutableDataHolder} to represent all of the data associated with
 * the {@link ItemStack} of which the snapshot was created from. Being that
 * it is a snapshot, a snapshot cannot be modified, but modifications will
 * result in a new instance of the {@link ItemStackSnapshot}.
 */
public interface ItemStackSnapshot extends ImmutableDataHolder<ItemStackSnapshot> {

    ItemStackSnapshot NONE = null;

    /**
     * Gets the {@link ItemType} of this {@link ItemStackSnapshot}. The
     * {@link ItemType} is always available.
     *
     * @return The item type
     */
    ItemType getType();

    /**
     * Gets the current stack size count of the {@link ItemStack} this
     * {@link ItemStackSnapshot} is representing.
     *
     * @return The current stack size
     */
    int getCount();

    /**
     * Creates a new {@link ItemStack} with all the data currently available
     * on this {@link ItemStackSnapshot}.
     *
     * @return The newly generated item stack
     */
    ItemStack createStack();

    /**
     * Creates a {@link ItemDictionary.Entry} that compares stacks to this
     * {@link ItemStackSnapshot}. Note that not all data stored in this
     * {@link ItemStackSnapshot} may be stored in the returned entry.
     * 
     * @return A {@link ItemDictionary.Entry} based on this
     * {@link ItemStackSnapshot}
     */
    ItemDictionary.Entry createGameDictionaryEntry();

}
