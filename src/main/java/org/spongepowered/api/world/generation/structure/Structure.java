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
package org.spongepowered.api.world.generation.structure;

import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.entity.EntityCategory;
import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.biome.spawner.NaturalSpawner;
import org.spongepowered.api.world.generation.feature.DecorationStep;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * A structure used in world generation.
 */
@CatalogedBy(Structures.class)
public interface Structure extends DefaultedRegistryValue {

    /**
     * Places the structure at given position and world
     *
     * @param world The world
     * @param pos The position
     *
     * @return true when the feature was successfully placed
     */
    boolean place(ServerWorld world, Vector3i pos);

    /**
     * Places the structure at given location
     *
     * @param location The location
     *
     * @return true when the feature was successfully placed
     */
    boolean place(ServerLocation location);

    /**
     * Returns the biomes the structure is allowed in.
     *
     * @return The allowed biomes.
     */
    Collection<Biome> allowedBiomes();

    /**
     * Returns the decoration step the structure is used in.
     *
     * @return The decoration step
     */
    DecorationStep decorationStep();

    /**
     * Returns the structure type.
     *
     * @return The structure type
     */
    StructureType type();

    /**
     * Returns the spawner overrides to use in the structure instead of {@link Biome#spawners()}
     *
     * @return The spawner overrides
     */
    Map<EntityCategory, StructureNaturalSpawner> spawners();

    /**
     * Returns the serialized structure configuration.
     * <p>Reconfigure a structure using {@link StructureType#configure(DataView)}</p>
     *
     * @return The serialized structure configuration
     */
    DataView toContainer();

    interface StructureNaturalSpawner {

        /**
         * Returns whether the full structure or only the structure piece is affected.
         *
         * @return Whether the full structure is affected
         */
        boolean full();

        /**
         * Returns the list of natural spawners to use.
         *
         * @return The list of spawners to use
         */
        List<NaturalSpawner> spawners();
    }
}
