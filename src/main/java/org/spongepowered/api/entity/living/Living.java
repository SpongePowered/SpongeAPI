/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.entity.living;

import com.flowpowered.math.vector.Vector3f;
import com.google.common.base.Optional;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.potion.PotionEffectType;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

public interface Living extends Entity {

    /**
     * Subtracts from the health by the given amount.
     *
     * @param amount The damage amount
     */
    void damage(double amount);

    /**
     * Returns the health amount.
     *
     * <p>The range of the health depends on the object on which this
     * method is defined. For players in Minecraft, the nominal range is
     * between 0 and 20, inclusive, but the range can be adjusted.</p>
     *
     * <p>Convention dictates that health does not follow below 0 but this
     * convention may be broken.</p>
     *
     * @return Health value
     */
    double getHealth();

    /**
     * Sets the health amount.
     *
     * <p>The range of the health depends on the object on which this
     * method is defined. For players in Minecraft, the nominal range is
     * between 0 and 20, inclusive, but the range can be adjusted.</p>
     *
     * <p>Convention dictates that health does not follow below 0 but this
     * convention may be broken.</p>
     *
     * @param health The health to set to
     */
    void setHealth(double health);

    /**
     * Gets the current maximum health.
     *
     * <p>The maximum health may or may not include all attribute increasing
     * health points.</p>
     *
     * @return This entities maximum health
     */
    double getMaxHealth();

    /**
     * Sets the current maximum health.
     * <p>The maximum health set here may affect the attribute increasing
     * health points. The base health should be minded that it may be lower
     * than the total maximum health of this entity.</p>
     *
     * @param maxHealth The maximum health for this entity
     */
    void setMaxHealth(double maxHealth);

    /**
     * Adds a {@link PotionEffect} to this entity.
     *
     * <p>
     *     If a conflicting {@link PotionEffect} already exists,
     *     this will not be applied unless force is specified.
     * </p>
     *
     * @param potionEffect The {@link PotionEffect} to add.
     * @param force Whether or not to forcibly add it.
     */
    void addPotionEffect(PotionEffect potionEffect, boolean force);

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
     */
    void addPotionEffects(Collection<PotionEffect> potionEffects, boolean force);

    /**
     * Remove {@link PotionEffect}s of the specified type from this entity.
     *
     * @param potionEffectType The {@link PotionEffectType}.
     */
    void removePotionEffect(PotionEffectType potionEffectType);

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

    /**
     * Gets the living entity that last attacked this one.
     * <p>The last attacker may expire over time or when the attacker died.</p>
     *
     * @return The last attacker of this entity
     */
    Optional<Living> getLastAttacker();

    /**
     * Sets the last living entity to have attacked this entity.
     * <p>The last attacker may expire over time or when the attacker died.</p>
     *
     * @param lastAttacker The last attacker
     */
    void setLastAttacker(@Nullable Living lastAttacker);

    /**
     * Returns whether this entity is leashed.
     *
     * @return True if this entity is leashed
     */
    boolean isLeashed();

    /**
     * Sets whether this entity is leashed or not.
     *
     * @param leashed Whether this entity is leashed or not
     */
    void setLeashed(boolean leashed);

    /**
     * Gets the holder of this leashed entity, if available.
     *
     * @return The leash holder, if available
     */
    Optional<Entity> getLeashHolder();

    /**
     * Sets the holder of this leashed entity.
     *
     * @param entity The entity to hold the leash
     */
    void setLeashHolder(@Nullable Entity entity);

    /**
     * Gets the height of the eye (camera) of this entity
     *
     * @return The camera height
     */
    double getEyeHeight();

    /**
     * Gets the location of the eye height (camera) of this entity.
     *
     * @return The camera location
     */
    Vector3f getEyeLocation();

    /**
     * Gets the remaining ticks of air.
     *
     * @return The ticks of air
     */
    int getRemainingAir();

    /**
     * Sets the remaining ticks of air.
     *
     * @param air The remaining ticks of air
     */
    void setRemainingAir(int air);

    /**
     * Gets the maximum ticks of air this entity can have.
     *
     * @return The maximum ticks of air
     */
    int getMaxAir();

    /**
     * Sets the maximum ticks of air this entity can have.
     *
     * @param air The maximum ticks of air
     */
    void setMaxAir(int air);

    /**
     * Gets the last amount of damage dealt to this entity.
     *
     * @return The damage amount last dealt
     */
    double getLastDamage();

    /**
     * Sets the last damage amount that was dealt to this living entity.
     *
     * @param damage The amount of damage last dealt
     */
    void setLastDamage(double damage);

    /**
     * Gets the amount of ticks this entity is immune from damage.
     *
     * @return The ticks of immunity towards damage
     */
    int getInvulnerabilityTicks();

    /**
     * Sets the amount of ticks this entity is immune from damage.
     *
     * @param ticks The ticks of invulnerability
     */
    void setInvulnerabilityTicks(int ticks);

    /**
     * Gets the maximum ticks of invulnerability for this entity.
     *
     * @return The maximum ticks of invulnerability
     */
    int getMaxInvulnerabilityTicks();

    /**
     * Sets the maximum ticks of invulnerability for this entity.
     *
     * @param ticks The maximum ticks of invulnerability
     */
    void setMaxInvulnerabilityTicks(int ticks);

    /**
     * Returns whether this living entity can pick up items.
     *
     * @return Whether this entity can pick up items
     */
    boolean getCanPickupItems();

    /**
     * Sets whether this entity can pick up items or not.
     *
     * @param canPickupItems Whether this entity can pick up items
     */
    void setCanPickupItems(boolean canPickupItems);

    /**
     * Gets the custom display name of this entity.
     * <p>Custom names may appear overhead or when in the line of sight
     * of a player.</p>
     *
     * @return The custom name
     */
    String getCustomName();

    /**
     * Sets the custom display name of this entity.
     * <p>Custom names may appear overhead or when in the line of sight
     * of a player.</p>
     *
     * @param name The custom name
     */
    void setCustomName(String name);

    /**
     * Returns whether the custom name is visible to players.
     *
     * @return Whether the custom name is visible or not
     */
    boolean isCustomNameVisible();

    /**
     * Sets whether the custom name is visible to players.
     *
     * @param visible Whether the custom name is visible
     */
    void setCustomNameVisible(boolean visible);

    /**
     * Returns whether this entity will be persistent when no player is near.
     *
     * @return True if this entity is persistent
     */
    boolean isPersistent();

    /**
     * Sets whether this entity will be persistent when no player is near.
     *
     * @param persistent Whether the entity will be persistent
     */
    void setPersistent(boolean persistent);
}
