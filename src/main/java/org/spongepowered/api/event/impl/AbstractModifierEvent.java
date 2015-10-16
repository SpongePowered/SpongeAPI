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
import org.spongepowered.api.eventgencore.annotation.UseField;
import org.spongepowered.api.util.Tuple;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * An abstract base class for implementations of {@link DamageEntityEvent} and {@link HealEntityEvent}
 * @param <T> The modifier type to use
 */
public class AbstractModifierEvent<T> extends AbstractEvent {

    protected double originalFinalAmount;
    protected Map<T, Double> originalModifiers;
    @UseField protected final LinkedHashMap<T, Double> modifiers = Maps.newLinkedHashMap();
    protected final LinkedHashMap<T, Function<? super Double, Double>> modifierFunctions = Maps.newLinkedHashMap();

    protected ImmutableList<Tuple<T, Function<? super Double, Double>>> init(double originalValue, List<Tuple<T, Function<? super Double, Double>>> originalFunctions) {
        final double damage = originalValue;
        final ImmutableMap.Builder<T, Double> modifierMapBuilder = ImmutableMap.builder();
        final ImmutableList.Builder<Tuple<T, Function<? super Double, Double>>> functionListBuilder = ImmutableList.builder();
        double finalDamage = damage;
        for (Tuple<T, Function<? super Double, Double>> tuple : originalFunctions) {
            this.modifierFunctions.put(tuple.getFirst(), tuple.getSecond());
            double tempDamage = checkNotNull(tuple.getSecond().apply(finalDamage));
            finalDamage += tempDamage;
            modifierMapBuilder.put(tuple.getFirst(), tempDamage);
            this.modifiers.put(tuple.getFirst(), tempDamage);
            functionListBuilder.add(tuple);
        }
        this.originalFinalAmount = finalDamage;
        this.originalModifiers = modifierMapBuilder.build();
        return functionListBuilder.build();
    }

    protected void recalculateDamages(double baseAmount) {
        double tempAmount = baseAmount;
        for (Map.Entry<T, Function<? super Double, Double>> entry : this.modifierFunctions.entrySet()) {
            double modifierAmount = checkNotNull(entry.getValue().apply(tempAmount));
            if (modifiers.containsKey(entry.getKey())) {
                double oldAmount = this.modifiers.get(entry.getKey());
                double difference = oldAmount - modifierAmount;
                if (oldAmount > 0) {
                    this.modifiers.put(entry.getKey(), Math.max(0, oldAmount - difference));
                } else {
                    this.modifiers.put(entry.getKey(), Math.min(0, oldAmount - difference));
                }
            } else {
                this.modifiers.put(entry.getKey(), modifierAmount);
            }
            tempAmount += modifierAmount;
        }
    }

    protected double getFinalAmount(double baseAmount) {
        double damage = baseAmount;
        for (Map.Entry<T, Function<? super Double, Double>> entry : this.modifierFunctions.entrySet()) {
            damage += checkNotNull(entry.getValue().apply(damage));
        }
        return damage;
    }

    public final List<Tuple<T, Function<? super Double, Double>>> getModifiers() {
        ImmutableList.Builder<Tuple<T, Function<? super Double, Double>>> builder = ImmutableList.builder();
        for (Map.Entry<T, Function<? super Double, Double>> entry : this.modifierFunctions.entrySet()) {
            builder.add(new Tuple<>(entry.getKey(), entry.getValue()));
        }
        return builder.build();
    }

}
