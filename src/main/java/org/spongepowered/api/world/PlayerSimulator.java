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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.Direction;

/**
 * Simulates the results of a player interacting with the world.
 */
public interface PlayerSimulator {

    /**
     * Simulates the interaction with this object as if a player had done so.
     *
     * @param position The position of the block
     * @param side The side of the block to interact with
     */
    void interactBlock(Vector3i position, Direction side);

    /**
     * Simulates the interaction with this object as if a player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param side The side of the block to interact with
     */
    void interactBlock(int x, int y, int z, Direction side);

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param position The position of the block
     * @param itemStack The item
     * @param side The side of the block to interact with
     */
    void interactBlockWith(Vector3i position, ItemStack itemStack, Direction side);

    /**
     * Simulates the interaction with this object using the given item as if
     * the player had done so.
     *
     * @param x The X position
     * @param y The Y position
     * @param z The Z position
     * @param itemStack The item
     * @param side The side of the block to interact with
     */
    void interactBlockWith(int x, int y, int z, ItemStack itemStack, Direction side);

    /**
     * Simulate the digging of the block as if a player had done so.
     *
     * @param position The position of the block
     * @return Whether the block was destroyed
     */
    boolean digBlock(Vector3i position);

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
     * Simulate the digging of the block with the given tool as if a player
     * had done so.
     *
     * @param position The position of the block
     * @param itemStack The tool
     * @return Whether the block was destroyed
     */
    boolean digBlockWith(Vector3i position, ItemStack itemStack);

    /**
     * Simulate the digging of the block with the given tool as if a player
     * had done so.
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
    int getBlockDigTimeWith(Vector3i position, ItemStack itemStack);

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

}
