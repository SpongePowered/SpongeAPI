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
import org.spongepowered.api.world.volume.biome.BiomeVolume;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;
import java.util.function.Supplier;

public interface EnvironmentalVolume extends PrimitiveGameVolume, BiomeVolume {

    int light(LightType type, int x, int y, int z);

    default int light(final Supplier<? extends LightType> type, final int x, final int y, final int z) {
        Objects.requireNonNull(type);

        return this.light(type.get(), x, y, z);
    }

    default int light(final LightType type, final Vector3i position) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(position);

        return this.light(type, position.getX(), position.getY(), position.getZ());
    }

    default int light(final Supplier<? extends LightType> type, final Vector3i position) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(position);

        return this.light(type.get(), position.getX(), position.getY(), position.getZ());
    }

    default int light(final int x, final int y, final int z) {
        return this.light(LightTypes.BLOCK, x, y, z);
    }

    default int light(final Vector3i position) {
        Objects.requireNonNull(position);

        return this.light(position.getX(), position.getY(), position.getZ());
    }

    default boolean isSkylightMax(final Vector3i position) {
        Objects.requireNonNull(position);

        return this.light(LightTypes.SKY, position) >= this.maximumLight();
    }

}
