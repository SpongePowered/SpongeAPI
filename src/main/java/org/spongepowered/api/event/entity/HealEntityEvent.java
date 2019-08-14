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
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.util.annotation.eventgen.ImplementedBy;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

import java.util.List;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;

/**
 * An event where an {@link Entity} is "healed". This can usually mean that
 * after a certain amount of "heal amount" the entity is destroyed. Similar to
 * the {@link DamageEntityEvent}, this event uses various modifiers
 * @deprecated Not actually implemented, an oversight. Will be removed in API 8
 */
@SuppressWarnings({"DeprecatedIsStillUsed", "deprecation"})
@Deprecated
@ImplementedBy(org.spongepowered.api.event.impl.AbstractHealEntityEvent.class)
public interface HealEntityEvent extends TargetEntityEvent, Cancellable {

    /**
     * Gets the original amount to "heal" the targeted {@link Entity}.
     *
     * @return The original heal amount
     * @deprecated Not actually implemented, an oversight. Will be removed in API 8
     */
    @Deprecated
    double getOriginalHealAmount();

    /**
     * Gets the original "final" amount of healing after all original
     * {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier}s are applied to {@link #getOriginalHealAmount()}.
     * The "final" heal amount is considered the amount gained by the
     * {@link Entity}, if health is tracked.
     *
     * @return The final amount of healing to originally deal
     * @deprecated Not actually implemented, an oversight. Will be removed in API 8
     */
    @Deprecated
    @PropertySettings(requiredParameter = false, generateMethods = false)
    double getOriginalFinalHealAmount();

    /**
     * Gets an {@link Map} of all original {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier}s and their
     * associated "modified" heal amount. Note that ordering is not retained.
     *
     * @return An immutable map of the original modified heal amounts
     * @deprecated Not actually implemented, an oversight. Will be removed in API 8
     */
    @Deprecated
    @PropertySettings(requiredParameter = false, generateMethods = false)
    Map< org.spongepowered.api.event.cause.entity.health.HealthModifier, Double> getOriginalHealingAmounts();

    /**
     * Gets the final heal amount that will be applied to the entity. The final
     * heal amount is the end result of the {@link #getBaseHealAmount()} being
     * applied in {@link DoubleUnaryOperator#applyAsDouble(double)} available
     * from all the {@link Tuple}s of {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier} to
     * {@link DoubleUnaryOperator} in {@link #getOriginalFunctions()}.
     *
     * @return The final heal amount to deal
     * @deprecated Not actually implemented, an oversight. Will be removed in API 8
     */
    @Deprecated
    @PropertySettings(requiredParameter = false, generateMethods = false)
    double getFinalHealAmount();

    /**
     * Gets the original healing amount for the provided {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier}.
     * If the provided {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier} was not included in
     * {@link #getOriginalHealingAmounts()}, an {@link IllegalArgumentException}
     * is thrown.
     *
     * @param healthModifier The original healing modifier
     * @return The original healing change
     * @deprecated Not actually implemented, an oversight. Will be removed in API 8
     */
    @Deprecated
    double getOriginalHealingModifierAmount( org.spongepowered.api.event.cause.entity.health.HealthModifier healthModifier);

    /**
     * Gets the original {@link List} of {@link org.spongepowered.api.event.cause.entity.health.HealthFunction}s that was
     * originally passed into the event.
     *
     * @return The list of heal amount modifier functions
     */
    List<org.spongepowered.api.event.cause.entity.health.HealthFunction> getOriginalFunctions();

    /**
     * Gets the "base" healing amount to apply to the targeted {@link Entity}.
     * The "base" heal amount is the original value before passing along the
     * chain of {@link DoubleUnaryOperator}s for all known
     * {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier}s.
     *
     * @return The base heal amount
     * @deprecated Not actually implemented, an oversight. Will be removed in API 8
     */
    @Deprecated
    @PropertySettings(requiredParameter = false, generateMethods = false)
    double getBaseHealAmount();

    /**
     * Sets the "base" healing amount to apply to the targeted {@link Entity}.
     * The "base" heal amount is the original value passed along the chain of
     * {@link DoubleUnaryOperator}s for all known {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier}s.
     *
     * @param healAmount The base heal amount
     * @deprecated Not actually implemented, an oversight. Will be removed in API 8
     */
    @Deprecated
    void setBaseHealAmount(double healAmount);

    /**
     * Checks whether the provided {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier} is applicable to the
     * current available {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier}s.
     *
     * @param healthModifier The health modifier to check
     * @return True if the health modifier is relevant to this event
     * @deprecated Not actually implemented, an oversight. Will be removed in API 8
     */
    @Deprecated
    boolean isModifierApplicable( org.spongepowered.api.event.cause.entity.health.HealthModifier healthModifier);

    /**
     * Gets the heal amount for the provided {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier}. Providing
     * that {@link #isModifierApplicable( org.spongepowered.api.event.cause.entity.health.HealthModifier)} returns
     * <code>true</code>, the cached "heal amount" for the
     * {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier} is returned.
     *
     * @param healthModifier The heal amount modifier to get the heal amount for
     * @return The modifier
     * @deprecated Not actually implemented, an oversight. Will be removed in API 8
     */
    @Deprecated
    double getHealAmount(org.spongepowered.api.event.cause.entity.health.HealthModifier healthModifier);

    /**
     * Sets the provided {@link DoubleUnaryOperator} to be used for the given
     * {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier}. If the {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier} is already included
     * in {@link #getModifiers()}, the {@link DoubleUnaryOperator} replaces the
     * existing function. If there is no {@link org.spongepowered.api.event.cause.entity.health.HealthFunction} for the
     * {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier}, a new one is created and added to the end of the
     * list of {@link DoubleUnaryOperator}s to be applied to the
     * {@link #getBaseHealAmount()}.
     *
     * <p>If needing to create a custom {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier} is required,
     * usage of the
     * {@link org.spongepowered.api.event.cause.entity.health.HealthModifier.Builder}
     * is recommended.</p>
     *
     * @param healthModifier The heal amount modifier
     * @param function The function to map to the modifier
     * @deprecated Not actually implemented, an oversight. Will be removed in API 8
     */
    @Deprecated
    void setHealAmount( org.spongepowered.api.event.cause.entity.health.HealthModifier healthModifier, DoubleUnaryOperator function);

    /**
     * Gets a list of simple {@link org.spongepowered.api.event.cause.entity.health.HealthFunction}s. All {@link  org.spongepowered.api.event.cause.entity.health.HealthModifier}
     * s are applicable to the entity based on the {@link org.spongepowered.api.event.cause.entity.health.source.HealingSource} and any
     * possible invulnerabilities due to the {@link org.spongepowered.api.event.cause.entity.health.source.HealingSource}.
     *
     * @return A list of heal amount modifiers to functions
     * @deprecated Not actually implemented, an oversight. Will be removed in API 8
     */
    @Deprecated
    @PropertySettings(requiredParameter = false, generateMethods = false)
    List<org.spongepowered.api.event.cause.entity.health.HealthFunction> getModifiers();

}
