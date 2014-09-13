/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.block;

/**
 * Describes a voxel. Child classes define specific functionality.
 */
public interface Block {
    /**
     * Gets the id of this block.
     * <p/>
     * Ex. Minecraft registers stone as "minecraft:stone"
     *
     * @return The id
     */
    String getID();

    /**
     * Gets the redstone power level (0-15) of the block.
     * <p/>
     * Ex. A directly-powered block would return 15, a non-powered block would return 0
     *
     * @return the block's redstone power level.
     */
    float getPowerLevel();
}
