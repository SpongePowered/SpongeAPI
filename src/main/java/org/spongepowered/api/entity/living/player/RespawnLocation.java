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

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.manipulator.mutable.entity.RespawnLocationData;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Optional;
import java.util.UUID;

/**
 * Represents a location for a player to respawn in in a particular world.
 * Instances can be obtained using {@link RespawnLocationData}.
 */
public interface RespawnLocation {

    /**
     * Gets the {@link UUID} of the world this location refers to.
     *
     * @return The world UUID
     */
    UUID getWorldUniqueId();

    /**
     * Gets the position within the world of this spawn point.
     *
     * @return The spawn position
     */
    Vector3d getPosition();

    /**
     *
     * Gets whether the spawn location is forced in the given world, if
     * available. A forced location will spawn the player there even if a bed is
     * missing or obstructed.
     *
     * @return Whether the location is forced in the world
     */
    boolean isForced();

    /**
     * Gets this spawn location as a {@link Location} object, if the world is
     * available.
     *
     * @return The location object, if available.
     */
    default Optional<Location<World>> asLocation() {
        Optional<World> world = Sponge.getServer().getWorld(getWorldUniqueId());
        if (!world.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(new Location<>(world.get(), getPosition()));
    }

}
