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
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.entity.damage.source.FallingBlockDamageSource;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.difficulty.Difficulty;

public final class DamageModifierTypes {

    /**
     * Represents the {@link DamageModifier} that will modify damage from
     * an {@link Enchantment} on an equipped {@link ItemStack}.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * an {@link ItemStackSnapshot} and an {@link ItemEnchantment} signifying
     * that the {@link Enchantment} of the {@link ItemStack} is modifying the
     * incoming/outgoing damage.</p>
     */
    public static final DamageModifierType WEAPON_ENCHANTMENT = null;
    /**
     * Represents the {@link DamageModifier} that will increase damage from
     * a {@link PotionEffect} affecting the attacker.
     */
    public static final DamageModifierType OFFENSIVE_POTION_EFFECT = null;
    /**
     * Represents a {@link DamageModifier} that will reduce damage based on
     * the {@link PotionEffectTypes#RESISTANCE} or any other
     * {@link PotionEffectType} that can be deemed as reducing incoming damage.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * a {@link PotionEffect} including the amplifier and duration, signifying
     * that the {@link PotionEffectType} is modifying the incoming damage.</p>
     */
    public static final DamageModifierType DEFENSIVE_POTION_EFFECT = null;
    /**
     * Represents a {@link DamageModifier} that will reduce outgoing damage
     * based on a {@link PotionEffect}.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * a {@link PotionEffect} including the amplifier and duration, signifying
     * that the {@link PotionEffectType} is reducing the outgoing damage.</p>
     */
    public static final DamageModifierType NEGATIVE_POTION_EFFECT = null;
    /**
     * Represents the {@link DamageModifier} that will modify damage from
     * a {@link FallingBlockDamageSource}.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * an {@link ItemStackSnapshot} and an {@link ItemEnchantment} signifying
     * that the {@link Enchantment} of the {@link ItemStack} is modifying the
     * incoming/outgoing damage.</p>
     */
    public static final DamageModifierType HARD_HAT = null;
    /**
     * Represents a {@link DamageModifier} that will reduce damage due to
     * an attempt at blocking.
     */
    public static final DamageModifierType BLOCKING = null;
    /**
     * Represents a {@link DamageModifier} that will reduce damage based on
     * the armor {@link ItemStack}s.
     */
    public static final DamageModifierType ARMOR = null;
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
    public static final DamageModifierType ARMOR_ENCHANTMENT = null;
    /**
     * Represents a {@link DamageModifier} that will modify damage based on
     * magic.
     */
    public static final DamageModifierType MAGIC = null;
    /**
     * Represents a {@link DamageModifier} that "absorbs" damage based on
     * the {@link PotionEffectTypes#ABSORPTION} level on the
     * {@link Entity}.
     */
    public static final DamageModifierType ABSORPTION = null;
    /**
     * Represents a {@link DamageModifier} that enhances damage based on the
     * current {@link Difficulty} of the {@link World}.
     */
    public static final DamageModifierType DIFFICULTY = null;

    private DamageModifierTypes() {

    }
}
