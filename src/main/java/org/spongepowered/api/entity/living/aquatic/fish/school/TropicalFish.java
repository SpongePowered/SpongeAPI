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
package org.spongepowered.api.entity.living.aquatic.fish.school;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.TropicalFishShape;
import org.spongepowered.api.data.value.Value;

public interface TropicalFish extends SchoolingFish {

    /**
     * {@link Keys#DYE_COLOR}
     *
     * @return The base color of this tropical fish
     */
    default Value.Mutable<DyeColor> baseColor() {
        return this.requireValue(Keys.DYE_COLOR).asMutable();
    }

    /**
     * {@link Keys#PATTERN_COLOR}
     *
     * @return The pattern color of this tropical fish
     */
    default Value.Mutable<DyeColor> patternColor() {
        return this.requireValue(Keys.PATTERN_COLOR).asMutable();
    }

    /**
     * {@link Keys#TROPICAL_FISH_SHAPE}
     *
     * @return The shape of this tropical fish
     */
    default Value.Mutable<TropicalFishShape> shape() {
        return this.requireValue(Keys.TROPICAL_FISH_SHAPE).asMutable();
    }
}
