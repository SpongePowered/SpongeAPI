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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.SerializableDataHolder;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.translation.Translatable;

/**
 * Represents a snapshot of an {@link ItemStack} as an
 * {@link org.spongepowered.api.data.DataHolder.Immutable} to represent all of the data associated with
 * the {@link ItemStack} of which the snapshot was created from. Being that
 * it is a snapshot, a snapshot cannot be modified, but modifications will
 * result in a new instance of the {@link ItemStackSnapshot}.
 */
public interface ItemStackSnapshot extends SerializableDataHolder.Immutable<ItemStackSnapshot>, Translatable {

    /**
     * Gets a empty {@link ItemStackSnapshot}.
     *
     * @return The empty item stack snapshot
     */
    static ItemStackSnapshot empty() {
        return Sponge.getRegistry().requireFactory(Factory.class).empty();
    }

    /**
     * Gets the {@link ItemType} of this {@link ItemStackSnapshot}. The
     * {@link ItemType} is always available.
     *
     * @return The item type
     */
    ItemType getType();

    /**
     * Gets the quantity of items in this the {@link ItemStack} this
     * {@link ItemStackSnapshot} is representing.
     *
     * @return The current stack size
     */
    int getQuantity();

    /**
     * Returns true if {@link #getQuantity()} is zero and therefore this
     * ItemStackSnapshot is empty.
     *
     * @return True if this ItemStackSnapshot is empty
     */
    boolean isEmpty();

    /**
     * Creates a new {@link ItemStack} with all the data currently available
     * on this {@link ItemStackSnapshot}.
     *
     * @return The newly generated item stack
     */
    ItemStack createStack();

    interface Factory {

        ItemStackSnapshot empty();
    }
}
