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
import com.google.common.collect.ImmutableMap;
import org.spongepowered.api.attribute.Attribute;
import org.spongepowered.api.block.tileentity.carrier.Dispenser;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.monster.Skeleton;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.Arrow;
import org.spongepowered.api.event.AbstractDamageEntityEvent;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.cause.entity.damage.DamageModifier;
import org.spongepowered.api.event.cause.entity.damage.DamageModifierBuilder;
import org.spongepowered.api.event.cause.entity.damage.DamageModifierType;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.event.cause.entity.damage.source.EntityDamageSource;
import org.spongepowered.api.event.entity.living.LivingEvent;
import org.spongepowered.api.event.entity.living.human.HumanEvent;
import org.spongepowered.api.event.entity.living.player.PlayerEvent;
import org.spongepowered.api.eventgencore.annotation.ImplementedBy;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.Tuple;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.difficulty.Difficulties;
import org.spongepowered.api.world.difficulty.Difficulty;

import java.util.List;
import java.util.Map;

/**
 * Represents the base event for when an {@link Entity} is being "attacked".
 * The uniqueness of this event is that all {@link DamageSource}s can deal
 * varying amounts of damage with varying modifiers based on various reasons.
 * Due to this ambiguous variety of information that is possible to provide,
 * the {@link InteractEntityEvent.Attack} can be summarized as so:
 *
 * <p>An {@link Arrow},
 *  that was shot by a {@link Skeleton},
 *    with an enchanted {@link ItemTypes#BOW} {@link ItemStack},
 *  when the {@link World} {@link Difficulty} was set to
 *  {@link Difficulties#HARD},
 * will deal possibly "5" damage to any {@link Entity} it hits.
 * </p>
 *
 * <p>The issue with representing this type of "logic flow" is that a
 * particular amount of damage from a {@link DamageSource}, even if specified
 * to a particular {@link DamageType}, has no static finalized amount of damage
 * to deal to a particular {@link Entity}. To properly represent this,
 * a {@link DamageSource} has various "states" such as:
 * {@link DamageSource#isAbsolute()}, or {@link DamageSource#isBypassingArmor()}.
 * Quite simply, the {@link DamageSource} will always be the "first" element
 * within a {@link Cause} that can be retrieved from {@link #getCause()}.</p>
 *
 * <p>Next, any additional "aides" in attacking the {@link Entity} will
 * be included in order of "priority of relation" to "attacking" the entity. In
 * short, if another {@link Entity} is considered a "team member" to the
 * attacking {@link Entity}, the "team member" may be a second element within
 * the {@link Cause}. The same can be said if an {@link Arrow} was shot from
 * a {@link Dispenser} that was triggered by a {@link Player} flipping a
 * switch.</p>
 *
 * <p>Continuing with the notion of "modifiers" to damage, the "base" damage
 * is modified or added onto after various unknown methods are called or
 * processed on the damage. Optimally, these modifiers can be traced to a
 * particular object, be it an {@link ItemStack}, {@link Difficulty}, or
 * simply an {@link Attribute}. The interesting part is that these "modifiers"
 * do not just define a static value to add to the "base" damage, they
 * are usually a loose form of a {@link Function} that are applied to
 * the "base" damage. Given that {@link Cause} has a unique capability of
 * storing any and every {@link Object} willing to be passed into it, we
 * can easily represent these "sources" of "modifiers" in a {@link Cause}.
 * Now, knowning the "source" will not provide enough information, so a
 * {@link DamageModifierType} is provided with a {@link DamageModifier} to
 * paint the fullest picture of "explaining" the {@link DamageModifier} as to
 * why it is present, and why it is "modifying" the "base" damage. Finally,
 * we can associate a {@link DamageModifier} with a {@link Function} that is
 * passed the current "damage" into {@link Function#apply(Object)}, being added
 * to the current "damage". After all {@link DamageModifier} {@link Function}s
 * are "applied", the overall "damage" is now the final damage to actually
 * throw a {@link DamageEntityEvent}.</p>
 *
 * <p>Note that due to the mechanics of the game, {@link DamageModifier}s
 * are always ordered in the order of which they apply their modifier onto
 * the "base" damage. The implementation for {@link #getFinalDamage()} can be
 * exemplified like so: <pre>{@code
 *  double damage = this.baseDamage;
 *  for (Map.Entry<DamageModifier, Function<? super Double, Double>> entry : this.modifierFunctions.entrySet()) {
 *   damage += checkNotNull(entry.getValue().apply(damage));
 *  }
 *  return damage;
 * }</pre> After which, the "final" damage is simply the summation of the
 * "base" damage and all "modified damage" for each {@link DamageModifier}
 * prorivded in this event.</p>
 *
 * <p>Coming forward, it is possible to further customize not only the "base"
 * damage, but override pre-existing {@link DamageModifier} {@link Function}s
 * by calling {@link #setDamage(DamageModifier, Function)} at which point the
 * end result may be undefined. However, if a custom {@link DamageModifier}
 * that aims to alter the "final" damage based on some custom circumstances,
 * calling {@link #setDamage(DamageModifier, Function)} on a <em>new</em>
 * {@link DamageModifier} instance, easily created from the
 * {@link DamageModifierBuilder}, the provided pairing will be added at the
 * "end" of the list for "modifying" the "base" damage.</p>
 *
 * <p>Note that this event is intended for processing incomming damage to
 * an {@link Entity} prior to any {@link DamageModifier}s associated with
 * the {@link #getTargetEntity()}. The {@link DamageEntityEvent} is used
 * to process the various {@link DamageModifier}s of which originate or are
 * associated with the targeted {@link Entity}.</p>
 */
