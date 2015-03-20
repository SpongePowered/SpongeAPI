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

package org.spongepowered.api.block.tile.data;

import com.google.common.base.Optional;
import org.spongepowered.api.block.tile.Jukebox;
import org.spongepowered.api.item.inventory.ItemStack;

import javax.annotation.Nullable;

/**
 * Represents the data of a {@link Jukebox}.
 */
public interface JukeboxData extends TileEntityData<Jukebox, JukeboxData> {

    /**
     * Retrieves the record contained in this Jukebox, if there is one.
     *
     * @return The record in this Jukebox or {@link Optional#absent()}
     */
    Optional<ItemStack> getRecord();

    /**
     * Sets the record contained within this Jukebox to the given one.
     * If the given one is null, the record within this Jukebox is removed and the item
     * destroyed.
     *
     * @param record The record to set, or null to destroy the record
     */
    void setRecord(@Nullable ItemStack record);

}
