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
package org.spongepowered.api.world.gen;

import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.extent.ImmutableBiomeVolume;
import org.spongepowered.api.world.gen.populator.RandomObject;

import java.util.Random;

/**
 * After the initial terrain has been generated, the populators step in to add
 * trees, grass, flowers, ores, etc.
 *
 * <p>A populator has access to some nearby chunks, so it can more easily place
 * objects that cross chunk boundaries.</p>
 *
 * <p>Instead of directly implementing this interface, it may be easier to
 * implement {@link PopulatorObject} instead, and use the {@link RandomObject}
 * populator to get a populator that spawns that object.</p>
 *
 * <p>Note that blocks are not captured, nor are events thrown for block changes
 * from a populator performing block changes.</p>
 *
 * @see PopulatorObject
 */
public interface Populator {

    /**
     * Gets the type of this populator.
     * 
     * <p>It should be noted that the relationship of classes implementing
     * {@link Populator} and {@link PopulatorType}s is not a one-to-one
     * relationship. That is to say that multiple different populators could
     * return the same {@link PopulatorType} for the purposes of grouping (A
     * plugin populator creating custom glowstone clusters may want to return
     * {@link PopulatorTypes#GLOWSTONE} so that other plugins can recognize
     * changes that it makes as being part of the generation of glowstone).</p>
     * 
     * @return The populator type
     */
    PopulatorType getType();

    /**
     * Applies the populator to the given {@link Extent} volume. The entire volume
     * of the given extent should be populated.
     * 
     * <p>Due to their transitive nature virtual biomes cannot be fetched from
     * the given extent, instead your populator should override
     * {@link #populate(World, Extent, Random, ImmutableBiomeVolume)} to make use
     * of the ImmutableBiomeArea which does contain virtual biome types.</p>
     *
     * @param world The World within which the generation in happening
     * @param volume The volume to be populated
     * @param random A random number generator. This random number generator is
     *        based on the world seed and the chunk position. It is shared with
     *        with other populators
     */
    void populate(World world, Extent volume, Random random);

    /**
     * Applies the populator to the given {@link Extent} volume. The entire volume
     * of the given extent should be populated.
     *
     * @param world The World within which the generation in happening
     * @param volume The volume to be populated
     * @param random A random number generator. This random number generator is
     *        based on the world seed and the chunk position. It is shared with
     *        with other populators
     * @param virtualBiomes A biome volume for the extent being populated which
     *        includes any virtual biomes not persisted to the world
     */
    default void populate(World world, Extent volume, Random random, ImmutableBiomeVolume virtualBiomes) {
        populate(world, volume, random);
    }

}
