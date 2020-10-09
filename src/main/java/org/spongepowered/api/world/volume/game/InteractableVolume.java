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
package org.spongepowered.api.world.volume.game;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.volume.block.ReadableBlockVolume;
import org.spongepowered.math.vector.Vector3i;

import java.time.Duration;
import java.util.Objects;

public interface InteractableVolume extends ReadableBlockVolume, LocationBaseDataHolder {

    /**
     * Simulates hitting a block as if a player had done so.
     *
     * <p>The difference between this and {@link #digBlock} is that this will
     * only do a single instantaneous "click" whereas digBlock will simulate
     * holding the primary mouse button until the block breaks.</p>
     *
     * @param position The position of the block
     * @param side The side of the block to interact with
     * @param profile The game profile of the player this is imitating
     * @return True if the interact succeeded
     */
    default boolean hitBlock(Vector3i position, Direction side, GameProfile profile) {
        return hitBlock(Objects.requireNonNull(position, "position").getX(), position.getY(), position.getZ(), side, profile);
    }

    /**
     * Simulates hitting a block as if a player had done so.
     *
     * <p>The difference between this and {@link #digBlock} is that this will
     * only do a single instantaneous "click" whereas digBlock will simulate
     * holding the primary mouse button until the block breaks.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param side The side of the block to interact with
     * @param profile The game profile of the player this is imitating
     * @return True if the interact succeeded
     */
    boolean hitBlock(int x, int y, int z, Direction side, GameProfile profile);

    /**
     * Simulates the interaction the block as if a player had done so.
     *
     * @param position The position of the block
     * @param side The side of the block to interact with
     * @param profile The game profile of the player this is imitating
     * @return True if the interact succeeded
     */
    default boolean interactBlock(Vector3i position, Direction side, GameProfile profile) {
        return interactBlock(Objects.requireNonNull(position, "position").getX(), position.getY(), position.getZ(), side, profile);
    }

    /**
     * Simulates the interaction the block as if a player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param side The side of the block to interact with
     * @param profile The game profile of the player this is imitating
     * @return True if the interact succeeded
     */
    boolean interactBlock(int x, int y, int z, Direction side, GameProfile profile);

    /**
     * Simulates the interaction the block using the given item as if the player
     * had done so.
     *
     * @param position The position of the block
     * @param itemStack The item
     * @param side The side of the block to interact with
     * @param profile The game profile of the player this is imitating
     * @return True if the interact succeeded
     */
    default boolean interactBlockWith(Vector3i position, ItemStack itemStack, Direction side, GameProfile profile) {
        return interactBlockWith(Objects.requireNonNull(position, "position").getX(), position.getY(), position.getZ(), itemStack, side, profile);
    }

    /**
     * Simulates the interaction the block using the given item as if the player
     * had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The item
     * @param side The side of the block to interact with
     * @param profile The game profile of the player this is imitating
     * @return True if the interact succeeded
     */
    boolean interactBlockWith(int x, int y, int z, ItemStack itemStack, Direction side, GameProfile profile);

    /**
     * Simulates the placement of a block at the given location as if a player
     * had done so.
     *
     * @param position The position of the block
     * @param block The block state to be set to
     * @param side The face of the block to place on
     * @param profile The game profile of the player this is imitating
     * @return Whether the block was successfully set
     */
    default boolean placeBlock(Vector3i position, BlockState block, Direction side, GameProfile profile) {
        return placeBlock(Objects.requireNonNull(position, "position").getX(), position.getY(), position.getZ(), block, side, profile);
    }

    /**
     * Simulates the placement of a block at the given location as if a player
     * had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param block The block state to be set to
     * @param side The face of the block to place on
     * @param profile The game profile of the player this is imitating
     * @return Whether the block was successfully set
     */
    boolean placeBlock(int x, int y, int z, BlockState block, Direction side, GameProfile profile);

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @param position The position of the block
     * @param profile The game profile of the player this is imitating
     * @return Whether the block was destroyed
     */
    default boolean digBlock(Vector3i position, GameProfile profile) {
        return digBlock(Objects.requireNonNull(position, "position").getX(), position.getY(), position.getZ(), profile);
    }

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param profile The game profile of the player this is imitating
     * @return Whether the block was destroyed
     */
    boolean digBlock(int x, int y, int z, GameProfile profile);

    /**
     * Simulate the digging of the block with the given tool as if a player had
     * done so.
     * 
     * @param position The position of the block
     * @param itemStack The tool
     * @param profile The game profile of the player this is imitating
     * @return Whether the block was destroyed
     */
    default boolean digBlockWith(Vector3i position, ItemStack itemStack, GameProfile profile) {
        return digBlockWith(Objects.requireNonNull(position, "position").getX(), position.getY(), position.getZ(), itemStack, profile);
    }

    /**
     * Simulate the digging of the block with the given tool as if a player had
     * done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The tool
     * @param profile The game profile of the player this is imitating
     * @return Whether the block was destroyed
     */
    boolean digBlockWith(int x, int y, int z, ItemStack itemStack, GameProfile profile);

    /**
     * Gets the {@link Duration} it takes to dig this block with the specified item.
     *
     * @param position The position of the block
     * @param itemStack The item to pretend-dig with
     * @param profile The game profile of the player this is imitating
     * @return The duration it takes to dig the block
     */
    default Duration getBlockDigTimeWith(Vector3i position, ItemStack itemStack, GameProfile profile) {
        return getBlockDigTimeWith(Objects.requireNonNull(position, "position").getX(), position.getY(), position.getZ(), itemStack, profile);
    }

    /**
     * Gets the {@link Duration} it takes to dig this block with the specified item.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The item to pretend-dig with
     * @param profile The game profile of the player this is imitating
     * @return The duration it takes to dig the block
     */
    Duration getBlockDigTimeWith(int x, int y, int z, ItemStack itemStack, GameProfile profile);
}
