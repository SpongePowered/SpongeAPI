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

import com.google.common.base.Function;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.cause.entity.damage.DamageModifier;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.util.Tuple;

import java.util.List;

/**
 * An event that is specifically called prior to the {@link EntityDamageEvent}
 * such that the damage that will be dealt is modified based on various
 * {@link DamageModifier}s.
 *
 * <p>Examples of when this event is used: A skeleton's arrow hitting an
 * {@link Entity}, A player attacking another {@link Entity}.</p>
 *
 * <p>With this event, all {@link DamageModifier}s are modifying the damage
 * being dealt by the attacker, examples include: {@link Enchantment}s,
 * {@link PotionEffect}s, etc.</p>
 */
public interface EntityPreDamageEvent extends EntityEvent, CauseTracked, Cancellable {

    double getOriginalDamage();

    double getBaseDamage();

    void setBaseDamage(double baseDamage);

    /**
     * Gets the final damage that will be passed in to the
     * {@link EntityDamageEvent}.
     *
     * @return The new health.
     */
    double getFinalDamage();

    /**
     * Sets the new health of the {@link Entity}.
     *
     * @param newHealth The new health
     */
    void setDamage(double newHealth);

    double getOriginalDamage(DamageModifier damageModifier);

    double getDamage(DamageModifier damageModifier);

    void setDamage(DamageModifier damageModifier, double damage);

    void setDamageFunction(DamageModifier damageFunction, Function<? super Double, Double> function);

    /**
     * Gets a list of simple {@link Tuple}s of {@link DamageModifier} keyed to
     * their representative {@link Function}s. All {@link DamageModifier}s are
     * applicable to the entity based on the {@link DamageSource} and any
     * possible invulnerabilities due to the {@link DamageSource}.
     *
     * @return A list of damage modifiers to functions
     */
    List<Tuple<DamageModifier, Function<? super Double, Double>>> getModifiers();

    void setModifierFunctions(List<Tuple<DamageModifier, Function<? super Double, Double>>> functions);


}
