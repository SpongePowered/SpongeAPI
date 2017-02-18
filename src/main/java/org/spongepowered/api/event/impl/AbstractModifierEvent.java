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
package org.spongepowered.api.event.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.entity.HealEntityEvent;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.util.annotation.eventgen.UseField;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * An abstract base class for implementations of {@link DamageEntityEvent} and {@link HealEntityEvent}.
 *
 * @param <T> The modifier type to use
 */
public abstract class AbstractModifierEvent<T> extends AbstractEvent  {

    protected double originalFinalAmount;
    protected List<Tuple<T, Double>> originalModifiers;
    protected Map<T, Double> originalModifierMap;
    protected final LinkedHashMap<T, Double> modifiers = Maps.newLinkedHashMap();
    protected final List<Tuple<T, Function<? super Double, Double>>> modifierFunctions = new ArrayList<>();

    protected ImmutableList<Tuple<T, Function<? super Double, Double>>> init(double originalValue,
            List<Tuple<T, Function<? super Double, Double>>> originalFunctions) {
        final ImmutableList.Builder<Tuple<T, Double>> modifierMapBuilder = ImmutableList.builder();
        final ImmutableList.Builder<Tuple<T, Function<? super Double, Double>>> functionListBuilder = ImmutableList.builder();
        final ImmutableMap.Builder<T, Double> mapBuilder = ImmutableMap.builder();
        double finalDamage = originalValue;
        for (Tuple<T, Function<? super Double, Double>> tuple : originalFunctions) {
            this.modifierFunctions.add(new Tuple<>(tuple.getFirst(), tuple.getSecond()));
            double tempDamage = checkNotNull(tuple.getSecond().apply(finalDamage));
            finalDamage += tempDamage;
            modifierMapBuilder.add(new Tuple<>(tuple.getFirst(), tempDamage));
            mapBuilder.put(tuple.getFirst(), tempDamage);
            this.modifiers.put(tuple.getFirst(), tempDamage);
            functionListBuilder.add(tuple);
        }
        this.originalFinalAmount = finalDamage;
        this.originalModifiers = modifierMapBuilder.build();
        this.originalModifierMap = mapBuilder.build();
        return functionListBuilder.build();
    }

    protected void recalculateDamages(double baseAmount) {
        double tempAmount = baseAmount;
        this.modifiers.clear();
        for (Tuple<T, Function<? super Double, Double>> entry : this.modifierFunctions) {
            double modifierAmount = checkNotNull(entry.getSecond().apply(tempAmount));
            if (this.modifiers.containsKey(entry.getFirst())) {
                double oldAmount = this.modifiers.get(entry.getFirst());
                double difference = oldAmount - modifierAmount;
                if (oldAmount > 0) {
                    this.modifiers.put(entry.getFirst(), Math.max(0, oldAmount - difference));
                } else {
                    this.modifiers.put(entry.getFirst(), Math.min(0, oldAmount - difference));
                }
            } else {
                this.modifiers.put(entry.getFirst(), modifierAmount);
            }
            tempAmount += modifierAmount;
        }
    }

    protected double getFinalAmount(double baseAmount) {
        double damage = baseAmount;
        for (Tuple<T, Function<? super Double, Double>> entry : this.modifierFunctions) {
            damage += checkNotNull(entry.getSecond().apply(damage));
        }
        return damage;
    }

    /**
     * Gets a list of all modifiers for this event.
     *
     * @return The list of modifiers and their functions
     */
    public final List<Tuple<T, Function<? super Double, Double>>> getModifiers() {
        ImmutableList.Builder<Tuple<T, Function<? super Double, Double>>> builder = ImmutableList.builder();
        for (Tuple<T, Function<? super Double, Double>> entry : this.modifierFunctions) {
            builder.add(new Tuple<>(entry.getFirst(), entry.getSecond()));
        }
        return builder.build();
    }
}
