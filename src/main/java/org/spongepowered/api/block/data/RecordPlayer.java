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
package org.spongepowered.api.block.data;

import org.spongepowered.api.block.meta.Record;
import org.spongepowered.api.item.ItemType;

import com.google.common.base.Optional;

import javax.annotation.Nullable;

public interface RecordPlayer extends TileEntity {

    /**
     * Gets the {@link ItemType} in this record player. Doesn't have to be a
     * record.
     * 
     * @return The ItemType in this record player
     */
    ItemType getItem();

    /**
     * Sets the {@link ItemType} in this record player. Doesn't have to be a
     * record.
     *
     * @param item The new ItemType to put in this record player
     */
    void setItem(ItemType item);

    /**
     * Gets the {@link Record} currently in this record player.
     * 
     * @return The Record currently in this record player
     */
    Optional<Record> getRecord();

    /**
     * Sets the {@link Record} currently in this record player.
     * 
     * @param record The new Record to put in this record player
     */
    void setRecord(@Nullable Record record);

    /**
     * Gets if the record player is currently playing.
     * 
     * @return If the record player is currently playing
     */
    boolean isPlaying();

    /**
     * Makes the record player play the current {@link Record}.
     */
    void play();

}
