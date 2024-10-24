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

import org.spongepowered.api.event.cause.entity.damage.DamageFunction;
import org.spongepowered.api.event.cause.entity.damage.DamageModifier;
import org.spongepowered.api.event.cause.entity.damage.DamageModifierType;
import org.spongepowered.api.event.cause.entity.damage.ModifierFunction;
import org.spongepowered.api.event.entity.AttackEntityEvent;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.util.annotation.eventgen.UseField;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractAttackEntityEvent extends AbstractModifierEvent<DamageFunction, DamageModifier> implements AttackEntityEvent {

    @UseField protected double originalDamage;
    @UseField protected List<DamageFunction> originalFunctions;

    @UseField protected double baseDamage;

    @Override
    protected final void init() {
        this.originalFunctions = this.init(this.originalDamage, this.originalFunctions);
        this.baseDamage = this.originalDamage;
    }

    @Override
    public final Tuple<Double, Double> originalModifierDamage(final DamageModifier damageModifier) {
        Objects.requireNonNull(damageModifier, "Damage modifier cannot be null!");
        for (final var tuple : this.originalModifiers) {
            if (tuple.first().equals(damageModifier)) {
                return tuple.second();
            }
        }
        throw new IllegalArgumentException("The provided damage modifier is not applicable: " + damageModifier.toString());
    }

    @Override
    public final double originalFinalDamage() {
        return this.originalFinalAmount;
    }

    @Override
    public final Map<DamageModifier, Tuple<Double, Double>> originalDamages() {

        return this.originalModifierMap;
    }

    @Override
    public final double finalOutputDamage() {
        return this.finalAmount(this.baseDamage);
    }

    @Override
    public final boolean isModifierApplicable(final DamageModifier damageModifier) {
        return this.modifiers.containsKey(Objects.requireNonNull(damageModifier));
    }

    @Override
    public final Tuple<Double, Double> outputDamage(final DamageModifier damageModifier) {
        if (!this.modifiers.containsKey(Objects.requireNonNull(damageModifier, "Damage Modifier cannot be null!"))) {
            throw new IllegalArgumentException("The provided damage modifier is not applicable: " + damageModifier.toString());
        }
        return this.modifiers.get(Objects.requireNonNull(damageModifier));
    }

    @Override
    public final void setOutputDamage(final DamageModifier damageModifier, final DoubleUnaryOperator function) {
        Objects.requireNonNull(damageModifier, "Damage modifier was null!");
        Objects.requireNonNull(function, "Function was null!");
        int indexToAddTo = 0;
        boolean addAtEnd = true;
        for (final Iterator<DamageFunction> iterator = this.modifierFunctions.iterator(); iterator.hasNext(); ) {
            final ModifierFunction<DamageModifier> tuple = iterator.next();
            if (tuple.modifier().equals(damageModifier)) {
                iterator.remove();
                addAtEnd = false;
                break;
            }
            indexToAddTo++;
        }
        if (addAtEnd) {
            this.modifierFunctions.add(new DamageFunction(damageModifier, function));
        } else {
            this.modifierFunctions.add(indexToAddTo, new DamageFunction(damageModifier, function));
        }
        this.recalculate(this.baseDamage);
    }

    @Override
    public void addDamageModifierBefore(final DamageModifier damageModifier, final DoubleUnaryOperator function, final Set<DamageModifierType> before) {
        Objects.requireNonNull(damageModifier, "Damage modifier was null!");
        Objects.requireNonNull(function, "Function was null!");
        int indexToAddBefore = -1;
        int index = 0;
        for (final ModifierFunction<DamageModifier> tuple : this.modifierFunctions) {
            if (tuple.modifier().equals(damageModifier)) {
                throw new IllegalArgumentException("Cannot add a duplicate modifier");
            }
            if (before.contains(tuple.modifier().type())) {
                indexToAddBefore = index;
            }
            index++;

        }
        if (indexToAddBefore == -1) {
            this.modifierFunctions.add(new DamageFunction(damageModifier, function));
        } else {
            this.modifierFunctions.add(indexToAddBefore, new DamageFunction(damageModifier, function));
        }
        this.recalculate(this.baseDamage);
    }

    @Override
    public void addDamageModifierAfter(final DamageModifier damageModifier, final DoubleUnaryOperator function, final Set<DamageModifierType> after) {
        Objects.requireNonNull(damageModifier, "Damage modifier was null!");
        Objects.requireNonNull(function, "Function was null!");
        int indexToAddAfter = -1;
        int index = 0;
        for (final ModifierFunction<DamageModifier> tuple : this.modifierFunctions) {
            if (tuple.modifier().equals(damageModifier)) {
                throw new IllegalArgumentException("Cannot add a duplicate modifier");
            }
            if (after.contains(tuple.modifier().type())) {
                indexToAddAfter = index;
            }
            index++;

        }
        if (indexToAddAfter == -1) {
            this.modifierFunctions.add(new DamageFunction(damageModifier, function));
        } else {
            this.modifierFunctions.add(indexToAddAfter + 1, new DamageFunction(damageModifier, function));
        }
        this.recalculate(this.baseDamage);
    }

    @Override
    public double baseOutputDamage() {
        return this.baseDamage;
    }

    @Override
    public final void setBaseOutputDamage(final double baseDamage) {
        this.baseDamage = baseDamage;
        this.recalculate(this.baseDamage);
    }

    @Override
    protected DamageFunction convertTuple(final DamageModifier obj, final DoubleUnaryOperator function) {
        return new DamageFunction(obj, function);
    }

    @Override
    public List<DamageFunction> modifiers() {
        return this.modifierFunctions.stream().map((Function<ModifierFunction<DamageModifier>, DamageFunction>) entry -> {
            if (entry instanceof DamageFunction) {
                return (DamageFunction) entry;
            } else {
                return new DamageFunction(entry.modifier(), entry.function());
            }
        }).collect(Collectors.toUnmodifiableList());
    }
}
