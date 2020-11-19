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
package org.spongepowered.api.map;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.map.decoration.MapDecoration;
import org.spongepowered.api.util.Identifiable;

/**
 * Represents data that may be viewed on a {@link ItemTypes#FILLED_MAP map}.
 * A MapInfo may be attached to multiple maps.
 *
 * @see org.spongepowered.api.data.Keys#MAP_INFO
 */
public interface MapInfo extends DataHolder.Mutable, Identifiable, DataSerializable {

    /**
     * Gets whether the supplied {@link ItemStack} is backed by this MapInfo,
     * such that modifications to this MapInfo would affect the supplied
     * stack.
     *
     * <p>This will always return {@code false} if the supplied
     * {@link ItemStack} is not of type {@link ItemTypes#FILLED_MAP}.</p>
     *
     * @param itemStack The {@link ItemStack} to check
     * @return {@code true} if this MapInfo backs the supplied {@link ItemStack}
     */
    boolean isLinked(ItemStack itemStack);

    /**
     * Serializes this object into a comprehensible {@link DataContainer}.
     *
     * <p><b>This has special behaviour for serializing {@link MapDecoration MapDecorations}</b></p>
     *
     * <p>A {@link MapDecoration} on this MapCanvas is only
     * serialized <b>if {@link MapDecoration#isPersistent()}
     * returns true</b>. This is because non-persistent
     * MapDecorations belong more to the area than the map itself.
     * If you wish to serialize them anyway, obtain the
     * {@link MapDecoration MapDecorations} using
     * {@link org.spongepowered.api.data.Keys#MAP_DECORATIONS}
     * and serialize each individually.</p>
     *
     * @return A newly created DataContainer
     */
    @Override
    DataContainer toContainer();
}
