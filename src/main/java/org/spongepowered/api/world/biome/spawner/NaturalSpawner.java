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
package org.spongepowered.api.world.biome.spawner;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.world.biome.Biome;

/**
 * Natural spawner configuration in a {@link Biome}.
 * See {@link Keys#NATURAL_SPAWNERS} and {@link Keys#SPAWN_CHANCE}.
 * Alternatively use {@link NaturalSpawnCost}.
 */
public interface NaturalSpawner {

    static NaturalSpawner of(EntityType<?> type, int weight, int min, int max) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(type, weight, min, max);
    }

    /**
     * Returns the entity type to spawn.
     *
     * @return The entity type to spawn
     */
    EntityType<?> type();

    /**
     * Returns the minimum amount to spawn in an attempt.
     *
     * @return The minimum amount
     */
    int min();

    /**
     * Returns the maximum amount to spawn in an attempt.
     *
     * @return The maximum amount
     */
    int max();

    /**
     * Returns the relative spawn weight.
     *
     * @return The spawn weight
     */
    int weight();

    interface Factory {

        NaturalSpawner of(EntityType<?> type, int weight, int min, int max);

    }
}
