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
package org.spongepowered.api.data.manipulator.tileentity;

import org.spongepowered.api.block.tileentity.Banner;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.manipulator.ListData;
import org.spongepowered.api.data.type.BannerPatternShape;
import org.spongepowered.api.data.type.DyeColor;

import java.util.List;

/**
 * Represents the information for a {@link Banner} such as the
 * base color and {@link BannerData.PatternLayer}s.
 */
public interface BannerData extends ListData<BannerData.PatternLayer, BannerData> {

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
     * @return This instance, for chaining
     */
    BannerData setBaseColor(DyeColor color);

    /**
     * Gets an ordered list of this Banner's pattern layers.
     *
     * @return The pattern layers
     */
    List<PatternLayer> getPatternsList();

    /**
     * Clears this banners Pattern layers leaving only the base color.
     *
     * @return This instance, for chaining
     */
    BannerData clearPatterns();

    /**
     * Adds a new {@link PatternLayer} to the end of this banner's pattern list.
     *
     * @param pattern The new pattern layer
     * @return This instance, for chaining
     */
    BannerData addPatternLayer(PatternLayer pattern);

    /**
     * Adds a new {@link PatternLayer} to the end of this banner's pattern list.
     *
     * @param patternShape The pattern shape
     * @param color The layer color
     * @return This instance, for chaining
     */
    BannerData addPatternLayer(BannerPatternShape patternShape, DyeColor color);

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
