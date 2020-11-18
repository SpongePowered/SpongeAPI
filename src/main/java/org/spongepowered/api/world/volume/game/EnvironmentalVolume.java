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

import org.spongepowered.api.world.LightType;
import org.spongepowered.api.world.LightTypes;
import org.spongepowered.api.world.volume.biome.ReadableBiomeVolume;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;
import java.util.function.Supplier;

public interface EnvironmentalVolume extends PrimitiveGameVolume, ReadableBiomeVolume {

    int getLight(LightType type, int x, int y, int z);

    default int getLight(final Supplier<? extends LightType> type, final int x, final int y, final int z) {
        Objects.requireNonNull(type);

        return this.getLight(type.get(), x, y, z);
    }

    default int getLight(final LightType type, final Vector3i position) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(position);

        return this.getLight(type, position.getX(), position.getY(), position.getZ());
    }

    default int getLight(final Supplier<? extends LightType> type, final Vector3i position) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(position);

        return this.getLight(type, position.getX(), position.getY(), position.getZ());
    }

    default int getLight(final int x, final int y, final int z) {
        return this.getLight(LightTypes.BLOCK, x, y, z);
    }

    default int getLight(final Vector3i position) {
        Objects.requireNonNull(position);

        return this.getLight(position.getX(), position.getY(), position.getZ());
    }

    default boolean isSkylightMax(final Vector3i position) {
        Objects.requireNonNull(position);

        return this.getLight(LightTypes.SKY, position) >= this.getMaximumLight();
    }

}
