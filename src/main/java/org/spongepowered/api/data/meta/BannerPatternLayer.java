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
import org.spongepowered.api.block.entity.Banner;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.type.BannerPatternShape;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.function.Supplier;

/**
 * A representation on a single layer of a {@link Banner}'s pattern.
 */
public interface BannerPatternLayer extends DataSerializable {

    /**
     * Creates a {@link BannerPatternLayer} with the desired
     * {@link BannerPatternShape} and {@link DyeColor}.
     *
     * @param shape The shape
     * @param color The color
     * @return The new pattern layer
     */
    static BannerPatternLayer of(Supplier<? extends BannerPatternShape> shape, Supplier<? extends DyeColor> color) {
        return of(shape.get(), color.get());
    }

    /**
     * Creates a {@link BannerPatternLayer} with the desired
     * {@link BannerPatternShape} and {@link DyeColor}.
     *
     * @param shape The shape
     * @param color The color
     * @return The new pattern layer
     */
    static BannerPatternLayer of(Supplier<? extends BannerPatternShape> shape, DyeColor color) {
        return of(shape.get(), color);
    }

    /**
     * Creates a {@link BannerPatternLayer} with the desired
     * {@link BannerPatternShape} and {@link DyeColor}.
     *
     * @param shape The shape
     * @param color The color
     * @return The new pattern layer
     */
    static BannerPatternLayer of(BannerPatternShape shape, Supplier<? extends DyeColor> color) {
        return of(shape, color.get());
    }

    /**
     * Creates a {@link BannerPatternLayer} with the desired
     * {@link BannerPatternShape} and {@link DyeColor}.
     *
     * @param shape The shape
     * @param color The color
     * @return The new pattern layer
     */
    static BannerPatternLayer of(BannerPatternShape shape, DyeColor color) {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class)
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

    interface Builder extends CopyableBuilder<BannerPatternLayer, Builder>, DataBuilder<BannerPatternLayer> {

        /**
         * Sets the {@link BannerPatternShape} to be used.
         *
         * @param shape The shape
         * @return This builder, for chaining
         */
        Builder pattern(BannerPatternShape shape);

        /**
         * Sets the {@link BannerPatternShape} to be used.
         *
         * @param shape The shape
         * @return This builder, for chaining
         */
        default Builder pattern(Supplier<? extends BannerPatternShape> shape) {
            return this.pattern(shape.get());
        }

        /**
         * Sets the {@link DyeColor} to be used.
         *
         * @param color The color
         * @return This builder, for chaining
         */
        Builder color(DyeColor color);

        /**
         * Sets the {@link DyeColor} to be used.
         *
         * @param color The color
         * @return This builder, for chaining
         */
        default Builder color(Supplier<? extends DyeColor> color) {
            return this.color(color.get());
        }

        /**
         * Builds a {@link BannerPatternLayer} provided that the
         * color and pattern are set.
         *
         * @return The new pattern layer
         */
        BannerPatternLayer build();

        @Override
        Builder reset();
    }

}
