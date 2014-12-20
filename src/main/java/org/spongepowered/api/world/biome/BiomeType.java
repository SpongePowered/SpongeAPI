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

package org.spongepowered.api.world.biome;

import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a biome.
 */
public interface BiomeType {

    /**
     * Get the temperature of this biome.
     *
     * @return The temperature
     */
    double getTemperature();

    /**
     * Get the humidity of this biome.
     *
     * @return The humidity
     */
    double getHumidity();

    /**
     * Get the minimum terrain height of this biome.
     * 
     * @return The min height
     */
    float getMinHeight();

    /**
     * Get the maximum terrain height of this biome.
     * 
     * @return The max height
     */
    float getMaxHeight();

    /**
     * Returns an ordered Collection of {@link Populator}s specific to this
     * biome.
     * 
     * @return The populators
     */
    Iterable<Populator> getPopulators();

    /**
     * Inserts a new populator to this Biome's ordered collection of
     * populators. The new populator is inserted at the given index. If the
     * index is larger than the current amount of populators then the new
     * populator in inserted at the end of the collection.
     * 
     * @param populator The new populator
     * @param index THe index to insert the populator at
     */
    void insertPopulator(Populator populator, int index);

}
