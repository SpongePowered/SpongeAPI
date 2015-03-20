/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.block.tile;

import org.spongepowered.api.block.tile.data.MobSpawnerData;

/**
 * Represents a Monster Spawner.
 */
public interface MobSpawner extends TileEntity {

    /**
     * Trigger an immediate spawn of a batch of entities.
     *
     * <p>This will obey the restrictions of maximum nearby entities and player
     * range unless the {@code force} flag is set.</p>
     *
     * @param force Whether to ignore spawning restrictions
     */
    void spawnEntityBatchImmediately(boolean force);

    /**
     * Gets the data that this {@link MobSpawner} is currently using.
     *
     * @return The current spawner data
     */
    MobSpawnerData getSpawnerData();

    /**
     * Sets the requested {@link MobSpawnerData} onto this {@link MobSpawner}.
     *
     * <p>Validation is performed on the {@link MobSpawnerData} to ensure the
     * desired data is properly set.</p>
     *
     * @param data The mob spawner data to set
     * @return The transaction result
     */
    TileDataTransactionResult setMobSpawnerData(MobSpawnerData data);
}
