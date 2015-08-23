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

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.entity.damage.source.FallingBlockDamageSource;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.potion.PotionEffectTypes;

/**
 * An index of known vanilla {@link DamageModifier}s that can be applied by
 * an {@link Entity}.
 */
public final class DamageModifiers {

    private DamageModifiers() {
    }

    /**
     * Represents the {@link DamageModifier} that will modify damage from
     * an {@link Enchantment} on an equipped {@link ItemStack}.
     */
    public static final DamageModifier WEAPON_ENCHANTMENT = null;
    /**
     * Represents the {@link DamageModifier} that will increase damage from
     * a {@link PotionEffect} affecting the attacker.
     */
    public static final DamageModifier OFFENSIVE_POTION_EFFECT = null;
    /**
     * Represents the {@link DamageModifier} that will modify damage from
     * a {@link FallingBlockDamageSource}.
     */
    public static final DamageModifier HARD_HAT = null;
    /**
     * Represents a {@link DamageModifier} that will reduce damage due to
     * an attempt at blocking.
     */
    public static final DamageModifier BLOCKING = null;
    /**
     * Represents a {@link DamageModifier} that will reduce damage based on
     * the armor {@link ItemStack}s.
     */
    public static final DamageModifier ARMOR = null;
    /**
     * Represents a {@link DamageModifier} that will reduce damage based on
     * the {@link PotionEffectTypes#RESISTANCE}.
     */
    public static final DamageModifier DEFENSIVE_POTION_EFFECT = null;
    /**
     * Represents a {@link DamageModifier} that will modify damage based on
     * magic.
     */
    public static final DamageModifier MAGIC = null;
    /**
     * Represents a {@link DamageModifier} that "absorbs" damage based on
     * the {@link PotionEffectTypes#ABSORPTION} level on the
     * {@link Entity}.
     */
    public static final DamageModifier ABSORPTION = null;

}
