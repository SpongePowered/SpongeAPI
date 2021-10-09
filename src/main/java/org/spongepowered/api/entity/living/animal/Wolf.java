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

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.Value;

/**
 * Represents a Wolf.
 */
public interface Wolf extends TameableAnimal {

    /**
     * {@link Keys#IS_ANGRY}
     *
     * @return Whether this wolf is currently aggressive
     */
    default Value.Mutable<Boolean> angry() {
        return this.requireValue(Keys.IS_ANGRY).asMutable();
    }

    /**
     * {@link Keys#DYE_COLOR}
     * @return The collar color
     */
    default Value.Mutable<DyeColor> collarColor() {
        return this.requireValue(Keys.DYE_COLOR).asMutable();
    }

    /**
     * {@link Keys#IS_BEGGING_FOR_FOOD}
     *
     * <p>In vanilla, a wolf begs when a player comes close
     * with food. The head of the wolf will also tilt as a result.</p>
     *
     * @return Whether this wolf is begging for food
     */
    default Value.Mutable<Boolean> beggingForFood() {
        return this.requireValue(Keys.IS_BEGGING_FOR_FOOD).asMutable();
    }
}
