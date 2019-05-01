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
package org.spongepowered.api.entity.living.animal;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.DyeableData;
import org.spongepowered.api.data.manipulator.mutable.entity.AggressiveData;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Represents a Wolf.
 */
public interface Wolf extends Animal {

    /**
     * Gets a copy of the current {@link AggressiveData} for this
     * {@link Wolf}.
     *
     * @return A copy of the current aggressive data
     */
    default AggressiveData getAggressiveData() {
        return this.get(AggressiveData.class).get();
    }

    /**
     * Gets if this {@link Wolf} is currently aggressive, as a {@link Value}.
     *
     * @return The current aggressive value
     */
    default Value<Boolean> aggressive() {
        return this.getValue(Keys.ANGRY).get();
    }

    /**
     * Gets a copy of the current {@link DyeableData} for this
     * {@link Wolf}'s collar.
     *
     * @return A copy of the current dyeable collar data
     */
    default DyeableData getCollarColorData() {
        return this.get(DyeableData.class).get();
    }

    /**
     * Gets the {@link Wolf}'s {@link DyeColor} of it's collar.
     *
     * @return The current dyecolor of the collar
     */
    default Value<DyeColor> collarColor() {
        return this.getValue(Keys.DYE_COLOR).get();
    }
}
