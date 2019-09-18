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
package org.spongepowered.api.world.volume.game;

import org.spongepowered.api.world.volume.block.ReadableBlockVolume;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3i;

public interface WeatherAwareVolume extends ReadableBlockVolume {

    /**
     * Returns the y level that precipitation ends falling in the given column.
     *
     * <p>A value is still returned for columns in biomes which do not
     * receive precipitation.</p>
     *
     * @param x The x column value
     * @param z The y column value
     * @return The y level that precipitation ends
     */
    int getPrecipitationLevelAt(int x, int z);

    /**
     * Returns the y level that precipitation ends falling in the given column.
     *
     * <p>A value is still returned for columns in biomes which do not
     * receive precipitation.</p>
     *
     * @param column The column value
     * @return The y level that precipitation ends
     */
    default int getPrecipitationLevelAt(Vector2i column) {
        return this.getPrecipitationLevelAt(column.getX(), column.getY());
    }

    /**
     * Returns the position that precipitation ends falling in the column
     * of the given position.
     *
     * <p>A position is still returned for positions in biomes which do not
     * receive precipitation.</p>
     *
     * @param position The position value
     * @return The position that precipitation ends
     */
    default Vector3i getPrecipitationLevelAt(Vector3i position) {
        return new Vector3i(position.getX(), this.getPrecipitationLevelAt(position.getX(), position.getZ()), position.getZ());
    }
}
