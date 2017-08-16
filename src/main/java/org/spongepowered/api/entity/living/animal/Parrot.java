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
import org.spongepowered.api.data.manipulator.mutable.entity.ParrotData;
import org.spongepowered.api.data.type.ParrotVariant;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * Represents a parrot.
 */
public interface Parrot extends Animal {

    /**
     * Gets a copy of the current {@link ParrotData} being represented by
     * this {@link Parrot}.
     *
     * @return A copy of the current parrot data
     */
    default ParrotData getParrotData() {
        return this.get(ParrotData.class).get();
    }

    /**
     * Gets the {@link Value} for the {@link ParrotVariant} of this
     * {@link Parrot}.
     *
     * @return The parrot variant value
     */
    default Value<ParrotVariant> variant() {
        return this.getValue(Keys.PARROT_VARIANT).get();
    }

}
