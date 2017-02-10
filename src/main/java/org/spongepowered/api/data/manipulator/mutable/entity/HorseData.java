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
package org.spongepowered.api.data.manipulator.mutable.entity;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.entity.ImmutableHorseData;
import org.spongepowered.api.data.type.HorseColor;
import org.spongepowered.api.data.type.HorseStyle;
import org.spongepowered.api.data.type.HorseVariant;
import org.spongepowered.api.data.type.HorseVariants;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.entity.living.animal.Horse;

/**
 * An {@link DataManipulator} handling the various information for a
 * {@link Horse} including {@link HorseColor}, {@link HorseStyle}, and
 * {@link HorseVariant}.
 */
public interface HorseData extends DataManipulator<HorseData, ImmutableHorseData> {

    /**
     * Gets a {@link Value} for the {@link HorseColor}.
     *
     * <p>In Vanilla, this will have no effect unless {@link #variant()}
     * is {@link HorseVariants#HORSE}</p>
     *
     * @return The value for the horse color
     * @see Keys#HORSE_COLOR
     */
    Value<HorseColor> color();


    /**
     * Gets a {@link Value} for the {@link HorseStyle}.
     *
     * <p>In Vanilla, this will have no effect unless {@link #variant()}
     * is {@link HorseVariants#HORSE}</p>
     *
     * @return The value for the horse style
     * @see Keys#HORSE_STYLE
     */
    Value<HorseStyle> style();

    /**
     * Gets the {@link Value} for the {@link HorseVariant}.
     *
     * <p>HorseVariants may change the capability of a horse. Some horses
     * are unable to equip an extra chest, while others are unable to equip
     * armor. Health may be affected.</p>
     *
     * @return The value for the horse variant
     * @see Keys#HORSE_VARIANT
     */
    Value<HorseVariant> variant();

}
