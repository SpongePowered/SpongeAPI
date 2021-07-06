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
package org.spongepowered.api.entity.living.player;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.block.entity.EnderChest;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.MapValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.item.inventory.ArmorEquipable;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.entity.UserInventory;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.util.RespawnLocation;
import org.spongepowered.api.util.annotation.DoNotStore;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.math.vector.Vector3d;

import java.time.Instant;
import java.util.Optional;

/**
 * A User is the data usually associated with a Player that is persisted
 * across server restarts. This is in contrast to Player which represents
 * the in-game entity associated with an online User.
 */
@DoNotStore
public interface User extends DataHolder.Mutable, ArmorEquipable, Tamer, Subject, Carrier {

    /**
     * Gets the associated {@link GameProfile} of this player.
     *
     * @return The user's profile
     */
    GameProfile profile();

    /**
     * Gets the player's last known username.
     *
     * @return The player's last known username
     */
    @Override
    String name();

    /**
     * Checks if this user is online or not.
     *
     * @return True if the corresponding player is online
     */
    boolean isOnline();

    /**
     * Gets the related online {@link ServerPlayer player} if the player is
     * in fact online.
     *
     * @return The associated online player, if available
     */
    Optional<ServerPlayer> player();

    /**
     * Gets the position of this User
     *
     * @return The position of this User
     */
    Vector3d position();

    /**
     * Gets the world {@link ResourceKey key} of this User.
     *
     * @return The key, if found
     */
    ResourceKey worldKey();

    /**
     * Sets the world and position of this User.
     *
     * <p>The {@link ResourceKey key} must belong to an existing world.</p>
     *
     * <p>When the User {@link #isOnline()} this redirects to {@link Entity#setLocation(ServerLocation)}</p>
     *
     * @param position The position to set
     * @param world The world key
     * @return True if the location was accepted
     */
    boolean setLocation(ResourceKey world, Vector3d position);

    /**
     * Sets the rotation of this entity.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <p>{@code x -> pitch}, {@code y -> yaw}, {@code z -> roll}</p>
     *
     * @param rotation The rotation to set the entity to
     */
    void setRotation(Vector3d rotation);

    /**
     * Gets the rotation.
     *
     * <p>The format of the rotation is represented by:</p>
     *
     * <p>{@code x -> pitch}, {@code y -> yaw}, {@code z -> roll}</p>
     *
     * @return The rotation
     */
    Vector3d rotation();

    @Override
    UserInventory inventory();

    /**
     * Gets the {@link Inventory} available for this Player's shared {@link EnderChest}
     * contents.
     *
     * @return The ender chest inventory
     */
    Inventory enderChestInventory();

    /**
     * {@link Keys#RESPAWN_LOCATIONS}
     *
     * @return The spawn locations of the user may have for various worlds
     */
    default MapValue.Mutable<ResourceKey, RespawnLocation> respawnLocations() {
        return this.requireValue(Keys.RESPAWN_LOCATIONS).asMutable();
    }

    /**
     * {@link Keys#FIRST_DATE_JOINED}
     *
     * @return The timestamp value when this user first joined
     */
    default Optional<Value.Mutable<Instant>> firstJoined() {
        return this.getValue(Keys.FIRST_DATE_JOINED).map(Value::asMutable);
    }

    /**
     * {@link Keys#LAST_DATE_JOINED}
     *
     * @return The last timestamp value when this user has joined
     */
    default Optional<Value.Mutable<Instant>> lastJoined() {
        return this.getValue(Keys.LAST_DATE_JOINED).map(Value::asMutable);
    }

    /**
     * {@link Keys#INVULNERABLE}
     *
     * @return Whether the user is invulnerable
     */
    default Value.Mutable<Boolean> invulnerable() {
        return this.requireValue(Keys.INVULNERABLE).asMutable();
    }

    /**
     * {@link Keys#IS_INVISIBLE}
     *
     * @return Whether the user is invisible
     */
    default Value.Mutable<Boolean> invisible() {
        return this.requireValue(Keys.IS_INVISIBLE).asMutable();
    }

    /**
     * {@link Keys#VANISH}
     *
     * @return Whether the user is vanished
     */
    default Value.Mutable<Boolean> vanish() {
        return this.requireValue(Keys.VANISH).asMutable();
    }

    /**
     * {@link Keys#VANISH_IGNORES_COLLISION}
     *
     * @return Whether the user ignores collision with other entities
     */
    default Value.Mutable<Boolean> vanishIgnoresCollision() {
        return this.requireValue(Keys.VANISH_IGNORES_COLLISION).asMutable();
    }

    /**
     * {@link Keys#VANISH_PREVENTS_TARGETING}
     *
     * @return Whether the user can be targeted for attack by another entity
     */
    default Value.Mutable<Boolean> vanishPreventsTargeting() {
        return this.requireValue(Keys.VANISH_PREVENTS_TARGETING).asMutable();
    }
}
