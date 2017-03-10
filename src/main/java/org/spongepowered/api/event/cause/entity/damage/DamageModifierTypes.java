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
package org.spongepowered.api.event.cause.entity.damage;

import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.entity.damage.source.FallingBlockDamageSource;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.difficulty.Difficulty;

public final class DamageModifierTypes {

    // SORTFIELDS:ON

    /**
     * Represents a {@link DamageModifier} that "absorbs" damage based on
     * the {@link PotionEffectTypes#ABSORPTION} level on the
     * {@link Entity}.
     */
    public static final DamageModifierType ABSORPTION = DummyObjectProvider.createFor(DamageModifierType.class, "ABSORPTION");

    /**
     * Represents a {@link DamageModifier} that will reduce damage based on
     * the armor {@link ItemStack}s.
     */
    public static final DamageModifierType ARMOR = DummyObjectProvider.createFor(DamageModifierType.class, "ARMOR");

    /**
     * Represents a {@link DamageModifier} that will reduce damage based on
     * the {@link Enchantment}s applicable to an {@link ItemStack} that is
     * considered to be "armor" currently equipped on the owner.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * an {@link ItemStackSnapshot} and an {@link ItemEnchantment} signifying
     * that the {@link Enchantment} of the {@link ItemStack} is modifying the
     * incoming/outgoing damage. There can be multiple {@link DamageModifier}s
     * of this type in a single event due to the variety of possibilities in
     * customization of armor handling.</p>
     */
    public static final DamageModifierType ARMOR_ENCHANTMENT = DummyObjectProvider.createFor(DamageModifierType.class, "ARMOR_ENCHANTMENT");

    /**
     * Represents the {@link DamageModifier} that will reduce damage from a
     * {@link Player} if their attack cooldown has not been completed yet.
     */
    public static final DamageModifierType ATTACK_COOLDOWN = DummyObjectProvider.createFor(DamageModifierType.class, "ATTACK_COOLDOWN");

    /**
     * Represents a {@link DamageModifier} that will reduce damage due to
     * an attempt at blocking.
     *
     * @deprecated {@link #SHIELD} should be used instead, since blocking no longer exists in the game as of 1.9
     */
    @Deprecated
    public static final DamageModifierType BLOCKING = DummyObjectProvider.createFor(DamageModifierType.class, "SHIELD");

    /**
     * Represents the {@link DamageModifier} that will modify damage output
     * based on the fact that the attacking source is critically hitting the
     * target.
     */
    public static final DamageModifierType CRITICAL_HIT = DummyObjectProvider.createFor(DamageModifierType.class, "CRITICAL_HIT");

    /**
     * Represents a {@link DamageModifier} that will reduce damage based on
     * the {@link PotionEffectTypes#RESISTANCE} or any other
     * {@link PotionEffectType} that can be deemed as reducing incoming damage.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * a {@link PotionEffect} including the amplifier and duration, signifying
     * that the {@link PotionEffectType} is modifying the incoming damage.</p>
     */
    public static final DamageModifierType DEFENSIVE_POTION_EFFECT = DummyObjectProvider
            .createFor(DamageModifierType.class, "DEFENSIVE_POTION_EFFECT");

    /**
     * Represents a {@link DamageModifier} that enhances damage based on the
     * current {@link Difficulty} of the {@link World}.
     */
    public static final DamageModifierType DIFFICULTY = DummyObjectProvider
            .createFor(DamageModifierType.class, "DIFFICULTY");

    /**
     * Represents the {@link DamageModifier} that will modify damage from
     * a {@link FallingBlockDamageSource}.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * an {@link ItemStackSnapshot} and an {@link ItemEnchantment} signifying
     * that the {@link Enchantment} of the {@link ItemStack} is modifying the
     * incoming/outgoing damage.</p>
     */
    public static final DamageModifierType HARD_HAT = DummyObjectProvider.createFor(DamageModifierType.class, "HARD_HAT");

    /**
     * Represents a {@link DamageModifier} that will modify damage based on
     * magic.
     */
    public static final DamageModifierType MAGIC = DummyObjectProvider.createFor(DamageModifierType.class, "MAGIC");

    /**
     * Represents a {@link DamageModifier} that will reduce outgoing damage
     * based on a {@link PotionEffect}.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * a {@link PotionEffect} including the amplifier and duration, signifying
     * that the {@link PotionEffectType} is reducing the outgoing damage.</p>
     */
    public static final DamageModifierType NEGATIVE_POTION_EFFECT = DummyObjectProvider.createFor(DamageModifierType.class, "NEGATIVE_POTION_EFFECT");

    /**
     * Represents the {@link DamageModifier} that will increase damage from
     * a {@link PotionEffect} affecting the attacker.
     */
    public static final DamageModifierType OFFENSIVE_POTION_EFFECT = DummyObjectProvider
            .createFor(DamageModifierType.class, "OFFENSIVE_POTION_EFFECT");

    /**
     * Represents a {@link DamageModifier} that will reduce damage due to using a shield.
     */
    public static final DamageModifierType SHIELD = DummyObjectProvider.createFor(DamageModifierType.class, "SHIELD");

    /**
     * Represents the {@link DamageModifier} that will modify damage from
     * an {@link Enchantment} on an equipped {@link ItemStack}.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * an {@link ItemStackSnapshot} and an {@link ItemEnchantment} signifying
     * that the {@link Enchantment} of the {@link ItemStack} is modifying the
     * incoming/outgoing damage.</p>
     */
    public static final DamageModifierType WEAPON_ENCHANTMENT = DummyObjectProvider.createFor(DamageModifierType.class, "WEAPON_ENCHANTMENT");

    // SORTFIELDS:OFF

    private DamageModifierTypes() {

    }
}
