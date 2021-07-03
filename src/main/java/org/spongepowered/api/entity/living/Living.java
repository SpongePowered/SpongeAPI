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

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.BodyPart;
import org.spongepowered.api.data.value.ListValue;
import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.effect.potion.PotionEffect;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.attribute.Attribute;
import org.spongepowered.api.entity.attribute.AttributeHolder;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.scoreboard.TeamMember;
import org.spongepowered.math.imaginary.Quaterniond;
import org.spongepowered.math.vector.Vector3d;

import java.util.Optional;

/**
 * Represents an entity that is living, and therefor can be damaged.
 *
 * <p>Living entities can have {@link PotionEffect}s, breathing air
 * under water, custom names, be meaningfully added to teams, hold {@link Attribute}s, and become
 * invisible.</p>
 */
public interface Living extends AttributeHolder, Entity, TeamMember {

    /**
     * {@link Keys#ABSORPTION}
     *
     * @return The amount of {@link org.spongepowered.api.effect.potion.PotionEffectTypes#ABSORPTION}
     */
    default Value.Mutable<Double> absorption() {
        return this.requireValue(Keys.ABSORPTION).asMutable();
    }

    /**
     * {@link Keys#ACTIVE_ITEM}
     *
     * @return The active item, such as food being eaten
     */
    default Value.Mutable<ItemStackSnapshot> activeItem() {
        return this.requireValue(Keys.ACTIVE_ITEM).asMutable();
    }

    /**
     * {@link Keys#HEALTH}
     *
     * @return The health value
     */
    default Value.Mutable<Double> health() {
        return this.requireValue(Keys.HEALTH).asMutable();
    }

    /**
     * {@link Keys#MAX_HEALTH}
     *
     * @return The maximum health value
     */
    default Value.Mutable<Double> maxHealth() {
        return this.requireValue(Keys.MAX_HEALTH).asMutable();
    }

    /**
     * {@link Keys#LAST_ATTACKER}
     *
     * @return The last attacker who attacked this entity
     */
    default Optional<Value.Mutable<Entity>> lastAttacker() {
        return this.getValue(Keys.LAST_ATTACKER).map(Value::asMutable);
    }

    /**
     * {@link Keys#HEAD_ROTATION}
     *
     * @return The rotation of the head
     */
    default Value.Mutable<Vector3d> headRotation() {
        return this.requireValue(Keys.HEAD_ROTATION).asMutable();
    }

    /**
     * {@link Keys#LAST_DAMAGE_RECEIVED}
     *
     * @return The last damage received
     */
    default Value.Mutable<Double> lastDamageReceived() {
        return this.requireValue(Keys.LAST_DAMAGE_RECEIVED).asMutable();
    }

    /**
     * {@link Keys#STUCK_ARROWS}
     *
     * @return The amount of stuck arrows
     */
    default Value.Mutable<Integer> stuckArrows() {
        return this.requireValue(Keys.STUCK_ARROWS).asMutable();
    }

    /**
     * {@link Keys#WALKING_SPEED}
     *
     * @return The base walking speed
     */
    default Value.Mutable<Double> walkingSpeed() {
        return this.requireValue(Keys.WALKING_SPEED).asMutable();
    }

    /**
     * {@link Keys#BODY_ROTATIONS}
     *
     * @return The rotation of specific body parts of the living
     */
    default MapValue.Mutable<BodyPart, Vector3d> bodyRotations() {
        return this.requireValue(Keys.BODY_ROTATIONS).asMutable();
    }

    /**
     * {@link Keys#CHEST_ROTATION}
     *
     * @return The chest rotation of the entity
     */
    default Value.Mutable<Vector3d> chestRotation() {
        return this.requireValue(Keys.CHEST_ROTATION).asMutable();
    }

    /**
     * {@link Keys#IS_ELYTRA_FLYING}
     *
     * @return Whether the entity (or player) is flying with an elytra
     */
    default Value.Mutable<Boolean> elytraFlying() {
        return this.requireValue(Keys.IS_ELYTRA_FLYING).asMutable();
    }

    /**
     * {@link Keys#CAN_GRIEF}
     *
     * @return Whether the living entity may change blocks
     */
    default Optional<Value.Mutable<Boolean>> canGrief() {
        return this.getValue(Keys.CAN_GRIEF).map(Value::asMutable);
    }

    /**
     * {@link Keys#POTION_EFFECTS}
     *
     * @return The potion effects that are present on the living entity
     */
    default Optional<ListValue.Mutable<PotionEffect>> potionEffects() {
        return this.getValue(Keys.POTION_EFFECTS).map(ListValue::asMutable);
    }

    /**
     * Makes the entity look at the specified target position.
     *
     * @param targetPos Position to target
     */
    void lookAt(Vector3d targetPos);

    /**
     * Converts the {@link Living}'s head rotation into a quaternion direction unit vector.
     *
     * @return The direction of the head
     */
    default Vector3d headDirection() {
        final Vector3d headRotation = this.headRotation().get();
        return Quaterniond.fromAxesAnglesDeg(headRotation.x(), -headRotation.y(), headRotation.z()).direction();
    }
}
