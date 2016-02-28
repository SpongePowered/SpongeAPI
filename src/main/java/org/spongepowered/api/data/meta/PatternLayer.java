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
package org.spongepowered.api.data.meta;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.manipulator.mutable.tileentity.BannerData;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.type.BannerPatternShape;
import org.spongepowered.api.data.type.DyeColor;

/**
 * A representation on a single layer of a {@link BannerData}'s pattern.
 */
public interface PatternLayer extends DataSerializable {

    /**
     * Creates a {@link PatternLayer} with the desired
     * {@link BannerPatternShape} and {@link DyeColor}.
     *
     * @param shape The shape
     * @param color The color
     * @return The new pattern layer
     */
    static PatternLayer of(BannerPatternShape shape, DyeColor color) {
        return Sponge.getRegistry()
            .createBuilder(Builder.class)
            .pattern(shape)
            .color(color)
            .build();
    }

    /**
     * Gets the pattern shape for this layer.
     *
     * @return The shape
     */
    BannerPatternShape getShape();

    /**
     * Gets the color for this layer.
     *
     * @return The color
     */
    DyeColor getColor();

    interface Builder extends DataBuilder<PatternLayer> {

        /**
         * Sets the {@link BannerPatternShape} to be used.
         *
         * @param shape The shape
         * @return This builder, for chaining
         */
        Builder pattern(BannerPatternShape shape);

        /**
         * Sets the {@link DyeColor} to be used.
         *
         * @param color The color
         * @return This builder, for chaining
         */
        Builder color(DyeColor color);

        /**
         * Builds a {@link PatternLayer} provided that the
         * color and pattern are set.
         *
         * @return The new pattern layer
         */
        PatternLayer build();

        @Override
        Builder reset();
    }

}
