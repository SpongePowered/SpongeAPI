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
package org.spongepowered.api.data.property.item;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.data.property.AbstractProperty;
import org.spongepowered.api.effect.potion.PotionEffect;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * Represents an {@link Property} that applies a set of
 * {@link PotionEffect}s on use, consumption, or on equip. The properties
 * are not mutable, but can be compared against.
 *
 * <p>Examples of these properties include: hunger from eating zombie flesh,
 * regeneration from a golden apple, etc.</p>
 */
public class ApplicableEffectProperty extends AbstractProperty<String, Set<PotionEffect>> {

    /**
     * Creates a {@link ApplicableEffectProperty} with a specific set of {@link PotionEffect}s.
     *
     * @param value The potion effects
     */
    public ApplicableEffectProperty(@Nullable Set<PotionEffect> value) {
        super(value == null ? ImmutableSet.of() : ImmutableSet.copyOf(value));
    }

    /**
     * Creates a {@link ApplicableEffectProperty} with a specific set of {@link PotionEffect}s.
     *
     * @param value The potion effects
     * @param op The operator to use when comparing against other properties
     */
    public ApplicableEffectProperty(@Nullable Set<PotionEffect> value, Operator op) {
        super(value == null ? ImmutableSet.of() : ImmutableSet.copyOf(value), op);
    }

    @Override
    public int compareTo(Property<?, ?> o) {
        if (o instanceof ApplicableEffectProperty) {
            ApplicableEffectProperty effect = (ApplicableEffectProperty) o;
            Set<PotionEffect> set = Sets.newHashSet(effect.getValue() == null ? new HashSet<>() : effect.getValue());
            Set<PotionEffect> thisSet = this.getValue() == null ? new HashSet<>() : this.getValue();
            for (PotionEffect effect1 : thisSet) {
                if (set.contains(effect1)) {
                    set.remove(effect1);
                } else {
                    return 1;
                }
            }
            return set.size() > 0 ? -set.size() : 0;
        }
        return this.getClass().getName().compareTo(o.getClass().getName());
    }
}
