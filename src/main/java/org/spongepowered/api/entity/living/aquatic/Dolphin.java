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
package org.spongepowered.api.entity.living.aquatic;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;

/**
 * Represents a Dolphin
 */
public interface Dolphin extends Aquatic {

    /**
     * {@link Keys#SKIN_MOISTURE}
     * @return The skin moisture value, before they are parched
     */
    default Value.Mutable<Integer> skinMoisture() {
        return this.requireValue(Keys.SKIN_MOISTURE).asMutable();
    }

    /**
     * {@link Keys#HAS_FISH}
     * @return Whether this dolphin has a fish, but not a towel
     */
    default Value.Mutable<Boolean> gotFish() {
        return this.requireValue(Keys.HAS_FISH).asMutable();
    }
}
