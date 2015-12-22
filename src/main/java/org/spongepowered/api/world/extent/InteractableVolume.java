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
package org.spongepowered.api.world.extent;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.NamedCause;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.util.Direction;

public interface InteractableVolume extends BlockVolume {

    /**
     * Simulates the interaction the block as if a player had done so.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param position The position of the block
     * @param side The side of the block to interact with
     * @param cause The cause containing either a player, user, or game profile
     * @return True if the interact succeeded
     */
    default boolean hitBlock(Vector3i position, Direction side, Cause cause) {
        return hitBlock(position.getX(), position.getY(), position.getZ(), side, cause);
    }

    /**
     * Simulates the "hitting" the block if a player had done so.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param side The side of the block to interact with
     * @param cause The cause containing either a player, user, or game profile
     * @return True if the interact succeeded
     */
    boolean hitBlock(int x, int y, int z, Direction side, Cause cause);

    /**
     * Simulates the interaction the block as if a player had done so.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param position The position of the block
     * @param side The side of the block to interact with
     * @param cause The cause containing either a player, user, or game profile
     * @return True if the interact succeeded
     */
    default boolean interactBlock(Vector3i position, Direction side, Cause cause) {
        return interactBlock(position.getX(), position.getY(), position.getZ(), side, cause);
    }

    /**
     * Simulates the interaction the block as if a player had done so.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param side The side of the block to interact with
     * @param cause The cause containing either a player, user, or game profile
     * @return True if the interact succeeded
     */
    boolean interactBlock(int x, int y, int z, Direction side, Cause cause);

    /**
     * Simulates the interaction the block using the given item as if
     * the player had done so.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param position The position of the block
     * @param itemStack The item
     * @param side The side of the block to interact with
     * @param cause The cause containing either a player, user, or game profile
     * @return True if the interact succeeded
     */
    default boolean interactBlockWith(Vector3i position, ItemStack itemStack, Direction side, Cause cause) {
        return interactBlockWith(position.getX(), position.getY(), position.getZ(), itemStack, side, cause);
    }

    /**
     * Simulates the interaction the block using the given item as if
     * the player had done so.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The item
     * @param side The side of the block to interact with
     * @param cause The cause containing either a player, user, or game profile
     * @return True if the interact succeeded
     */
    boolean interactBlockWith(int x, int y, int z, ItemStack itemStack, Direction side, Cause cause);

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param position The position of the block
     * @param cause The cause containing either a player, user, or game profile
     * @return Whether the block was destroyed
     */
    default boolean digBlock(Vector3i position, Cause cause) {
        return digBlock(position.getX(), position.getY(), position.getZ(), cause);
    }

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param cause The cause containing either a player, user, or game profile
     * @return Whether the block was destroyed
     */
    boolean digBlock(int x, int y, int z, Cause cause);

    /**
     * Simulate the digging of the block with the given tool as if a player
     * had done so.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param position The position of the block
     * @param itemStack The tool
     * @param cause The cause containing either a player, user, or game profile
     * @return Whether the block was destroyed
     */
    default boolean digBlockWith(Vector3i position, ItemStack itemStack, Cause cause) {
        return digBlockWith(position.getX(), position.getY(), position.getZ(), itemStack, cause);
    }

    /**
     * Simulate the digging of the block with the given tool as if a player
     * had done so.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The tool
     * @param cause The cause containing either a player, user, or game profile
     * @return Whether the block was destroyed
     */
    boolean digBlockWith(int x, int y, int z, ItemStack itemStack, Cause cause);

    /**
     * Gets the time it takes to dig this block the specified item in ticks.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param position The position of the block
     * @param itemStack The item to pretend-dig with
     * @param cause The cause containing either a player, user, or game profile
     * @return The time in ticks
     */
    default int getBlockDigTimeWith(Vector3i position, ItemStack itemStack, Cause cause) {
        return getBlockDigTimeWith(position.getX(), position.getY(), position.getZ(), itemStack, cause);
    }

    /**
     * Gets the time it takes to dig this block the specified item in ticks.
     *
     * <p>Note that the requirement in the {@link Cause} is that it contains
     * either a {@link Player}, {@link User}, or {@link GameProfile}.
     * Additionally, the {@link NamedCause} must be
     * {@link NamedCause#simulated(Object)}. Failing to do either of these
     * will result in an {@link IllegalArgumentException} being thrown.</p>
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The item to pretend-dig with
     * @param cause The cause containing either a player, user, or game profile
     * @return The time in ticks
     */
    int getBlockDigTimeWith(int x, int y, int z, ItemStack itemStack, Cause cause);
}
