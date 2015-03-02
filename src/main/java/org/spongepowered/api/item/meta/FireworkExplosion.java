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
 * 
 * Represents a firework's explosion.
 *
 */
public interface FireworkExplosion {

    /**
     * Gets if this firework explosion will flicker.
     * 
     * @return If this firework explosion will flicker
     */
    boolean doesFlicker();

    /**
     * Sets if this firework explosion will flicker.
     * 
     * @param flickers If this firework explosion will now flicker
     */
    void setFlickers(boolean flickers);

    /**
     * Gets if this firework explosion has a trail.
     * 
     * @return If this firework explosion has a trail
     */
    boolean hasTrail();

    /**
     * Sets if this firework explosion has a trail.
     * 
     * @param trail If this firework explosion now has a trail
     */
    void setHasTrail(boolean trail);

    /**
     * Gets a list of the the primary colors of this firework explosion. Not
     * read-only.
     * 
     * @return A list of the the primary colors of this firework explosion
     */
    List<Color> getColors();

    /**
     * Adds a color to this firework explosion's primary colors.
     * 
     * @param color The color to add
     */
    void addColor(Color color);

    /**
     * Gets a list of the the fade colors of this firework explosion. Not
     * read-only.
     * 
     * @return A list of the the fade colors of this firework explosion
     */
    List<Color> getFadeColors();

    /**
     * Adds a color to this firework explosion's fade colors.
     * 
     * @param color The color to add
     */
    void addFadeColor(Color color);

    /**
     * Gets the {@link FireworkShape} of this firework explosion.
     * 
     * @return The FireworkShape of this firework explosion
     */
    FireworkShape getShape();

    /**
     * Sets the {@link FireworkShape} of this firework explosion.
     * 
     * @param shape The new FireworkShape of this firework explosion
     */
    void setShape(FireworkShape shape);

}
