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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.entity.damage.source.FallingBlockDamageSource;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.difficulty.Difficulty;

import java.util.function.Supplier;

public final class DamageModifierTypes {

    // SORTFIELDS:ON

    /**
     * Represents a {@link DamageModifier} that "absorbs" damage based on
     * the {@link PotionEffectTypes#ABSORPTION} level on the
     * {@link Entity}.
     */
    public static final Supplier<DamageModifierType> ABSORPTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "absorption");

    /**
     * Represents a {@link DamageModifier} that will reduce damage based on
     * the armor {@link ItemStack}s.
     */
    public static final Supplier<DamageModifierType> ARMOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "armor");

    /**
     * Represents a {@link DamageModifier} that will reduce damage based on
     * the {@link EnchantmentType}s applicable to an {@link ItemStack} that is
     * considered to be "armor" currently equipped on the owner.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * an {@link ItemStackSnapshot} and an {@link Enchantment} signifying
     * that the {@link EnchantmentType} of the {@link ItemStack} is modifying the
     * incoming/outgoing damage. There can be multiple {@link DamageModifier}s
     * of this type in a single event due to the variety of possibilities in
     * customization of armor handling.</p>
     */
    public static final Supplier<DamageModifierType> ARMOR_ENCHANTMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "armor_enchantment");

    /**
     * Represents the {@link DamageModifier} that will reduce damage from a
     * {@link Player} if their attack cooldown has not been completed yet.
     */
    public static final Supplier<DamageModifierType> ATTACK_COOLDOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "attack_cooldown");

    /**
     * Represents the {@link DamageModifier} that will modify damage output
     * based on the fact that the attacking source is critically hitting the
     * target.
     */
    public static final Supplier<DamageModifierType> CRITICAL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "critical_hit");

    /**
     * Represents a {@link DamageModifier} that will reduce damage based on
     * the {@link PotionEffectTypes#RESISTANCE} or any other
     * {@link PotionEffectType} that can be deemed as reducing incoming damage.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * a {@link PotionEffect} including the amplifier and duration, signifying
     * that the {@link PotionEffectType} is modifying the incoming damage.</p>
     */
    public static final Supplier<DamageModifierType> DEFENSIVE_POTION_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "defensive_potion_effect");

    /**
     * Represents a {@link DamageModifier} that enhances damage based on the
     * current {@link Difficulty} of the {@link World}.
     */
    public static final Supplier<DamageModifierType> DIFFICULTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "difficulty");

    /**
     * Represents the {@link DamageModifier} that will modify damage from
     * a {@link FallingBlockDamageSource}.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * an {@link ItemStackSnapshot} and an {@link Enchantment} signifying
     * that the {@link EnchantmentType} of the {@link ItemStack} is modifying the
     * incoming/outgoing damage.</p>
     */
    public static final Supplier<DamageModifierType> HARD_HAT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "hard_hat");

    /**
     * Represents a {@link DamageModifier} that will modify damage based on
     * magic.
     */
    public static final Supplier<DamageModifierType> MAGIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "magic");

    /**
     * Represents a {@link DamageModifier} that will reduce outgoing damage
     * based on a {@link PotionEffect}.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * a {@link PotionEffect} including the amplifier and duration, signifying
     * that the {@link PotionEffectType} is reducing the outgoing damage.</p>
     */
    public static final Supplier<DamageModifierType> NEGATIVE_POTION_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "negative_potion_effect");

    /**
     * Represents the {@link DamageModifier} that will increase damage from
     * a {@link PotionEffect} affecting the attacker.
     */
    public static final Supplier<DamageModifierType> OFFENSIVE_POTION_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "offensive_potion_effect");

    /**
     * Represents a {@link DamageModifier} that will reduce damage due to
     * using a shield.
     */
    public static final Supplier<DamageModifierType> SHIELD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "shield");

    /**
     * Represents a {@link DamageModifier} that is applied for a sweeping
     * attack.
     */
    public static final Supplier<DamageModifierType> SWEEPING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "sweeping");

    /**
     * Represents the {@link DamageModifier} that will modify damage from
     * an {@link EnchantmentType} on an equipped {@link ItemStack}.
     *
     * <p>Usually, within the {@link DamageModifier#getCause()} will reside
     * an {@link ItemStackSnapshot} and an {@link Enchantment} signifying
     * that the {@link EnchantmentType} of the {@link ItemStack} is modifying the
     * incoming/outgoing damage.</p>
     */
    public static final Supplier<DamageModifierType> WEAPON_ENCHANTMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageModifierType.class, "weapon_enchantment");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private DamageModifierTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