@ImplementedBy(AbstractDamageEntityEvent.class)
public interface DamageEntityEvent extends TargetEntityEvent, CauseTracked {

    /**
     * Gets the original "raw" amount of damage to deal to the targeted
     * {@link Entity}.
     *
     * @return The original "raw" damage
     */
    double getOriginalDamage();

    /**
     * Gets the original "final" amount of damage after all original
     * {@link DamageModifier}s are applied to {@link #getOriginalDamage()}.
     * The "final" damage is considered the amount of health being lost by
     * the {@link Entity}, if health is tracked.
     *
     * @return The final amount of damage to originally deal
     */
    double getOriginalFinalDamage();

    /**
     * Gets an {@link ImmutableMap} of all original {@link DamageModifier}s
     * and their associated "modified" damage. Note that ordering is not
     * retained.
     *
     * @return An immutable map of the original modified damages
     */
    Map<DamageModifier, Double> getOriginalDamages();

    /**
     * Gets the original damage for the provided {@link DamageModifier}. If
     * the provided {@link DamageModifier} was not included in
     * {@link #getOriginalDamages()}, an {@link IllegalArgumentException} is
     * thrown.
     *
     * @param damageModifier The original damage modifier
     * @return The original damage change
     */
    double getOriginalModifierDamage(DamageModifier damageModifier);

    /**
     * Gets the original {@link List} of {@link DamageModifier} to
     * {@link Function} that was originally passed into the event.
     *
     * @return The list of damage modifier functions
     */
    List<Tuple<DamageModifier, Function<? super Double, Double>>> getOriginalFunctions();

    /**
     * Gets the "base" damage to deal to the targeted {@link Entity}. The
     * "base" damage is the original value before passing along the chain of
     * {@link Function}s for all known {@link DamageModifier}s.
     *
     * @return The base damage
     */
    double getBaseDamage();

    /**
     * Sets the "base" damage to deal to the targeted {@link Entity}. The
     * "base" damage is the original value before passing along the chain of
     * {@link Function}s for all known {@link DamageModifier}s.
     *
     * @param baseDamage The base damage
     */
    void setBaseDamage(double baseDamage);

    /**
     * Gets the final damage that will be passed into the proceeding
     * {@link DamageEntityEvent}. The final damage is the end result of the
     * {@link #getBaseDamage()} being applied in {@link Function#apply(Object)}
     * available from all the {@link Tuple}s of {@link DamageModifier} to
     * {@link Function} in {@link #getOriginalFunctions()}.
     *
     * @return The final damage to deal
     */
    double getFinalDamage();

    /**
     * Checks whether the provided {@link DamageModifier} is applicable to the
     * current available {@link DamageModifier}s.
     *
     * @param damageModifier The damage modifier to check
     * @return True if the damage modifier is relevant to this event
     */
    boolean isModifierApplicable(DamageModifier damageModifier);

    /**
     * Gets the damage for the provided {@link DamageModifier}. Providing that
     * {@link #isModifierApplicable(DamageModifier)} returns <code>true</code>,
     * the cached "damage" for the {@link DamageModifier} is returned.
     *
     * @param damageModifier The damage modifier to get the damage for
     * @return The modifier
     */
    double getDamage(DamageModifier damageModifier);

    /**
     * Sets the provided {@link Function} to be used for the given
     * {@link DamageModifier}. If the {@link DamageModifier} is already
     * included in {@link #getModifiers()}, the {@link Function} replaces
     * the existing function. If there is no {@link Tuple} for the
     * {@link DamageModifier}, a new one is created and added to the end
     * of the list of {@link Function}s to be applied to the
     * {@link #getBaseDamage()}.
     *
     * <p>If needing to create a custom {@link DamageModifier} is required,
     * usage of the {@link DamageModifierBuilder} is recommended.</p>
     *
     * @param damageModifier The damage modifier
     * @param function The function to map to the modifier
     */
    void setDamage(DamageModifier damageModifier, Function<? super Double, Double> function);

    /**
     * Gets a list of simple {@link Tuple}s of {@link DamageModifier} keyed to
     * their representative {@link Function}s. All {@link DamageModifier}s are
     * applicable to the entity based on the {@link DamageSource} and any
     * possible invulnerabilities due to the {@link DamageSource}.
     *
     * @return A list of damage modifiers to functions
     */
    List<Tuple<DamageModifier, Function<? super Double, Double>>> getModifiers();

    /**
     * An event where an {@link Entity} is a source. This will coincide with
     * the {@link DamageSource} being an {@link EntityDamageSource}.
     */
    interface SourceEntity extends DamageEntityEvent, EntityEvent { }

    /**
     * An event where a {@link Living} is a source. This will coincide with
     * the {@link DamageSource} being an {@link EntityDamageSource}.
     */
    interface SourceLiving extends SourceEntity, LivingEvent { }

    /**
     * An event where a {@link Human} is a source. This will coincide with
     * the {@link DamageSource} being an {@link EntityDamageSource}.
     */
    interface SourceHuman extends SourceLiving, HumanEvent { }

    /**
     * An event where a {@link Player} is a source. This will coincide with
     * the {@link DamageSource} being an {@link EntityDamageSource}.
     */
    interface SourcePlayer extends SourceHuman, PlayerEvent { }

}
