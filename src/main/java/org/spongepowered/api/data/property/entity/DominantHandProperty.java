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
package org.spongepowered.api.data.property.entity;

import org.spongepowered.api.data.Property;
import org.spongepowered.api.data.manipulator.mutable.entity.DominantHandData;
import org.spongepowered.api.data.property.AbstractProperty;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.type.HandPreferences;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.Coerce;

import javax.annotation.Nullable;

/**
 * Represents a {@link Property} for the dominant {@link HandPreference} of a
 * {@link Player}.
 *
 * <p>Handedness usually determines which hand is used for "main" interactions,
 * such as tool use or block breaking.</p>
 *
 * <p><i>NOTE: </i> This only applies to {@link Player}s, for {@link Living}
 * entities see {@link DominantHandData}.</p>
 */
public class DominantHandProperty extends AbstractProperty<String, HandPreference> {

    /**
     * Creates a new {@link DominantHandProperty} with the provided
     * {@link HandPreference} value.
     *
     * @param value The value
     */
    public DominantHandProperty(@Nullable HandPreference value) {
        super(value);
    }

    /**
     * Creates a new {@link DominantHandProperty} with the provided
     * {@link HandPreference}
     * and {@link org.spongepowered.api.data.Property.Operator} value.
     *
     * @param value The value
     * @param op The operator for comparison
     */
    public DominantHandProperty(@Nullable HandPreference value, @Nullable Operator op) {
        super(value, op);
    }

    @Override
    public int compareTo(@Nullable Property<?, ?> o) {
        HandPreference other = Coerce.toPseudoEnum(o == null ? null : o.getValue(), HandPreference.class, HandPreferences.class,
                HandPreferences.RIGHT);
        return this.getValue().getId().compareTo(o == null ? "" : other.getId());
    }
}
