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

import org.spongepowered.api.service.persistence.DataSerializable;

import java.awt.Color;
import java.util.List;

/**
 * Represents a firework explosion.
 *
 * <p>{@link FireworkEffect}s are immutable once created. To change one
 * or create one, use {@link FireworkEffectBuilder}.</p>
 */
public interface FireworkEffect extends DataSerializable {

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
}
