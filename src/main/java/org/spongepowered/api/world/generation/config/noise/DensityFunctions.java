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
package org.spongepowered.api.world.generation.config.noise;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * <!-- This file is automatically generated. Any manual changes will be overwritten. -->
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.ENGINE)
public final class DensityFunctions {

    public static final DefaultedRegistryReference<DensityFunction> END_BASE_3D_NOISE = DensityFunctions.key(ResourceKey.minecraft("end/base_3d_noise"));

    public static final DefaultedRegistryReference<DensityFunction> END_SLOPED_CHEESE = DensityFunctions.key(ResourceKey.minecraft("end/sloped_cheese"));

    public static final DefaultedRegistryReference<DensityFunction> NETHER_BASE_3D_NOISE = DensityFunctions.key(ResourceKey.minecraft("nether/base_3d_noise"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_AMPLIFIED_DEPTH = DensityFunctions.key(ResourceKey.minecraft("overworld_amplified/depth"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_AMPLIFIED_FACTOR = DensityFunctions.key(ResourceKey.minecraft("overworld_amplified/factor"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_AMPLIFIED_JAGGEDNESS = DensityFunctions.key(ResourceKey.minecraft("overworld_amplified/jaggedness"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_AMPLIFIED_OFFSET = DensityFunctions.key(ResourceKey.minecraft("overworld_amplified/offset"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_AMPLIFIED_SLOPED_CHEESE = DensityFunctions.key(ResourceKey.minecraft("overworld_amplified/sloped_cheese"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_BASE_3D_NOISE = DensityFunctions.key(ResourceKey.minecraft("overworld/base_3d_noise"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_CAVES_ENTRANCES = DensityFunctions.key(ResourceKey.minecraft("overworld/caves/entrances"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_CAVES_NOODLE = DensityFunctions.key(ResourceKey.minecraft("overworld/caves/noodle"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_CAVES_PILLARS = DensityFunctions.key(ResourceKey.minecraft("overworld/caves/pillars"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_CAVES_SPAGHETTI_2D = DensityFunctions.key(ResourceKey.minecraft("overworld/caves/spaghetti_2d"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_CAVES_SPAGHETTI_2D_THICKNESS_MODULATOR = DensityFunctions.key(ResourceKey.minecraft("overworld/caves/spaghetti_2d_thickness_modulator"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_CAVES_SPAGHETTI_ROUGHNESS_FUNCTION = DensityFunctions.key(ResourceKey.minecraft("overworld/caves/spaghetti_roughness_function"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_CONTINENTS = DensityFunctions.key(ResourceKey.minecraft("overworld/continents"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_DEPTH = DensityFunctions.key(ResourceKey.minecraft("overworld/depth"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_EROSION = DensityFunctions.key(ResourceKey.minecraft("overworld/erosion"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_FACTOR = DensityFunctions.key(ResourceKey.minecraft("overworld/factor"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_JAGGEDNESS = DensityFunctions.key(ResourceKey.minecraft("overworld/jaggedness"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_LARGE_BIOMES_CONTINENTS = DensityFunctions.key(ResourceKey.minecraft("overworld_large_biomes/continents"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_LARGE_BIOMES_DEPTH = DensityFunctions.key(ResourceKey.minecraft("overworld_large_biomes/depth"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_LARGE_BIOMES_EROSION = DensityFunctions.key(ResourceKey.minecraft("overworld_large_biomes/erosion"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_LARGE_BIOMES_FACTOR = DensityFunctions.key(ResourceKey.minecraft("overworld_large_biomes/factor"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_LARGE_BIOMES_JAGGEDNESS = DensityFunctions.key(ResourceKey.minecraft("overworld_large_biomes/jaggedness"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_LARGE_BIOMES_OFFSET = DensityFunctions.key(ResourceKey.minecraft("overworld_large_biomes/offset"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_LARGE_BIOMES_SLOPED_CHEESE = DensityFunctions.key(ResourceKey.minecraft("overworld_large_biomes/sloped_cheese"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_OFFSET = DensityFunctions.key(ResourceKey.minecraft("overworld/offset"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_RIDGES = DensityFunctions.key(ResourceKey.minecraft("overworld/ridges"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_RIDGES_FOLDED = DensityFunctions.key(ResourceKey.minecraft("overworld/ridges_folded"));

    public static final DefaultedRegistryReference<DensityFunction> OVERWORLD_SLOPED_CHEESE = DensityFunctions.key(ResourceKey.minecraft("overworld/sloped_cheese"));

    public static final DefaultedRegistryReference<DensityFunction> SHIFT_X = DensityFunctions.key(ResourceKey.minecraft("shift_x"));

    public static final DefaultedRegistryReference<DensityFunction> SHIFT_Z = DensityFunctions.key(ResourceKey.minecraft("shift_z"));

    public static final DefaultedRegistryReference<DensityFunction> Y = DensityFunctions.key(ResourceKey.minecraft("y"));

    public static final DefaultedRegistryReference<DensityFunction> ZERO = DensityFunctions.key(ResourceKey.minecraft("zero"));

    private DensityFunctions() {
    }

    public static Registry<DensityFunction> registry() {
        return Sponge.server().registry(RegistryTypes.DENSITY_FUNCTION);
    }

    private static DefaultedRegistryReference<DensityFunction> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.DENSITY_FUNCTION, location).asDefaultedReference(Sponge::server);
    }
}
