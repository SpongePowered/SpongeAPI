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

import org.spongepowered.api.block.entity.carrier.Dispenser;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.monster.skeleton.Skeleton;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.arrow.ArrowLike;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.difficulty.Difficulties;
import org.spongepowered.api.world.difficulty.Difficulty;

/**
 * Represents the base event for when an {@link Entity} is being "attacked".
 * The uniqueness of this event is that all {@link DamageSource}s can deal
 * varying amounts of damage with varying modifiers based on various reasons.
 * Due to this ambiguous variety of information that is possible to provide,
 * the {@link AttackEntityEvent} can be summarized as so:
 *
 * <p>An {@link ArrowLike},
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
 * {@link DamageSource#isMagic()}, or {@link DamageSource#isBypassingArmor()}.
 * Quite simply, the {@link DamageSource} will always be the "first" element
 * within a {@link Cause} that can be retrieved from {@link #cause()}.</p>
 *
 * <p>Next, any additional "aides" in attacking the {@link Entity} will
 * be included in order of "priority of relation" to "attacking" the entity. In
 * short, if another {@link Entity} is considered a "team member" to the
 * attacking {@link Entity}, the "team member" may be a second element within
 * the {@link Cause}. The same can be said if an {@link ArrowLike} was shot from
 * a {@link Dispenser} that was triggered by a {@link Player} flipping a
 * switch.</p>
 */
public interface AttackEntityEvent extends DamageCalculationEvent {

    /**
     * Fires before the damage steps and their side effects are applied.
     * The final damage is still unknown.
     */
    interface Pre extends AttackEntityEvent, DamageCalculationEvent.Pre {
    }

    /**
     * Fires after the damage steps and their side effects have been applied.
     */
    interface Post extends AttackEntityEvent, DamageCalculationEvent.Post {

        /**
         * Gets the original knockback modifier.
         *
         * @see #knockbackModifier()
         * @return The original knockback modifier
         */
        double originalKnockbackModifier();

        /**
         * Gets the knockback modifier. The modifier itself will apply to the
         * momentum of the attacked entity.
         *
         * @return The knockback modifier
         */
        double knockbackModifier();

        /**
         * Sets the knockback modifier.
         *
         * @see #knockbackModifier()
         * @param modifier The knockback modifier to set
         */
        void setKnockbackModifier(double modifier);
    }
}
