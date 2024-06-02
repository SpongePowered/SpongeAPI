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
package org.spongepowered.api.event.impl.entity;

import org.spongepowered.api.event.cause.entity.damage.DamageModifier;
import org.spongepowered.api.event.cause.entity.damage.ModifierFunction;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.event.impl.AbstractEvent;
import org.spongepowered.api.util.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

/**
 * An abstract base class for implementations of {@link DamageEntityEvent}.
 *
 * @param <T> The modifier type to use
 */
public abstract class AbstractModifierEvent<T extends ModifierFunction<M>, M> extends AbstractEvent {

    protected double originalFinalAmount;
    protected List<Tuple<M, Tuple<Double, Double>>> originalModifiers;
    protected Map<M, Tuple<Double, Double>> originalModifierMap;
    protected final LinkedHashMap<M, Tuple<Double, Double>> modifiers = new LinkedHashMap<>();
    protected final List<T> modifierFunctions = new ArrayList<>();

    protected List<T> init(double baseAmount, List<T> functions) {
        functions.stream().map(entry -> this.convertTuple(entry.modifier(), entry.function())).forEach(this.modifierFunctions::add);
        this.originalFinalAmount = this.recalculate(baseAmount);
        this.originalModifiers = this.modifiers.entrySet().stream().map(e -> new Tuple<>(e.getKey(), e.getValue())).toList();
        this.originalModifierMap = Map.copyOf(this.modifiers);
        return functions.stream().map(entry -> this.convertTuple(entry.modifier(), entry.function())).toList();
    }

    protected abstract T convertTuple(M obj, DoubleUnaryOperator function);

    protected double recalculate(final double baseAmount) {
        final var amounts = AbstractModifierEvent.recalculate(this.modifierFunctions, baseAmount, this.modifiers);
        return amounts.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    private static <T extends ModifierFunction<M>, M> Map<String, Double> recalculate(final List<T> functions, final double baseAmount, final Map<M, Tuple<Double, Double>> into) {
        into.clear();
        final var defaultGroup = "default";
        final Map<String, Double> amounts = new HashMap<>();
        for (T func : functions) {
            var group = defaultGroup;
            if (func.modifier() instanceof DamageModifier damageModifier) {
                group = damageModifier.group();
            }
            final var oldAmount = amounts.getOrDefault(group, baseAmount);
            final var newAmount = func.function().applyAsDouble(oldAmount);
            amounts.put(group, newAmount);
            into.put(func.modifier(), new Tuple<>(oldAmount, newAmount));
        }
        if (amounts.isEmpty()) {
            amounts.put(defaultGroup, baseAmount);
        }
        return amounts;
    }

    protected double finalAmount(final double baseAmount) {
        final var amounts = AbstractModifierEvent.finalAmounts(baseAmount, this.modifierFunctions);
        return amounts.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public static <T extends ModifierFunction<M>, M> Map<String, Double> finalAmounts(final double baseAmount, final List<T> modifiers) {
        return AbstractModifierEvent.recalculate(modifiers, baseAmount, new LinkedHashMap<>());
    }

    /**
     * Gets the modifiers affecting this event.
     *
     * @return The list of modifiers
     */
    public List<T> modifiers() {
        return List.copyOf(this.modifierFunctions);
    }
}
