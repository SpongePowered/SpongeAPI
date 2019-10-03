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
import org.spongepowered.api.data.type.FoxType;
import org.spongepowered.api.data.value.OptionalValue;
import org.spongepowered.api.data.value.Value;

import java.util.UUID;

/**
 * Represents a Fox.
 */
public interface Fox extends Animal {

    /**
     * {@link Keys#FOX_TYPE}
     */
    default Value.Mutable<FoxType> type() {
        return this.getValue(Keys.FOX_TYPE).get().asMutable();
    }

    /**
     * {@link Keys#FIRST_TRUSTED}
     */
    default OptionalValue.Mutable<UUID> firstTrusted() {
        return this.getValue(Keys.FIRST_TRUSTED).get().asMutable();
    }

    /**
     * {@link Keys#SECOND_TRUSTED}
     */
    default OptionalValue.Mutable<UUID> secondTrusted() {
        return this.getValue(Keys.SECOND_TRUSTED).get().asMutable();
    }

    /**
     * {@link Keys#IS_SITTING}
     */
    default Value.Mutable<Boolean> sitting() {
        return this.getValue(Keys.IS_SITTING).get().asMutable();
    }

    /**
     * {@link Keys#IS_FACEPLANTED}
     */
    default Value.Mutable<Boolean> faceplanted() {
        return this.getValue(Keys.IS_FACEPLANTED).get().asMutable();
    }

    /**
     * {@link Keys#IS_DEFENDING}
     */
    default Value.Mutable<Boolean> defending() {
        return this.getValue(Keys.IS_DEFENDING).get().asMutable();
    }

    /**
     * {@link Keys#IS_SLEEPING}
     */
    default Value.Mutable<Boolean> sleeping() {
        return this.getValue(Keys.IS_SLEEPING).get().asMutable();
    }

    /**
     * {@link Keys#IS_POUNCING}
     */
    default Value.Mutable<Boolean> pouncing() {
        return this.getValue(Keys.IS_POUNCING).get().asMutable();
    }

    /**
     * {@link Keys#IS_CROUCHING}
     */
    default Value.Mutable<Boolean> crouching() {
        return this.getValue(Keys.IS_CROUCHING).get().asMutable();
    }

    /**
     * {@link Keys#IS_INTERESTED}
     */
    default Value.Mutable<Boolean> interested() {
        return this.getValue(Keys.IS_INTERESTED).get().asMutable();
    }

    /**
     * Determines if this fox trusts the provided {@link UUID}. In vanilla, {@link Fox#firstTrusted()} is checked
     * first and then {@link Fox#secondTrusted()} is checked.
     *
     * @param uniqueId The unique id
     * @return True if trusted, false if not
     */
    boolean trusts(UUID uniqueId);
}
