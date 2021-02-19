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
package org.spongepowered.api.world.volume.virtual;

import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.volume.biome.BiomeVolume;

public interface UnrealizedBiomeVolume<B extends BiomeVolume> extends Virtualized<Biome, B> {

    interface Streamable<B extends Streamable<B, BU>, BU extends BiomeVolume.Streamable<BU>>
        extends UnrealizedBiomeVolume<BU>,
        Virtualized.Streamable<Biome, B, BU>
    {

    }

    interface Unmodifiable<U extends Unmodifiable<U, BU>, BU extends BiomeVolume.Unmodifiable<BU>>
        extends UnrealizedBiomeVolume<BU>,
        Streamable<U, BU>,
        Virtualized.Unmodifiable<Biome, U, BU> {

    }

    interface Modifiable<B extends Modifiable<B, MB>, MB extends BiomeVolume.Modifiable<MB>>
    extends UnrealizedBiomeVolume<MB>,
        Streamable<B, MB>,
        Virtualized.Mutable<Biome, B, MB> {

    }

    interface Mutable extends Modifiable<Mutable, BiomeVolume.Mutable> {

    }

    interface Immutable extends Unmodifiable<Immutable, BiomeVolume.Immutable> {

    }


}
