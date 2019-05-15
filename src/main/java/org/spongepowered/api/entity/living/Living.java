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
package org.spongepowered.api.entity.living;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.scoreboard.TeamMember;

import java.util.Optional;
import java.util.OptionalDouble;

/**
 * Represents an entity that is living, and therefor can be damaged.
 *
 * <p>Living entities can have {@link PotionEffect}s, breathing air
 * under water, custom names, be meaningfully added to teams, and become
 * invisible.</p>
 */
public interface Living extends Entity, ProjectileSource, TeamMember {

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
    default BoundedValue.Mutable<Double> health() {
        return getValue(Keys.HEALTH).get().asMutable();
    }

    /**
     * Gets the current maximum health.
     *
     * <p>The maximum health set here may affect the attribute increasing
     * health points. The base health should be minded that it may be lower
     * than the total maximum health of this entity.</p>
     *
     * @return This entities maximum health
     */
    default BoundedValue.Mutable<Double> maxHealth() {
        return getValue(Keys.MAX_HEALTH).get().asMutable();
    }

    /**
     * Gets the last attacker of this entity.
     *
     * @return The last attacker
     */
    default Optional<Entity> getLastAttacker() {
        return get(Keys.LAST_ATTACKER);
    }

    /**
     * Sets the last attacker of this entity.
     *
     * @param entity The last attacker entity
     */
    default void setLastAttacker(Entity entity) {
        offer(Keys.LAST_ATTACKER, entity);
    }

    /**
     * Gets the last amount of damage that was dealt to this entity.
     *
     * @return The last damage, if present
     */
    OptionalDouble getLastDamage();

    /**
     * Returns this entity's head rotation.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <ul><code>x -> pitch</code>, <code>y -> yaw</code>, <code>z -> roll
     * </code></ul>
     *
     * <p>Note that the pitch will be the same x value returned by
     * {@link Entity#getRotation()} and Minecraft does not currently support
     * head roll so the z value will always be zero.</p>
     *
     * @return Head rotation
     */
    default Vector3d getHeadRotation() {
        return require(Keys.HEAD_ROTATION);
    }

    /**
     * Sets the entity's head rotation.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <ul><code>x -> pitch</code>, <code>y -> yaw</code>, <code>z -> roll
     * </code></ul>
     *
     * <p>Note that the pitch (x value) supplied will update the entity's pitch
     * via {@link Entity#setRotation(Vector3d)}.</p>
     *
     * @param rotation Rotation of the entities head
     */
    default void setHeadRotation(Vector3d rotation) {
        offer(Keys.HEAD_ROTATION, rotation);
    }

    /**
     * Makes the entity look at the specified target position.
     *
     * @param targetPos Position to target
     */
    void lookAt(Vector3d targetPos);
}
