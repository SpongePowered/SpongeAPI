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

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.event.cause.entity.damage.DamageFunction;
import org.spongepowered.api.event.cause.entity.damage.DamageModifier;
import org.spongepowered.api.event.cause.entity.damage.DamageModifierType;
import org.spongepowered.api.event.cause.entity.damage.ModifierFunction;
import org.spongepowered.api.event.entity.DamageEntityEvent;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.util.annotation.eventgen.UseField;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.DoubleUnaryOperator;

public abstract class AbstractDamageEntityEvent extends AbstractModifierEvent<DamageFunction, DamageModifier> implements DamageEntityEvent {

    @UseField protected double originalDamage;
    @UseField protected List<DamageFunction> originalFunctions;
    @UseField protected double baseDamage;

    @Override
    protected final void init() {
        this.originalFunctions = this.init(this.originalDamage, this.originalFunctions);
        this.baseDamage = this.originalDamage;
    }

    @Override
    public final double getOriginalModifierDamage(DamageModifier damageModifier) {
        Objects.requireNonNull(damageModifier, "The damage modifier cannot be null!");
        for (Tuple<DamageModifier, Double> tuple : this.originalModifiers) {
            if (tuple.getFirst().equals(damageModifier)) {
                return tuple.getSecond();
            }
        }
        throw new IllegalArgumentException("The provided damage modifier is not applicable: " + damageModifier.toString());
    }

    @Override
    public final double getOriginalFinalDamage() {
        return this.originalFinalAmount;
    }

    @Override
    public final Map<DamageModifier, Double> getOriginalDamages() {

        return this.originalModifierMap;
    }

    @Override
    public final double getFinalDamage() {
        return this.getFinalAmount(this.baseDamage);
    }

    @Override
    public final boolean isModifierApplicable(DamageModifier damageModifier) {
        return this.modifiers.containsKey(Objects.requireNonNull(damageModifier));
    }

    @Override
    public final double getDamage(DamageModifier damageModifier) {
        if (!this.modifiers.containsKey(Objects.requireNonNull(damageModifier, "Damage Modifier cannot be null!"))) {
            throw new IllegalArgumentException("The provided damage modifier is not applicable: " + damageModifier.toString());
        }
        return this.modifiers.get(Objects.requireNonNull(damageModifier));
    }

    @Override
    public final void setDamage(DamageModifier damageModifier, DoubleUnaryOperator function) {
        Objects.requireNonNull(damageModifier, "Damage modifier was null!");
        Objects.requireNonNull(function, "Function was null!");
        int indexToAddTo = 0;
        boolean addAtEnd = true;
        for (Iterator<DamageFunction> iterator = this.modifierFunctions.iterator(); iterator.hasNext(); ) {
            ModifierFunction<DamageModifier> tuple = iterator.next();
            if (tuple.getModifier().equals(damageModifier)) {
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
        this.recalculateDamages(this.baseDamage);
    }

    @Override
    public void addDamageModifierBefore(DamageModifier damageModifier, DoubleUnaryOperator function, Set<DamageModifierType> before) {
        Objects.requireNonNull(damageModifier, "Damage modifier was null!");
        Objects.requireNonNull(function, "Function was null!");
        int indexToAddBefore = -1;
        int index = 0;
        for (ModifierFunction<DamageModifier> tuple : this.modifierFunctions) {
            if (tuple.getModifier().equals(damageModifier)) {
                throw new IllegalArgumentException("Cannot add a duplicate modifier");
            }
            if (before.contains(tuple.getModifier().getType())) {
                indexToAddBefore = index;
            }
            index++;

        }
        if (indexToAddBefore == -1) {
            this.modifierFunctions.add(new DamageFunction(damageModifier, function));
        } else {
            this.modifierFunctions.add(indexToAddBefore, new DamageFunction(damageModifier, function));
        }
        this.recalculateDamages(this.baseDamage);
    }

    @Override
    public void addModifierAfter(DamageModifier damageModifier, DoubleUnaryOperator function, Set<DamageModifierType> after) {
        Objects.requireNonNull(damageModifier, "Damage modifier was null!");
        Objects.requireNonNull(function, "Function was null!");
        int indexToAddAfter = -1;
        int index = 0;
        for (ModifierFunction<DamageModifier> tuple : this.modifierFunctions) {
            if (tuple.getModifier().equals(damageModifier)) {
                throw new IllegalArgumentException("Cannot add a duplicate modifier");
            }
            if (after.contains(tuple.getModifier().getType())) {
                indexToAddAfter = index;
            }
            index++;

        }
        if (indexToAddAfter == -1) {
            this.modifierFunctions.add(new DamageFunction(damageModifier, function));
        } else {
            this.modifierFunctions.add(indexToAddAfter + 1, new DamageFunction(damageModifier, function));
        }
        this.recalculateDamages(this.baseDamage);
    }

    @Override
    protected DamageFunction convertTuple(DamageModifier obj, DoubleUnaryOperator function) {
        return new DamageFunction(obj, function);
    }

    @Override
    public List<DamageFunction> getModifiers() {
        ImmutableList.Builder<DamageFunction> builder = ImmutableList.builder();
        for (ModifierFunction<DamageModifier> entry : this.modifierFunctions) {
            if (entry instanceof DamageFunction) {
                builder.add((DamageFunction) entry);
            } else {
                builder.add(new DamageFunction(entry.getModifier(), entry.getFunction()));
            }
        }
        return builder.build();
    }

    @Override
    public double getBaseDamage() {
        return this.baseDamage;
    }

    @Override
    public final void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
        this.recalculateDamages(this.baseDamage);
    }

    @Override
    public boolean willCauseDeath() {
        Optional<Double> health = getEntity().get(Keys.HEALTH.get());
        return health.isPresent() && health.get() - getFinalDamage() <= 0;
    }

}
