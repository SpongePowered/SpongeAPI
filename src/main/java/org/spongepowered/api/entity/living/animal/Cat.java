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
import org.spongepowered.api.data.type.CatType;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.living.monster.Phantom;

/**
 * Represents a Cat, meow.
 */
public interface Cat extends TameableAnimal {

    /**
     * {@link Keys#CAT_TYPE}
     * @return The type of cat
     * @see org.spongepowered.api.data.type.CatTypes
     */
    default Value.Mutable<CatType> type() {
        return this.getValue(Keys.CAT_TYPE.get()).get().asMutable();
    }

    /**
     * {@link Keys#IS_LYING_DOWN}
     * @return Whether this cat is lying down
     */
    default Value.Mutable<Boolean> lyingDown() {
        return this.getValue(Keys.IS_LYING_DOWN.get()).get().asMutable();
    }

    /**
     * {@link Keys#IS_RELAXED}
     * @return Whether this cat is a cool cat or a scaredey cat
     */
    default Value.Mutable<Boolean> relaxed() {
        return this.getValue(Keys.IS_RELAXED.get()).get().asMutable();
    }

    /**
     * {@link Keys#DYE_COLOR}
     * @return The collar color
     */
    default Value.Mutable<DyeColor> collarColor() {
        return this.getValue(Keys.DYE_COLOR.get()).get().asMutable();
    }

    /**
     * Determines if the {@link Cat} is purring. In vanilla, a cat purrs every so many ticks when lying down or relaxed.
     * Otherwise it will also pur if it is currently breeding.
     *
     * @return True if purring, false if not
     */
    boolean isPurring();

    /**
     * Determines if the {@link Cat} is begging for food. In vanilla, a cat begs for food every so many ticks
     * if {@link TameableAnimal#isTamed()} returns false.
     *
     * @return True if begging for food, false if not
     */
    boolean isBeggingForFood();

    /**
     * Determines if the {@link Cat} is hissing. In vanilla, a cat hisses when a {@link Phantom} is detected near it.
     *
     * @return True if hissing, false if not
     */
    boolean isHissing();
}
