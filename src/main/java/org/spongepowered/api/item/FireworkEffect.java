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
package org.spongepowered.api.item;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.List;
import java.util.function.Supplier;

/**
 * Represents a firework explosion.
 *
 * <p>{@link FireworkEffect}s are immutable once created. To change one
 * or create one, use {@link Builder}.</p>
 */
public interface FireworkEffect extends DataSerializable {

    /**
     * Creates a new {@link Builder} to build a {@link FireworkEffect}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }


    /**
     * Gets whether this {@link FireworkEffect} will flicker when
     * detonated.
     *
     * @return Whether this effect will flicker
     */
    boolean flickers();

    /**
     * Gets whether this {@link FireworkEffect} will have a trail
     * when detonated.
     *
     * @return Whether this effect will have a trail
     */
    boolean hasTrail();

    /**
     * Gets the ordered list of colors.
     *
     * <p>In some implementations, the order of colors defines the colors
     * showing from edge to center of the firework explosion.</p>
     *
     * @return The list of colors
     */
    List<Color> getColors();

    /**
     * Gets the ordered list of colors.
     *
     * <p>Normally in vanilla, the order of colors defines the colors
     * showing from edge to center of the firework explosion.</p>
     *
     * @return The list of colors
     */
    List<Color> getFadeColors();

    /**
     * Gets the explosion shape.
     *
     * @return The explosion shape
     */
    FireworkShape getShape();

    interface Builder extends CopyableBuilder<FireworkEffect, Builder> {

        /**
         * Sets whether the {@link FireworkEffect} is going to have a trail
         * or not.
         *
         * @param trail Whether the firework will have a trail
         * @return This builder, for chaining
         */
        Builder trail(boolean trail);

        /**
         * Sets whether the {@link FireworkEffect} is going to flicker
         * on explosion.
         *
         * @param flicker Whether the explosion will flicker
         * @return This builder, for chaining
         */
        Builder flicker(boolean flicker);

        /**
         * Adds the given {@link Color} to the initial explosion colors.
         *
         * <p>Colors can be mixed and matched in the order they are added
         * in.</p>
         *
         * @param color The color to add to the explosion
         * @return This builder, for chaining
         */
        Builder color(Color color);

        /**
         * Adds the given {@link Color}s to the initial explosion colors.
         *
         * <p>Colors can be mixed and matched in the order they are added
         * in.</p>
         *
         * @param colors The colors to add to the explosion
         * @return This builder, for chaining
         */
        Builder colors(Color... colors);

        /**
         * Adds the given {@link Color}s to the initial explosion colors.
         *
         * <p>Colors can be mixed and matched in the order they are added
         * in.</p>
         *
         * @param colors The colors to add to the explosion
         * @return This builder, for chaining
         */
        Builder colors(Iterable<Color> colors);

        /**
         * Adds the given {@link Color} to the fade colors.
         *
         * <p>Colors can be mixed and matched in the order they are added
         * in.</p>
         *
         * @param color The colors to add to the fade
         * @return This builder, for chaining
         */
        Builder fade(Color color);

        /**
         * Adds the given {@link Color}s to the fade colors.
         *
         * <p>Colors can be mixed and matched in the order they are added
         * in.</p>
         *
         * @param colors The colors to add to the fade
         * @return This builder, for chaining
         */
        Builder fades(Color... colors);

        /**
         * Adds the given {@link Color}s to the fade colors.
         *
         * <p>Colors can be mixed and matched in the order they are added
         * in.</p>
         *
         * @param colors The colors to add to the fade
         * @return This builder, for chaining
         */
        Builder fades(Iterable<Color> colors);

        /**
         * Sets the shape of the {@link FireworkEffect} explosion.
         *
         * @param shape The shape of the explosion
         * @return This builder, for chaining
         */
        Builder shape(FireworkShape shape);

        /**
         * Sets the shape of the {@link FireworkEffect} explosion.
         *
         * @param shape The shape of the explosion
         * @return This builder, for chaining
         */
        default Builder shape(Supplier<? extends FireworkShape> shape) {
            return this.shape(shape.get());
        }

        /**
         * Builds a {@link FireworkEffect} based on the current state of this
         * builder.
         *
         * @return A newly created firework effect
         */
        FireworkEffect build();
    }
}
