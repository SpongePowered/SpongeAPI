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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.spongepowered.api.event.cause.entity.damage.DamageModifier;
import org.spongepowered.api.event.entity.InteractEntityEvent;
import org.spongepowered.api.eventgencore.annotation.SetField;
import org.spongepowered.api.util.Tuple;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractAttackEntityEvent extends AbstractEvent implements InteractEntityEvent.Attack {

    @SetField(isRequired = true) protected double originalDamage;
    @SetField(isRequired = true) protected List<Tuple<DamageModifier, Function<? super Double, Double>>> originalFunctions;
    @SetField protected double originalFinalDamage;
    @SetField protected Map<DamageModifier, Double> originalModifiers;
    @SetField protected final LinkedHashMap<DamageModifier, Double> modifiers = Maps.newLinkedHashMap();
    @SetField protected final LinkedHashMap<DamageModifier, Function<? super Double, Double>> modifierFunctions = Maps.newLinkedHashMap();
    @SetField protected double baseDamage;

    // These are left unused on purpose, because Aaron101 is too lazy to change the event generator.
    // They prevent their respective fields from being required in the event factory generator
    @SetField protected double finalDamage;
    @SetField protected Map<DamageModifier, Double> originalDamages;

    @Override
    protected final void init() {
        final double damage = this.originalDamage;
        final ImmutableMap.Builder<DamageModifier, Double> modifierMapBuilder = ImmutableMap.builder();
        final ImmutableList.Builder<Tuple<DamageModifier, Function<? super Double, Double>>> functionListBuilder = ImmutableList.builder();
        double finalDamage = damage;
        for (Tuple<DamageModifier, Function<? super Double, Double>> tuple : this.originalFunctions) {
            this.modifierFunctions.put(tuple.getFirst(), tuple.getSecond());
            double tempDamage = checkNotNull(tuple.getSecond().apply(finalDamage));
            finalDamage += tempDamage;
            modifierMapBuilder.put(tuple.getFirst(), tempDamage);
            this.modifiers.put(tuple.getFirst(), tempDamage);
            functionListBuilder.add(tuple);
        }
        this.originalFinalDamage = finalDamage;
        this.originalModifiers = modifierMapBuilder.build();
        this.originalFunctions = functionListBuilder.build();
    }

    private void recalculateDamages() {
        double tempDamage = this.baseDamage;
        for (Map.Entry<DamageModifier, Function<? super Double, Double>> entry : this.modifierFunctions.entrySet()) {
            double oldDamage = this.modifiers.get(entry.getKey());
            double modifierDamage = checkNotNull(entry.getValue().apply(tempDamage));
            double difference = oldDamage - modifierDamage;
            if (oldDamage > 0) {
                this.modifiers.put(entry.getKey(), Math.max(0, oldDamage - difference));
            } else {
                this.modifiers.put(entry.getKey(), Math.min(0, oldDamage - difference));
            }
            tempDamage += modifierDamage;
        }
    }

    @Override
    public final double getOriginalDamage() {
        return this.originalDamage;
    }

    @Override
    public final double getOriginalModifierDamage(DamageModifier damageModifier) {
        checkArgument(this.originalModifiers.containsKey(checkNotNull(damageModifier)), "The provided damage modifier is not applicable : "
                + damageModifier.toString());
        return this.originalModifiers.get(checkNotNull(damageModifier));
    }

    @Override
    public final Map<DamageModifier, Double> getOriginalDamages() {
        return this.originalModifiers;
    }

    @Override
    public final List<Tuple<DamageModifier, Function<? super Double, Double>>> getOriginalFunctions() {
        return this.originalFunctions;
    }

    @Override
    public final double getOriginalFinalDamage() {
        return this.originalFinalDamage;
    }

    @Override
    public final double getBaseDamage() {
        return this.baseDamage;
    }

    @Override
    public final void setBaseDamage(double baseDamage) {
        this.baseDamage = baseDamage;
    }

    @Override
    public final double getFinalDamage() {
        double damage = this.baseDamage;
        for (Map.Entry<DamageModifier, Function<? super Double, Double>> entry : this.modifierFunctions.entrySet()) {
            damage += checkNotNull(entry.getValue().apply(damage));
        }
        return damage;
    }

    @Override
    public final boolean isModifierApplicable(DamageModifier damageModifier) {
        return this.modifiers.containsKey(checkNotNull(damageModifier));
    }

    @Override
    public final double getDamage(DamageModifier damageModifier) {
        checkArgument(this.modifierFunctions.containsKey(checkNotNull(damageModifier)), "The provided damage modifier is not applicable : "
                + damageModifier.toString());
        return this.modifiers.get(checkNotNull(damageModifier));
    }

    @Override
    public final void setDamage(DamageModifier damageModifier, Function<? super Double, Double> function) {
        this.modifierFunctions.put(checkNotNull(damageModifier), checkNotNull(function));
        recalculateDamages();
    }

    @Override
    public final List<Tuple<DamageModifier, Function<? super Double, Double>>> getModifiers() {
        ImmutableList.Builder<Tuple<DamageModifier, Function<? super Double, Double>>> builder = ImmutableList.builder();
        for (Map.Entry<DamageModifier, Function<? super Double, Double>> entry : this.modifierFunctions.entrySet()) {
            builder.add(new Tuple<>(entry.getKey(), entry.getValue()));
        }
        return builder.build();
    }

}
