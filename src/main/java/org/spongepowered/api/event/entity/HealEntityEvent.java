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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.entity.health.HealthModifier;
import org.spongepowered.api.event.cause.entity.health.source.HealingSource;
import org.spongepowered.api.event.impl.AbstractHealEntityEvent;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.util.annotation.eventgen.ImplementedBy;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * An event where an {@link Entity} is "healed". This can usually mean that
 * after a certain amount of "heal amount" the entity is destroyed. Similar to
 * the {@link DamageEntityEvent}, this event uses various modifiers
 */
@ImplementedBy(AbstractHealEntityEvent.class)
public interface HealEntityEvent extends TargetEntityEvent, Cancellable {

    /**
     * Gets the original amount to "heal" the targeted {@link Entity}.
     *
     * @return The original heal amount
     */
    double getOriginalHealAmount();

    /**
     * Gets the original "final" amount of healing after all original
     * {@link HealthModifier}s are applied to {@link #getOriginalHealAmount()} ()}.
     * The "final" heal amount is considered the amount gained by the
     * {@link Entity}, if health is tracked.
     *
     * @return The final amount of healing to originally deal
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    double getOriginalFinalHealAmount();

    /**
     * Gets an {@link Map} of all original {@link HealthModifier}s
     * and their associated "modified" heal amount. Note that ordering is not
     * retained.
     *
     * @return An immutable map of the original modified heal amounts
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    Map<HealthModifier, Double> getOriginalHealingAmounts();

    /**
     * Gets the final heal amount that will be applied to the entity. The
     * final heal amount is the end result of the {@link #getBaseHealAmount()}
     * being applied in {@link Function#apply(Object)} available from all
     * the {@link Tuple}s of {@link HealthModifier} to {@link Function} in
     * {@link #getOriginalFunctions()}.
     *
     * @return The final heal amount to deal
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    double getFinalHealAmount();

    /**
     * Gets the original healing amount for the provided
     * {@link HealthModifier}. If the provided {@link HealthModifier} was not
     * included in {@link #getOriginalHealingAmounts()}, an
     * {@link IllegalArgumentException} is thrown.
     *
     * @param healthModifier The original healing modifier
     * @return The original healing change
     */
    double getOriginalHealingModifierAmount(HealthModifier healthModifier);

    /**
     * Gets the original {@link List} of {@link HealthModifier} to
     * {@link Function} that was originally passed into the event.
     *
     * @return The list of heal amount modifier functions
     */
    List<Tuple<HealthModifier, Function<? super Double, Double>>> getOriginalFunctions();

    /**
     * Gets the "base" healing amount to apply to the targeted {@link Entity}.
     * The "base" heal amount is the original value before passing along the
     * chain of {@link Function}s for all known {@link HealthModifier}s.
     *
     * @return The base heal amount
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    double getBaseHealAmount();

    /**
     * Sets the "base" healing amount to apply to the targeted {@link Entity}.
     * The "base" heal amount is the original value passed along the chain of
     * {@link Function}s for all known {@link HealthModifier}s.
     *
     * @param healAmount The base heal amount
     */
    void setBaseHealAmount(double healAmount);

    /**
     * Checks whether the provided {@link HealthModifier} is applicable to the
     * current available {@link HealthModifier}s.
     *
     * @param healthModifier The health modifier to check
     * @return True if the health modifier is relevant to this event
     */
    boolean isModifierApplicable(HealthModifier healthModifier);

    /**
     * Gets the heal amount for the provided {@link HealthModifier}. Providing that
     * {@link #isModifierApplicable(HealthModifier)} returns <code>true</code>,
     * the cached "heal amount" for the {@link HealthModifier} is returned.
     *
     * @param healthModifier The heal amount modifier to get the heal amount for
     * @return The modifier
     */
    double getHealAmount(HealthModifier healthModifier);

    /**
     * ns the provided {@link Function} to be used for the given
     * {@link HealthModifier}. If the {@link HealthModifier} is already
     * included in {@link #getModifiers()}, the {@link Function} replaces
     * the existing function. If there is no {@link Tuple} for the
     * {@link HealthModifier}, a new one is created and added to the end
     * of the list of {@link Function}s to be applied to the
     * {@link #getBaseHealAmount()}.
     *
     * <p>If needing to create a custom {@link HealthModifier} is required,
     * usage of the
     * {@link org.spongepowered.api.event.cause.entity.health.HealthModifier.Builder}
     * is recommended.</p>
     *
     * @param healthModifier The heal amount modifier
     * @param function The function to map to the modifier
     */
    void setHealAmount(HealthModifier healthModifier, Function<? super Double, Double> function);

    /**
     * Gets a list of simple {@link Tuple}s of {@link HealthModifier} keyed to
     * their representative {@link Function}s. All {@link HealthModifier}s are
     * applicable to the entity based on the {@link HealingSource} and any
     * possible invulnerabilities due to the {@link HealingSource}.
     *
     * @return A list of heal amount modifiers to functions
     */
    @PropertySettings(requiredParameter = false, generateMethods = false)
    List<Tuple<HealthModifier, Function<? super Double, Double>>> getModifiers();

}
