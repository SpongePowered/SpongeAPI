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

import org.spongepowered.api.event.cause.entity.health.HealthModifier;
import org.spongepowered.api.event.entity.HealEntityEvent;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.util.annotation.eventgen.UseField;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public abstract class AbstractHealEntityEvent extends AbstractModifierEvent<HealthModifier> implements HealEntityEvent {

    @UseField
    protected double originalHealAmount;
    @UseField protected List<Tuple<HealthModifier, Function<? super Double, Double>>> originalFunctions;

    @UseField protected double baseHealAmount;

    @Override
    protected final void init() {
        this.originalFunctions = this.init(this.originalHealAmount, this.originalFunctions);
        this.baseHealAmount = this.originalHealAmount;
    }

    @Override
    public final double getOriginalHealingModifierAmount(HealthModifier healthModifier) {
        checkArgument(this.originalModifierMap.containsKey(checkNotNull(healthModifier)), "The provided damage modifier is not applicable : "
                + healthModifier.toString());
        return this.originalModifierMap.get(checkNotNull(healthModifier));
    }

    @Override
    public final double getOriginalFinalHealAmount() {
        return this.originalFinalAmount;
    }

    @Override
    public final Map<HealthModifier, Double> getOriginalHealingAmounts() {
        return this.originalModifierMap;
    }

    @Override
    public final double getFinalHealAmount() {
        return this.getFinalAmount(this.baseHealAmount);
    }

    @Override
    public final boolean isModifierApplicable(HealthModifier healthModifier) {
        return this.modifiers.containsKey(checkNotNull(healthModifier));
    }

    @Override
    public final double getHealAmount(HealthModifier healthModifier) {
        checkArgument(this.modifiers.containsKey(checkNotNull(healthModifier)), "The provided damage modifier is not applicable : "
                + healthModifier.toString());
        return this.modifiers.get(checkNotNull(healthModifier));
    }

    @Override
    public final void setHealAmount(HealthModifier healthModifier, Function<? super Double, Double> function) {
        checkNotNull(healthModifier, "Damage modifier was null!");
        checkNotNull(function, "Function was null!");
        int indexToAddTo = 0;
        boolean addAtEnd = true;
        for (Iterator<Tuple<HealthModifier, Function<? super Double, Double>>> iterator = this.modifierFunctions.iterator(); iterator.hasNext(); ) {
            Tuple<HealthModifier, Function<? super Double, Double>> tuple = iterator.next();
            if (tuple.getFirst().equals(healthModifier)) {
                iterator.remove();
                addAtEnd = false;
                break;
            }
            indexToAddTo++;
        }
        if (addAtEnd) {
            this.modifierFunctions.add(new Tuple<>(healthModifier, function));
        } else {
            this.modifierFunctions.add(indexToAddTo, new Tuple<>(healthModifier, function));
        }
        this.recalculateDamages(this.baseHealAmount);
    }

    @Override
    public double getBaseHealAmount() {
        return this.baseHealAmount;
    }

    @Override
    public final void setBaseHealAmount(double baseHealAmount) {
        this.baseHealAmount = baseHealAmount;
        this.recalculateDamages(this.baseHealAmount);
    }

}
