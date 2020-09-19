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
import org.spongepowered.api.data.manipulator.mutable.MapInfoData;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.Identifiable;

/**
 * Represents data that may be viewed on a {@link ItemTypes#FILLED_MAP map}.
 * A MapInfo may be attached to multiple maps.
 *
 * @see MapInfoData
 */
public interface MapInfo extends DataHolder, Identifiable {

    /**
     * Checks if a different MapInfo refers the the
     * same map
     * @param other MapInfo
     * @return true if they refer to the same map
     */
    boolean isLinked(MapInfo other);

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
}
