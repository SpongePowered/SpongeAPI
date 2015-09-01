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

package org.spongepowered.api.event.cause.entity.health;

import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.potion.PotionEffectType;
import org.spongepowered.api.potion.PotionEffectTypes;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.difficulty.Difficulty;

public final class HealthModifierTypes {

    /**
     * Represents the {@link HealthModifier} that will modify heal amount from
     * an {@link Enchantment} on an equipped {@link ItemStack}.
     *
     * <p>Usually, within the {@link HealthModifier#getCause()} will reside
     * an {@link ItemStackSnapshot} and an {@link ItemEnchantment} signifying
     * that the {@link Enchantment} of the {@link ItemStack} is modifying the
     * incoming/outgoing heal amount.</p>
     */
    public static final HealthModifierType WEAPON_ENCHANTMENT = null;
    /**
     * Represents the {@link HealthModifier} that will increase heal amount
     * from a {@link PotionEffect} affecting the target.
     */
    public static final HealthModifierType OFFENSIVE_POTION_EFFECT = null;
    /**
     * Represents a {@link HealthModifier} that will modify the heal amount
     * from a {@link PotionEffect} affecting the target.
     */
    public static final HealthModifierType DEFENSIVE_POTION_EFFECT = null;
    /**
     * Represents a {@link HealthModifier} that will reduce damage based on
     * the armor {@link ItemStack}s.
     */
    public static final HealthModifierType ARMOR = null;
    /**
     * Represents a {@link HealthModifier} that will modify damage based on
     * magic.
     */
    public static final HealthModifierType MAGIC = null;
    /**
     * Represents a {@link HealthModifier} that "absorbs" damage based on
     * the {@link PotionEffectTypes#ABSORPTION} level on the
     * {@link Entity}.
     */
    public static final HealthModifierType ABSORPTION = null;
    /**
     * Represents a {@link HealthModifier} that enhances damage based on the
     * current {@link Difficulty} of the {@link World}.
     */
    public static final HealthModifierType DIFFICULTY = null;

    private HealthModifierTypes() {

    }
}
