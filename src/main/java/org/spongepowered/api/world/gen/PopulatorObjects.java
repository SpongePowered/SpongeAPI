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

package org.spongepowered.api.world.gen;

import com.flowpowered.math.vector.Vector3i;
import com.google.common.base.Preconditions;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.World;

import java.util.Random;

/**
 * Methods for using a {@link PopulatorObject} as a {@link Populator}. These
 * methods follow the rules for populators as outlined by
 * {@link Populator#populate(Chunk, Random)}.
 *
 */
public class PopulatorObjects {

    private static class RandomHeightPopulator implements Populator {

        private final int attemptsPerChunk;
        private final double chancePerAttempt;
        private final int maxY;
        private final int minY;
        private final PopulatorObject object;

        private RandomHeightPopulator(int attemptsPerChunk, double chancePerAttempt, int maxY, int minY, PopulatorObject object) {
            Preconditions.checkArgument(attemptsPerChunk > 0, "attemptPerChunk must be larger than 0");
            Preconditions.checkArgument(chancePerAttempt >= 0 && chancePerAttempt <= 1, "changePerAttempt must be between 0 and 1, inclusive");
            Preconditions.checkArgument(maxY >= minY, "maxY must be larger than or equal to minY");
            Preconditions.checkNotNull(object, "object");

            this.attemptsPerChunk = attemptsPerChunk;
            this.chancePerAttempt = chancePerAttempt;
            this.maxY = maxY;
            this.minY = minY;
            this.object = object;
        }

        @Override
        public void populate(Chunk chunk, Random random) {
            Vector3i chunkPos = chunk.getPosition();
            int populationStartX = chunkPos.getX() * 16 + 8;
            int populationStartZ = chunkPos.getZ() * 16 + 8;
            World world = chunk.getWorld();

            for (int i = 0; i < this.attemptsPerChunk; i++) {
                if (this.chancePerAttempt >= random.nextDouble()) {
                    int spawnX = populationStartX + random.nextInt(16);
                    int spawnY = random.nextInt(this.maxY - this.minY + 1) + this.minY;
                    int spawnZ = populationStartZ + random.nextInt(16);

                    if (this.object.canPlaceAt(world, spawnX, spawnY, spawnZ)) {
                        this.object.placeObject(world, spawnX, spawnY, spawnZ);
                    }
                }
            }
        }
    }

    /**
     * Creates a populator that spawns the given object at a random y location.
     *
     * @param object The object to spawn.
     * @param attemptsPerChunk How many times an attempt should be made to place
     *        this object in a chunk.
     * @param chancePerAttempt The chance that each attempt succeeds, between 0
     *        and 1, inclusive.
     * @param minY The minimum y location, inclusive.
     * @param maxY The maximum y location, inclusive.
     * @return the populator
     */
    public static Populator spawnAtRandomHeight(PopulatorObject object, int attemptsPerChunk,
            double chancePerAttempt, int minY, int maxY) {
        return new RandomHeightPopulator(attemptsPerChunk, chancePerAttempt, maxY, maxY, object);
    }
}
