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
package org.spongepowered.api.block.meta;

import org.spongepowered.api.block.data.RecordPlayer;
import org.spongepowered.api.item.ItemType;

import com.google.common.base.Optional;


public interface Record {

    /**
     * Gets the ItemType that plays this record in a {@link RecordPlayer}.
     * 
     * @return The ItemType that plays this record in a RecordPlayer
     */
    Optional<ItemType> getItem();

    /**
     * Gets the name of this record.
     * 
     * @return The name of this record
     */
    String getName();

    /**
     * Gets the composer of this record.
     * 
     * @return The composer of this record
     */
    String getComposer();

    /**
     * Gets the length of this record, in seconds.
     * 
     * @return The length of this record, in seconds
     */
    int getLength();

}
