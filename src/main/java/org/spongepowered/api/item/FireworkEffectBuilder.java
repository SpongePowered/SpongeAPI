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
package org.spongepowered.api.item;

import java.awt.Color;

/**
 * A builder for {@link FireworkEffect}s.
 */
public interface FireworkEffectBuilder {

    /**
     * Sets whether the {@link FireworkEffect} is going to have a trail
     * or not.
     *
     * @param trail Whether the firework will have a trail
     * @return This builder, for chaining
     */
    FireworkEffectBuilder trail(boolean trail);

    /**
     * Sets whether the {@link FireworkEffect} is going to flicker
     * on explosion.
     *
     * @param flicker Whether the explosion will flicker
     * @return This builder, for chaining
     */
    FireworkEffectBuilder flicker(boolean flicker);

    /**
     * Adds the given {@link Color} to the initial explosion colors.
     *
     * <p>Colors can be mixed and matched in the order they are added
     * in.</p>
     *
     * @param color The color to add to the explosion
     * @return This builder, for chaining
     */
    FireworkEffectBuilder color(Color color);

    /**
     * Adds the given {@link Color}s to the initial explosion colors.
     *
     * <p>Colors can be mixed and matched in the order they are added
     * in.</p>
     *
     * @param colors The colors to add to the explosion
     * @return This builder, for chaining
     */
    FireworkEffectBuilder colors(Color... colors);

    /**
     * Adds the given {@link Color}s to the initial explosion colors.
     *
     * <p>Colors can be mixed and matched in the order they are added
     * in.</p>
     *
     * @param colors The colors to add to the explosion
     * @return This builder, for chaining
     */
    FireworkEffectBuilder colors(Iterable<Color> colors);

    /**
     * Adds the given {@link Color} to the fade colors.
     *
     * <p>Colors can be mixed and matched in the order they are added
     * in.</p>
     *
     * @param color The colors to add to the fade
     * @return This builder, for chaining
     */
    FireworkEffectBuilder fade(Color color);

    /**
     * Adds the given {@link Color}s to the fade colors.
     *
     * <p>Colors can be mixed and matched in the order they are added
     * in.</p>
     *
     * @param colors The colors to add to the fade
     * @return This builder, for chaining
     */
    FireworkEffectBuilder fades(Color... colors);

    /**
     * Adds the given {@link Color}s to the fade colors.
     *
     * <p>Colors can be mixed and matched in the order they are added
     * in.</p>
     *
     * @param colors The colors to add to the fade
     * @return This builder, for chaining
     */
    FireworkEffectBuilder fades(Iterable<Color> colors);

    /**
     * Sets the shape of the {@link FireworkEffect} explosion.
     *
     * @param shape The shape of the explosion
     * @return This builder, for chaining
     */
    FireworkEffectBuilder shape(FireworkShape shape);

    /**
     * Builds a {@link FireworkEffect} based on the current state of this
     * builder.
     *
     * @return A newly created firework effect
     */
    FireworkEffect build();

    /**
     * Resets this builder to a clean state.
     *
     * @return This builder, for chaining
     */
    FireworkEffectBuilder reset();

}
