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
package org.spongepowered.api.util;

import static com.google.common.base.Preconditions.checkNotNull;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.Queries;
import org.spongepowered.api.data.manipulator.mutable.entity.RespawnLocationData;
import org.spongepowered.api.data.persistence.AbstractDataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Nullable;

/**
 * Represents a position for a player to respawn in in a particular world.
 * Instances can be obtained using {@link RespawnLocationData} or by using the
 * {@link #builder()}.
 */
public final class RespawnLocation implements DataSerializable {

    /**
     * Creates a new {@link Builder} to build a {@link RespawnLocation}.
     *
     * @return A new builder
     */
    public static Builder builder() {
        return new Builder();
    }

    private final UUID worldId;
    private final Vector3d position;
    private final boolean forced;

    RespawnLocation(Builder builder) {
        this.worldId = checkNotNull(builder.world, "World UUID");
        this.position = checkNotNull(builder.position, "Position");
        this.forced = builder.forced;
    }

    /**
     * Gets the {@link UUID} of the world this position refers to.
     *
     * @return The world UUID
     */
    public UUID getWorldUniqueId() {
        return this.worldId;
    }

    /**
     * Gets the position within the world of this spawn point.
     *
     * @return The spawn position
     */
    public Vector3d getPosition() {
        return this.position;
    }

    /**
     * Gets whether the spawn position is forced in the given world, if
     * available. A forced position will spawn the player there even if a bed is
     * missing or obstructed.
     *
     * @return Whether the position is forced in the world
     */
    public boolean isForced() {
        return this.forced;
    }

    /**
     * Gets this spawn position as a {@link Location} object, if the world is
     * available.
     *
     * @return The position object, if available.
     */
    public Optional<Location<World>> asLocation() {
        Optional<World> world = Sponge.getServer().getWorld(getWorldUniqueId());
        if (!world.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(new Location<>(world.get(), getPosition()));
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew()
                .set(Queries.CONTENT_VERSION, getContentVersion())
                .set(Queries.POSITION_X, getPosition().getX())
                .set(Queries.POSITION_Y, getPosition().getY())
                .set(Queries.POSITION_Z, getPosition().getZ())
                .set(Queries.FORCED_SPAWN, isForced())
                .set(Queries.WORLD_ID, getWorldUniqueId().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RespawnLocation that = (RespawnLocation) o;
        return this.forced == that.forced
                && Objects.equals(this.worldId, that.worldId)
                && Objects.equals(this.position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.worldId, this.position, this.forced);
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("worldId", this.worldId)
                .add("position", this.position)
                .add("forced", this.forced)
                .toString();
    }

    /**
     * A helper class to build {@link RespawnLocation}s.
     */
    public static final class Builder extends AbstractDataBuilder<RespawnLocation> {

        @Nullable UUID world;
        @Nullable Vector3d position;
        boolean forced = false;

        /**
         * Creates a new {@link Builder}.
         */
        public Builder() {
            super(RespawnLocation.class, 1);
        }

        /**
         * Sets the {@link UUID} of the provided {@link World} into this
         * builder.
         *
         * @param world The world to get the uuid from
         * @return This builder, for chaining
         */
        public Builder world(World world) {
            return world(checkNotNull(world, "World cannot be null!").getUniqueId());
        }

        /**
         * Sets the {@link UUID} of the desired {@link World}. There are no
         * validation checks to whether a world exists with the provided uuid,
         * mainly for reasons when multiple worlds are loaded and unloaded.
         *
         * @param worldId The world unique id
         * @return This builder, for chaining
         */
        public Builder world(UUID worldId) {
            this.world = checkNotNull(worldId, "World UUID cannot be null!");
            return this;
        }

        /**
         * Sets the {@link UUID} of the {@link Location} provided {@link World},
         * and the {@link Vector3d} position to respawn at.
         *
         * @param location The location desired
         * @return This builder, for chaining
         * @throws IllegalStateException If the location's extent is null
         */
        public Builder location(Location<World> location) {
            checkNotNull(location, "Location cannot be null!");
            final World world = location.getExtent();
            position(location.getPosition());
            world(world.getUniqueId());
            return this;
        }

        /**
         * Sets the {@link Vector3d} position of where to respawn at.
         *
         * @param position The position to respawn at
         * @return This builder, for chaining
         */
        public Builder position(Vector3d position) {
            this.position = checkNotNull(position, "Position cannot be null!");
            return this;
        }

        /**
         * Sets whether the position to respawn at is forced or can be varied
         * for safety.
         *
         * @param isForced If the respawn position is forced
         * @return This builder, for chaining
         */
        public Builder forceSpawn(boolean isForced) {
            this.forced = isForced;
            return this;
        }

        @Override
        protected Optional<RespawnLocation> buildContent(DataView container) throws InvalidDataException {
            final String worldString = container.getString(Queries.WORLD_ID).get();
            final UUID worldId = UUID.fromString(worldString);
            final double xPos = container.getDouble(Queries.POSITION_X).get();
            final double yPos = container.getDouble(Queries.POSITION_Y).get();
            final double zPos = container.getDouble(Queries.POSITION_Z).get();
            final Vector3d position = new Vector3d(xPos, yPos, zPos);
            final boolean forcedSpawn = container.getBoolean(Queries.FORCED_SPAWN).orElse(false);
            final Builder builder = new Builder();
            builder.world = worldId;
            builder.position = position;
            builder.forced = forcedSpawn;
            return Optional.of(new RespawnLocation(builder));
        }

        @Override
        public Builder reset() {
            this.world = null;
            this.position = null;
            this.forced = false;
            return this;
        }

        @Override
        public Builder from(RespawnLocation value) {
            checkNotNull(value, "RespawnLocation cannot be null!");
            this.world = value.getWorldUniqueId();
            this.position = value.getPosition();
            this.forced = value.isForced();
            return this;
        }

        /**
         * Creates a new {@link RespawnLocation} from this builder.
         *
         * @return The new respawn location
         */
        public RespawnLocation build() {
            checkNotNull(this.world, "World id cannot be null!");
            checkNotNull(this.position, "Position cannot be null!");
            return new RespawnLocation(this);
        }
    }
}
