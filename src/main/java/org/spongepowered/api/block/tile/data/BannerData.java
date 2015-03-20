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

import org.spongepowered.api.block.tile.Banner;
import org.spongepowered.api.item.DyeColor;
import org.spongepowered.api.service.persistence.DataSerializable;

import java.util.List;

/**
 * Represents the banner data for a {@link Banner}.
 */
public interface BannerData extends TileEntityData<Banner, BannerData> {

    /**
     * Gets the base color of this banner.
     *
     * @return The base color
     */
    DyeColor getBaseColor();

    /**
     * Sets the base color of this banner.
     *
     * @param color The new color
     */
    void setBaseColor(DyeColor color);

    /**
     * Gets an ordered list of this Banner's pattern layers.
     *
     * @return The pattern layers
     */
    List<PatternLayer> getPatternList();

    /**
     * Clears this banners Pattern layers leaving only the base color.
     */
    void clearPattern();

    /**
     * Adds a new {@link PatternLayer} to the end of this banner's pattern list.
     *
     * @param pattern The new pattern layer
     */
    void addPatternLayer(PatternLayer pattern);

    /**
     * Adds a new {@link PatternLayer} to the end of this banner's pattern list.
     *
     * @param patternShape The pattern shape
     * @param color The layer color
     */
    void addPatternLayer(BannerPatternShape patternShape, DyeColor color);

    /**
     * A representation on a single layer of a {@link BannerData}'s pattern.
     */
    interface PatternLayer extends DataSerializable {

        /**
         * Gets the pattern shape for this layer.
         *
         * @return The shape
         */
        BannerPatternShape getId();

        /**
         * Gets the color for this layer.
         *
         * @return The color
         */
        DyeColor getColor();

    }
}
