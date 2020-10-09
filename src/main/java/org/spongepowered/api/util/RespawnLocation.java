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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.persistence.AbstractDataBuilder;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.persistence.Queries;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3d;

import java.util.Objects;
import java.util.Optional;

/**
 * Represents a position for a player to respawn in in a particular world.
 * Instances can be obtained using {@link Keys#RESPAWN_LOCATIONS} or by using the
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

    private final ResourceKey world;
    private final Vector3d position;
    private final boolean forced;

    RespawnLocation(Builder builder) {
        this.world = Objects.requireNonNull(builder.world);
        this.position = Objects.requireNonNull(builder.position);
        this.forced = builder.forced;
    }

    /**
     * Gets the {@link ResourceKey key} of the world.
     *
     * @return The key
     */
    public ResourceKey getWorldKey() {
        return this.world;
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
     * Gets this spawn position as a {@link ServerLocation} object, if the world is
     * available.
     *
     * @return The position object, if available.
     */
    public Optional<ServerLocation> asLocation() {
        Optional<ServerWorld> optWorld = Sponge.getServer().getWorldManager().getWorld(this.getWorldKey());
        return optWorld.map(world -> ServerLocation.of(world, getPosition()));
    }

    @Override
    public int getContentVersion() {
        return 2;
    }

    @Override
    public DataContainer toContainer() {
        return DataContainer.createNew()
                .set(Queries.CONTENT_VERSION, getContentVersion())
                .set(Queries.POSITION_X, getPosition().getX())
                .set(Queries.POSITION_Y, getPosition().getY())
                .set(Queries.POSITION_Z, getPosition().getZ())
                .set(Queries.FORCED_SPAWN, isForced())
                .set(Queries.WORLD_KEY, this.getWorldKey().getFormatted());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final RespawnLocation that = (RespawnLocation) o;
        return this.forced == that.forced
                && Objects.equals(this.world, that.world)
                && Objects.equals(this.position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.world, this.position, this.forced);
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("world", this.world)
                .add("position", this.position)
                .add("forced", this.forced)
                .toString();
    }

    /**
     * A helper class to build {@link RespawnLocation}s.
     */
    public static final class Builder extends AbstractDataBuilder<RespawnLocation> implements CopyableBuilder<RespawnLocation, Builder> {

        @Nullable ResourceKey world;
        @Nullable Vector3d position;
        boolean forced = false;

        /**
         * Creates a new {@link Builder}.
         */
        public Builder() {
            super(RespawnLocation.class, 1);
        }

        /**
         * Sets the {@link ResourceKey key} of the provided {@link ServerWorld} onto this
         * builder.
         *
         * @param world The world
         * @return This builder, for chaining
         */
        public Builder world(final ServerWorld world) {
            return world(Objects.requireNonNull(world).getKey());
        }

        /**
         * Sets the {@link ResourceKey key} tied to the desired {@link ServerWorld}.
         *
         * @param key The key
         * @return This builder, for chaining
         */
        public Builder world(final ResourceKey key) {
            this.world = Objects.requireNonNull(key);
            return this;
        }

        /**
         * Sets the {@link ResourceKey key} of the {@link ServerLocation location's} provided {@link ServerWorld world},
         * and the {@link Vector3d position} to respawn at.
         *
         * @param location The location desired
         * @return This builder, for chaining
         */
        public Builder location(final ServerLocation location) {
            Objects.requireNonNull(location);
            final ServerWorld world = location.getWorld();
            this.position(location.getPosition());
            this.world(world);
            return this;
        }

        /**
         * Sets the {@link Vector3d} position of where to respawn at.
         *
         * @param position The position to respawn at
         * @return This builder, for chaining
         */
        public Builder position(final Vector3d position) {
            this.position = Objects.requireNonNull(position);
            return this;
        }

        /**
         * Sets whether the position to respawn at is forced or can be varied
         * for safety.
         *
         * @param isForced If the respawn position is forced
         * @return This builder, for chaining
         */
        public Builder forceSpawn(final boolean isForced) {
            this.forced = isForced;
            return this;
        }

        @Override
        protected Optional<RespawnLocation> buildContent(DataView container) throws InvalidDataException {
            final ResourceKey worldKey = container.getKey(Queries.WORLD_KEY).get();
            final double x = container.getDouble(Queries.POSITION_X).get();
            final double y = container.getDouble(Queries.POSITION_Y).get();
            final double z = container.getDouble(Queries.POSITION_Z).get();
            final Vector3d position = new Vector3d(x, y, z);
            final boolean forcedSpawn = container.getBoolean(Queries.FORCED_SPAWN).orElse(false);

            final Builder builder = new Builder()
                .world(worldKey)
                .position(position)
                .forceSpawn(forcedSpawn);
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
        public Builder from(final RespawnLocation value) {
            Objects.requireNonNull(value);

            this.world = value.world;
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
            Objects.requireNonNull(this.world);
            Objects.requireNonNull(this.position);

            return new RespawnLocation(this);
        }
    }
}
