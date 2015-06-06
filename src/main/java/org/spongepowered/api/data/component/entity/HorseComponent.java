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
package org.spongepowered.api.data.component.entity;

import org.spongepowered.api.data.Component;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.HorseVariant;
import org.spongepowered.api.entity.living.animal.Horse;

/**
 * Represents {@link Horse} information specific to {@link HorseStyle},
 * {@link HorseColor}, and {@link HorseVariant}.
 */
public interface HorseComponent extends Component<HorseComponent> {

    /**
     * Gets the current style of this Horse.
     *
     * @return The current style of this horse
     */
    HorseStyle getStyle();

    /**
     * Sets this horse to the specified style.
     *
     * @param style The new style to set
     * @return This instance, for chaining
     */
    HorseComponent setStyle(HorseStyle style);

    /**
     * Gets the current {@link HorseColor} of this horse.
     *
     * @return The current horse color
     */
    HorseColor getColor();

    /**
     * Sets this horse to the specified {@link HorseColor}.
     *
     * @param color The new color to set
     * @return This instance, for chaining
     */
    HorseComponent setColor(HorseColor color);

    /**
     * Gets the current {@link HorseVariant} of this horse.
     * <p>HorseVariants may change the capability of a horse. Some horses
     * are unable to equip an extra chest, while others are unable to equip
     * armor. Health may be affected.</p>
     *
     * @return The current variant of this horse
     */
    HorseVariant getVariant();

    /**
     * Sets this horse to the specified {@link HorseVariant}.
     * <p>HorseVariants may change the capability of a horse. Some horses
     * are unable to equip an extra chest, while others are unable to equip
     * armor. Health may be affected.</p>
     *
     * @param variant The variant to set
     * @return This instance, for chaining
     */
    HorseComponent setVariant(HorseVariant variant);

}
