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
import org.spongepowered.api.data.value.Value;

import java.util.Optional;
import java.util.UUID;

/**
 * Represents a Fox.
 */
public interface Fox extends Animal, Sittable {

    /**
     * {@link Keys#FOX_TYPE}
     *
     * @return The type of fox
     * @see org.spongepowered.api.data.type.FoxTypes
     */
    default Value.Mutable<FoxType> foxType() {
        return this.requireValue(Keys.FOX_TYPE).asMutable();
    }

    /**
     * {@link Keys#FIRST_TRUSTED}
     *
     * @return The first trusted unique id
     */
    default Optional<Value.Mutable<UUID>> firstTrusted() {
        return this.getValue(Keys.FIRST_TRUSTED).map(Value::asMutable);
    }

    /**
     * {@link Keys#SECOND_TRUSTED}
     *
     * @return The second trusted uuid
     */
    default Optional<Value.Mutable<UUID>> secondTrusted() {
        return this.getValue(Keys.SECOND_TRUSTED).map(Value::asMutable);
    }

    /**
     * {@link Keys#IS_FACEPLANTED}
     *
     * @return Whether this fox has faceplanted
     */
    default Value.Mutable<Boolean> faceplanted() {
        return this.requireValue(Keys.IS_FACEPLANTED).asMutable();
    }

    /**
     * {@link Keys#IS_DEFENDING}
     *
     * @return Whether this fox is defending
     */
    default Value.Mutable<Boolean> defending() {
        return this.requireValue(Keys.IS_DEFENDING).asMutable();
    }

    /**
     * {@link Keys#IS_SLEEPING}
     *
     * @return Whether this fox is sleeping
     */
    default Value.Mutable<Boolean> sleeping() {
        return this.requireValue(Keys.IS_SLEEPING).asMutable();
    }

    /**
     * {@link Keys#IS_POUNCING}
     *
     * @return Whether this fox is pouncing
     */
    default Value.Mutable<Boolean> pouncing() {
        return this.requireValue(Keys.IS_POUNCING).asMutable();
    }

    /**
     * {@link Keys#IS_CROUCHING}
     *
     * @return Whether this fox is crouching
     */
    default Value.Mutable<Boolean> crouching() {
        return this.requireValue(Keys.IS_CROUCHING).asMutable();
    }

    /**
     * {@link Keys#IS_INTERESTED}
     *
     * @return Whether this fox is interested in something
     */
    default Value.Mutable<Boolean> interested() {
        return this.requireValue(Keys.IS_INTERESTED).asMutable();
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
