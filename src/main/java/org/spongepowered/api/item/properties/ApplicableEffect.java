/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.item.properties;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.spongepowered.api.potion.PotionEffect;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/**
 * Represents an {@link ItemProperty} that applies a set of
 * {@link PotionEffect}s on use, consumption, or on equip. The properties
 * are not mutable, but can be compared against.
 *
 * <p>Examples of these properties include: hunger from eating zombie flesh,
 * regeneration from a golden apple, etc.</p>
 */
public class ApplicableEffect extends AbstractItemProperty<String, Set<PotionEffect>> {

    /**
     * Creates a {@link ApplicableEffect} with a specific set of {@link PotionEffect}s.
     *
     * @param value The potion effects
     */
    public ApplicableEffect(@Nullable Set<PotionEffect> value) {
        super(value == null ? ImmutableSet.<PotionEffect>of() : ImmutableSet.copyOf(value));
    }

    /**
     * Creates a {@link ApplicableEffect} with a specific set of {@link PotionEffect}s.
     *
     * @param value The potion effects
     * @param op The operator to use when comparing against other properties
     */
    public ApplicableEffect(@Nullable Set<PotionEffect> value, Operator op) {
        super(value == null ? ImmutableSet.<PotionEffect>of() : ImmutableSet.copyOf(value), op);
    }

    @Override
    public int compareTo(ItemProperty<?, ?> o) {
        if (o instanceof ApplicableEffect) {
            ApplicableEffect effect = (ApplicableEffect) o;
            Set<PotionEffect> set = Sets.newHashSet(effect.getValue());
            for (PotionEffect effect1 : this.getValue()) {
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
