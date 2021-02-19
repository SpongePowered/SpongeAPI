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
package org.spongepowered.api.world.volume.biome;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.schematic.Palette;
import org.spongepowered.api.world.volume.virtual.UnrealizedBiomeVolume;
import org.spongepowered.math.vector.Vector3i;

public interface BiomeVolumeFactory {

    BiomeVolume.Mutable empty(Palette<Biome, Biome> palette, RegistryReference<Biome> defaultBiome, Vector3i min, Vector3i max);

    BiomeVolume.Mutable copyFromRange(BiomeVolume.Streamable<@NonNull ?> existing, Vector3i newMin, Vector3i newMax);

    BiomeVolume.Mutable copy(BiomeVolume.Streamable<@NonNull ?> existing);

    BiomeVolume.Immutable immutableOf(BiomeVolume.Streamable<@NonNull ?> existing);

    BiomeVolume.Immutable immutableOf(BiomeVolume.Streamable<@NonNull ?> existing, Vector3i newMin, Vector3i newMax);

    UnrealizedBiomeVolume.Mutable empty(Vector3i min, Vector3i max);

}
