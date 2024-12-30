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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.effect.potion.PotionEffectType;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.enchantment.EnchantmentType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class DamageStepTypes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Represents a {@link DamageStep} that "absorbs" damage based on
     * the {@link PotionEffectTypes#ABSORPTION} level on the
     * {@link Entity}.
     */
    public static final DefaultedRegistryReference<DamageStepType> ABSORPTION = DamageStepTypes.key(ResourceKey.sponge("absorption"));

    /**
     * Represents a {@link DamageStep} that will reduce damage based on
     * the armor {@link ItemStack}s.
     */
    public static final DefaultedRegistryReference<DamageStepType> ARMOR = DamageStepTypes.key(ResourceKey.sponge("armor"));

    /**
     * Represents a {@link DamageStep} that will reduce damage based on
     * the {@link EnchantmentType}s applicable to an {@link ItemStack} that is
     * considered to be "armor" currently equipped on the owner.
     *
     * <p>Usually, within the {@link DamageStep#cause()} will reside
     * an {@link ItemStackSnapshot} and an {@link Enchantment} signifying
     * that the {@link EnchantmentType} of the {@link ItemStack} is modifying the
     * incoming/outgoing damage. There can be multiple {@link DamageStep}s
     * of this type in a single event due to the variety of possibilities in
     * customization of armor handling.</p>
     */
    public static final DefaultedRegistryReference<DamageStepType> ARMOR_ENCHANTMENT = DamageStepTypes.key(ResourceKey.sponge("armor_enchantment"));

    /**
     * Represents the {@link DamageStep} that will reduce the base damage from a
     * {@link Player} if their attack cooldown has not been completed yet.
     */
    public static final DefaultedRegistryReference<DamageStepType> BASE_COOLDOWN = DamageStepTypes.key(ResourceKey.sponge("base_cooldown"));

    /**
     * Represents the {@link DamageStep} that will modify damage output
     * based on the fact that the attacking source is critically hitting the
     * target.
     */
    public static final DefaultedRegistryReference<DamageStepType> CRITICAL_HIT = DamageStepTypes.key(ResourceKey.sponge("critical_hit"));

    /**
     * Represents a {@link DamageStep} that will reduce damage based on
     * the {@link PotionEffectTypes#RESISTANCE} or any other
     * {@link PotionEffectType} that can be deemed as reducing incoming damage.
     *
     * <p>Usually, within the {@link DamageStep#cause()} will reside
     * a {@link PotionEffect} including the amplifier and duration, signifying
     * that the {@link PotionEffectType} is modifying the incoming damage.</p>
     */
    public static final DefaultedRegistryReference<DamageStepType> DEFENSIVE_POTION_EFFECT = DamageStepTypes.key(ResourceKey.sponge("defensive_potion_effect"));

    /**
     * Represents the {@link DamageStep} that will reduce the enchantment damage from a
     * {@link Player} if their attack cooldown has not been completed yet.
     */
    public static final DefaultedRegistryReference<DamageStepType> ENCHANTMENT_COOLDOWN = DamageStepTypes.key(ResourceKey.sponge("enchantment_cooldown"));

    /**
     * Represents a {@link DamageStep} that will modify freezing damage.
     * E.g. {@link org.spongepowered.api.entity.living.monster.Blaze} take more damage from freezing sources.
     */
    public static final DefaultedRegistryReference<DamageStepType> FREEZING_BONUS = DamageStepTypes.key(ResourceKey.sponge("freezing_bonus"));

    /**
     * Represents the {@link DamageStep} that will modify damage from
     * a {@link DamageSource#source()} that is a {@link org.spongepowered.api.entity.FallingBlock}.
     *
     * <p>Usually, within the {@link DamageStep#cause()} will reside
     * an {@link ItemStackSnapshot} and an {@link Enchantment} signifying
     * that the {@link EnchantmentType} of the {@link ItemStack} is modifying the
     * incoming/outgoing damage.</p>
     */
    public static final DefaultedRegistryReference<DamageStepType> HARD_HAT = DamageStepTypes.key(ResourceKey.sponge("hard_hat"));

    /**
     * Represents a {@link DamageStep} that will modify damage based on
     * magic.
     */
    public static final DefaultedRegistryReference<DamageStepType> MAGIC = DamageStepTypes.key(ResourceKey.sponge("magic"));

    /**
     * Represents a {@link DamageStep} that will reduce outgoing damage
     * based on a {@link PotionEffect}.
     *
     * <p>Usually, within the {@link DamageStep#cause()} will reside
     * a {@link PotionEffect} including the amplifier and duration, signifying
     * that the {@link PotionEffectType} is reducing the outgoing damage.</p>
     */
    public static final DefaultedRegistryReference<DamageStepType> NEGATIVE_POTION_EFFECT = DamageStepTypes.key(ResourceKey.sponge("negative_potion_effect"));

    /**
     * Represents the {@link DamageStep} that will increase damage from
     * a {@link PotionEffect} affecting the attacker.
     */
    public static final DefaultedRegistryReference<DamageStepType> OFFENSIVE_POTION_EFFECT = DamageStepTypes.key(ResourceKey.sponge("offensive_potion_effect"));

    /**
     * Represents a {@link DamageStep} that will reduce damage due to using a shield.
     */
    public static final DefaultedRegistryReference<DamageStepType> SHIELD = DamageStepTypes.key(ResourceKey.sponge("shield"));

    /**
     * Represents a {@link DamageStep} that is applied for a sweeping attack.
     */
    public static final DefaultedRegistryReference<DamageStepType> SWEEPING = DamageStepTypes.key(ResourceKey.sponge("sweeping"));

    /**
     * Represents a {@link DamageStep} that will add bonus damage based on the weapon used.
     */
    public static final DefaultedRegistryReference<DamageStepType> WEAPON_BONUS = DamageStepTypes.key(ResourceKey.sponge("weapon_bonus"));

    /**
     * Represents the {@link DamageStep} that will modify damage from
     * an {@link EnchantmentType} on an equipped {@link ItemStack}.
     *
     * <p>Usually, within the {@link DamageStep#cause()} will reside
     * an {@link ItemStackSnapshot} and an {@link Enchantment} signifying
     * that the {@link EnchantmentType} of the {@link ItemStack} is modifying the
     * incoming/outgoing damage.</p>
     */
    public static final DefaultedRegistryReference<DamageStepType> WEAPON_ENCHANTMENT = DamageStepTypes.key(ResourceKey.sponge("weapon_enchantment"));

    // SORTFIELDS:OFF

    // @formatter:on

    private DamageStepTypes() {
    }

    public static Registry<DamageStepType> registry() {
        return Sponge.game().registry(RegistryTypes.DAMAGE_STEP_TYPE);
    }

    private static DefaultedRegistryReference<DamageStepType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.DAMAGE_STEP_TYPE, location).asDefaultedReference(Sponge::game);
    }
}
