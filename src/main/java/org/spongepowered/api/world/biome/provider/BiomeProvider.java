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
package org.spongepowered.api.world.biome.provider;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.world.biome.Biome;
import org.spongepowered.api.world.biome.BiomeFinder;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public interface BiomeProvider extends BiomeFinder {

    static <T extends LayeredBiomeConfig> ConfigurableBiomeProvider<T> layered(final T config) {
        return Sponge.game().factoryProvider().provide(Factory.class).layered(config);
    }

    static ConfigurableBiomeProvider<LayeredBiomeConfig> overworld() {
        return Sponge.game().factoryProvider().provide(Factory.class).overworld();
    }

    static <T extends MultiNoiseBiomeConfig> ConfigurableBiomeProvider<T> multiNoise(final T config) {
        return Sponge.game().factoryProvider().provide(Factory.class).multiNoise(config);
    }

    static ConfigurableBiomeProvider<MultiNoiseBiomeConfig> nether() {
        return Sponge.game().factoryProvider().provide(Factory.class).nether();
    }

    static <T extends EndStyleBiomeConfig> ConfigurableBiomeProvider<T> endStyle(final T config) {
        return Sponge.game().factoryProvider().provide(Factory.class).endStyle(config);
    }

    static ConfigurableBiomeProvider<EndStyleBiomeConfig> end() {
        return Sponge.game().factoryProvider().provide(Factory.class).end();
    }

    static <T extends CheckerboardBiomeConfig> ConfigurableBiomeProvider<T> checkerboard(final T config) {
        return Sponge.game().factoryProvider().provide(Factory.class).checkerboard(config);
    }

    static BiomeProvider fixed(final RegistryReference<Biome> biome) {
        return Sponge.game().factoryProvider().provide(Factory.class).fixed(Objects.requireNonNull(biome, "biome"));
    }

    List<Biome> choices();

    Set<Biome> within(int x, int y, int z, int size);

    interface Factory {

        <T extends LayeredBiomeConfig> ConfigurableBiomeProvider<T> layered(T config);

        ConfigurableBiomeProvider<LayeredBiomeConfig> overworld();

        <T extends MultiNoiseBiomeConfig> ConfigurableBiomeProvider<T> multiNoise(T config);

        ConfigurableBiomeProvider<MultiNoiseBiomeConfig> nether();

        <T extends EndStyleBiomeConfig> ConfigurableBiomeProvider<T> endStyle(T config);

        ConfigurableBiomeProvider<EndStyleBiomeConfig> end();

        <T extends CheckerboardBiomeConfig> ConfigurableBiomeProvider<T> checkerboard(T config);

        BiomeProvider fixed(RegistryReference<Biome> biome);
    }
}
