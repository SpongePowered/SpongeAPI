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
package org.spongepowered.api.world.dimension;

import org.spongepowered.api.world.World;
import org.spongepowered.api.world.gen.TerrainGenerator;

/**
 * Represents the dimension of a {@link World}.
 */
public interface Dimension {

    /**
     * Gets the type of dimension.
     *
     * @return The type of dimension
     */
    DimensionType getType();

    /**
     * Creates a new {@link TerrainGenerator} based on the properties of this dimension.
     *
     * @return The generator
     */
    TerrainGenerator<?> createGenerator();

    /**
     * Returns whether players can respawn within {@link Dimension} after death.
     *
     * @return True if players can respawn, false if not
     */
    boolean allowsPlayerRespawns();

    /**
     * Returns whether water evaporates for {@link Dimension}.
     *
     * @return True if water evaporates, false if not
     */
    boolean doesWaterEvaporate();

    /**
     * Returns whether this {@link Dimension} has a sky (lack of a bedrock ceiling).
     *
     * @return True if sky is present, false if not
     */
    boolean hasSky();

    /**
     * Returns whether this {@link Dimension} has light provided by the sky.
     *
     * @return True if light is provided by the sky, false if not
     */
    boolean hasSkyLight();

    /**
     * Returns whether this {@link Dimension} contains worlds that are considered surface-like.
     *
     * <p>
     *     In vanilla Minecraft, this is used to determine logic for several spots:
     *     <ul>
     *         <li>Can Player's sleep?</li>
     *         <li>Can Zombie Pigmen spawn around a nether portal?</li>
     *     </ul>
     * </p>
     * @return True if surface like, false if not
     */
    boolean isSurfaceLike();
}
