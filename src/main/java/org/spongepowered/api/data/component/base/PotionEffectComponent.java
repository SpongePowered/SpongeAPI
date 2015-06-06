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
package org.spongepowered.api.data.component.base;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.component.ListComponent;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.potion.PotionEffectType;

import java.util.Collection;
import java.util.List;

/**
 * Represents a {@link List} of {@link PotionEffect}s that can be applicable to
 * various {@link DataHolder}s such as {@link Entity}s, {@link ItemStack}s as
 * {@link ItemTypes#POTION}, etc.
 */
public interface PotionEffectComponent extends ListComponent<PotionEffect, PotionEffectComponent> {

    /**
     * Adds a {@link PotionEffect} to this entity.
     *
     * <p>If a conflicting {@link PotionEffect} already exists, this will not
     * be applied unless force is specified.</p>
     *
     * @param potionEffect The {@link PotionEffect} to add.
     * @param force Whether or not to forcibly add it.
     * @return This instance, for chaining
     */
    PotionEffectComponent addPotionEffect(PotionEffect potionEffect, boolean force);

    /**
     * Adds a list of {@link PotionEffect}s to this entity.
     *
     * <p>
     *     If a conflicting {@link PotionEffect} already exists,
     *     this will not be applied unless force is specified.
     * </p>
     *
     * @param potionEffects The {@link PotionEffect}s to add.
     * @param force Whether or not to forcibly add it.
     * @return This instance, for chaining
     */
    PotionEffectComponent addPotionEffects(Collection<PotionEffect> potionEffects, boolean force);

    /**
     * Remove {@link PotionEffect}s of the specified type from this entity.
     *
     * @param potionEffectType The {@link PotionEffectType}.
     * @return This instance, for chaining
     */
    PotionEffectComponent removePotionEffect(PotionEffectType potionEffectType);

    /**
     * Gets if this entity has a {@link PotionEffect} of this type.
     *
     * @param potionEffectType The {@link PotionEffectType}.
     *
     * @return If it has the potion effect type.
     */
    boolean hasPotionEffect(PotionEffectType potionEffectType);

    /**
     * Gets a list of {@link PotionEffect}s currently applied to this entity.
     *
     * @return The list of {@link PotionEffect}s.
     */
    List<PotionEffect> getPotionEffects();

}
