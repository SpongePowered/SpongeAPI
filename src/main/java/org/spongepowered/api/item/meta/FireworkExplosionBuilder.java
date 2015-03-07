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
package org.spongepowered.api.item.meta;

import java.awt.Color;
import java.util.List;

/**
 * A builder for {@link FireworkExplosion}s.
 */
public interface FireworkExplosionBuilder {

    /**
     * Sets if the built {@link FireworkExplosion} should flicker.
     * 
     * @param flicker If the built FireworkExplosion should flicker
     * @return This builder, for chaining
     */
    FireworkExplosionBuilder flicker(boolean flicker);

    /**
     * Sets if the built {@link FireworkExplosion} should have a trail.
     * 
     * @param trail If the built FireworkExplosion should have a trail
     * @return This builder, for chaining
     */
    FireworkExplosionBuilder trail(boolean trail);

    /**
     * Adds a primary color to the built {@link FireworkExplosion}.
     * 
     * @param color The color to add
     * @return This builder, for chaining
     */
    FireworkExplosionBuilder color(Color color);

    /**
     * Adds multiple primary colors to the built {@link FireworkExplosion}.
     * 
     * @param colors The colors to add
     * @return This builder, for chaining
     */
    FireworkExplosionBuilder colors(List<Color> colors);

    /**
     * Adds multiple primary colors to the built {@link FireworkExplosion}.
     * 
     * @param colors The colors to add
     * @return This builder, for chaining
     */
    FireworkExplosionBuilder colors(Color... colors);

    /**
     * Adds a primary color to the built {@link FireworkExplosion}.
     * 
     * @param fadeColor The color to add
     * @return This builder, for chaining
     */
    FireworkExplosionBuilder fadeColor(Color fadeColor);

    /**
     * Adds multiple primary colors to the built {@link FireworkExplosion}.
     * 
     * @param fadeColors The colors to add
     * @return This builder, for chaining
     */
    FireworkExplosionBuilder fadeColors(List<Color> fadeColors);

    /**
     * Adds multiple primary colors to the built {@link FireworkExplosion}.
     * 
     * @param fadeColors The colors to add
     * @return This builder, for chaining
     */
    FireworkExplosionBuilder fadeColors(Color... fadeColors);

    /**
     * Sets the shape of the built {@link FireworkExplosion}.
     * 
     * @param shape The shape of the built FireworkExplosion
     * @return This builder, for chaining
     */
    FireworkExplosionBuilder shape(FireworkShape shape);

    /**
     * Builds a {@link FireworkExplosion} with the set parameters.
     * 
     * @return A FireworkExplosion with the set parameters
     */
    FireworkExplosion build();

    /**
     * Resets this builder to be used again.
     * 
     * @return This builder, for chaining
     */
    FireworkExplosionBuilder reset();

}
