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

import java.util.Optional;

/**
 * Represents a Cat, meow.
 */
public interface Cat extends TameableAnimal {

    /**
     * {@link Keys#CAT_TYPE}
     *
     * @return The type of cat
     * @see org.spongepowered.api.data.type.CatTypes
     */
    default Value.Mutable<CatType> catType() {
        return this.requireValue(Keys.CAT_TYPE).asMutable();
    }

    /**
     * {@link Keys#IS_LYING_DOWN}
     *
     * <p>In vanilla, a cat lies down near its owner when the owner goes to
     * sleep.</p>
     *
     * @return Whether this cat is lying down
     */
    default Value.Mutable<Boolean> lyingDown() {
        return this.requireValue(Keys.IS_LYING_DOWN).asMutable();
    }

    /**
     * {@link Keys#IS_RELAXED}
     *
     * <p>In vanilla, a cat relaxes before lying down.</p>
     *
     * @return Whether this cat is relaxed
     */
    default Value.Mutable<Boolean> relaxed() {
        return this.requireValue(Keys.IS_RELAXED).asMutable();
    }

    /**
     * {@link Keys#DYE_COLOR}
     *
     * @return The collar color
     */
    default Value.Mutable<DyeColor> collarColor() {
        return this.requireValue(Keys.DYE_COLOR).asMutable();
    }

    /**
     * {@link Keys#IS_PURRING}
     *
     * <p>In vanilla, a cat purrs every so many ticks when lying down or relaxed.
     * Otherwise it will also pur if it is currently breeding.</p>
     *
     * @return Whether this cat is purring
     */
    default Value.Mutable<Boolean> purring() {
        return this.requireValue(Keys.IS_PURRING).asMutable();
    }

    /**
     * {@link Keys#IS_BEGGING_FOR_FOOD}
     *
     * <p>In vanilla, a cat begs for food every so many ticks
     * if {@link TameableAnimal#tamer()} returns {@link Optional#isPresent()}.</p>
     *
     * @return Whether this cat is purring
     */
    default Value.Mutable<Boolean> beggingForFood() {
        return this.requireValue(Keys.IS_BEGGING_FOR_FOOD).asMutable();
    }

    /**
     * {@link Keys#IS_HISSING}
     *
     * <p>In vanilla, a cat hisses when a {@link Phantom} is detected near it.</p>
     *
     * @return Whether this cat is hissing
     */
    default Value.Mutable<Boolean> hissing() {
        return this.requireValue(Keys.IS_HISSING).asMutable();
    }
}
