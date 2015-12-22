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
package org.spongepowered.api.world;

import static com.google.common.base.Preconditions.checkNotNull;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.service.permission.Subject;
import org.spongepowered.api.util.Direction;

import java.util.Optional;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * Simulates the results of a player interacting with the world.
 */
public interface PlayerSimulator extends Subject {

    /**
     * A factory for creating instances of {@link PlayerSimulator}.
     */
    class Factory {

        private static final Function<GameProfile, PlayerSimulator> factory = null;

        /**
         * Creates a new {@link PlayerSimulator} with the given profile.
         *
         * @param profile The game profile
         * @return A new simulator instance
         */
        public static PlayerSimulator createSimulator(GameProfile profile) {
            return factory.apply(checkNotNull(profile, "profile"));
        }
    }

    /**
     * Gets the game profile that represents this simulator.
     *
     * @return The game profile
     */
    GameProfile getProfile();

    /**
     * Gets the world this simulator is currently in, if it's in a loaded world.
     *
     * @return The world, if in one
     */
    Optional<World> getWorld();

    /**
     * Sets the world the simulator is in.
     *
     * @param world The world, or null to take out of the world
     * @return This instance, for fluent chaining
     */
    PlayerSimulator setWorld(@Nullable World world);

    /**
     * Gets the cause that will be passed to events fired from actions caused by
     * this simulator. If no cause has been set, the default cause is this
     * simulator as the root.
     *
     * @return The cause
     */
    Cause getCause();

    /**
     * Sets the cause that will be passed to events fired from actions caused by
     * this simulator. If null is passed, the default cause is this simulator as
     * the root.
     *
     * @param cause The cause, or null to use the default cause.
     * @return This instance, for fluent chaining
     */
    PlayerSimulator setCause(@Nullable Cause cause);

    /**
     * Simulates the interaction with this object as if a player had done so.
     *
     * @param position The position of the block
     * @param side The side of the block to interact with
     * @return Whether the interaction was successful
     */
    default boolean interactBlock(Vector3i position, Direction side) {
        return interactBlock(checkNotNull(position, "position").getX(), position.getY(), position.getZ(), checkNotNull(side, "side"));
    }

    /**
     * Simulates the interaction with this object as if a player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param side The side of the block to interact with
     * @return Whether the interaction was successful
     */
    boolean interactBlock(int x, int y, int z, Direction side);

    /**
     * Simulates the interaction with this object using the given item as if the
     * player had done so.
     *
     * @param position The position of the block
     * @param itemStack The item
     * @param side The side of the block to interact with
     * @return Whether the interaction was successful
     */
    default boolean interactBlockWith(Vector3i position, ItemStack itemStack, Direction side) {
        return interactBlockWith(checkNotNull(position, "position").getX(), position.getY(), position.getZ(), checkNotNull(itemStack, "itemStack"),
                checkNotNull(side, "side"));
    }

    /**
     * Simulates the interaction with this object using the given item as if the
     * player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The item
     * @param side The side of the block to interact with
     * @return Whether the interaction was successful
     */
    boolean interactBlockWith(int x, int y, int z, ItemStack itemStack, Direction side);

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @param position The position of the block
     * @return Whether the block was destroyed
     */
    default boolean digBlock(Vector3i position) {
        return digBlock(checkNotNull(position, "position").getX(), position.getY(), position.getZ());
    }

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @return Whether the block was destroyed
     */
    boolean digBlock(int x, int y, int z);

    /**
     * Simulate the digging of the block with the given tool as if a player had
     * done so.
     *
     * @param position The position of the block
     * @param itemStack The tool
     * @return Whether the block was destroyed
     */
    default boolean digBlockWith(Vector3i position, ItemStack itemStack) {
        return digBlockWith(checkNotNull(position, "position").getX(), position.getY(), position.getZ(), checkNotNull(itemStack, "itemStack"));
    }

    /**
     * Simulate the digging of the block with the given tool as if a player had
     * done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The tool
     * @return Whether the block was destroyed
     */
    boolean digBlockWith(int x, int y, int z, ItemStack itemStack);

    /**
     * Gets the time it takes to dig this block the specified item in ticks.
     *
     * @param position The position of the block
     * @param itemStack The item to pretend-dig with
     * @return The time in ticks
     */
    default int getBlockDigTimeWith(Vector3i position, ItemStack itemStack) {
        return getBlockDigTimeWith(checkNotNull(position, "position").getX(), position.getY(), position.getZ(), checkNotNull(itemStack, "itemStack"));
    }

    /**
     * Gets the time it takes to dig this block the specified item in ticks.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The item to pretend-dig with
     * @return The time in ticks
     */
    int getBlockDigTimeWith(int x, int y, int z, ItemStack itemStack);

    /**
     * Simulates the placement of a block at the given location as though a
     * player had done so.
     *
     * @param position The position of the block
     * @param block The block state to be set to
     * @return Whether the block was successfully set
     */
    default boolean setBlock(Vector3i position, BlockState block) {
        return setBlock(checkNotNull(position, "position").getX(), position.getY(), position.getZ(), block);
    }

    /**
     * Simulates the placement of a block at the given location as though a
     * player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param block The block state to be set to
     * @return Whether the block was successfully set
     */
    boolean setBlock(int x, int y, int z, BlockState block);

}
