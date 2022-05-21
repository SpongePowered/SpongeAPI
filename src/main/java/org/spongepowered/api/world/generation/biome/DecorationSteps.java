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
package org.spongepowered.api.world.generation.biome;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class DecorationSteps {

    // @formatter:off

    public static final DefaultedRegistryReference<DecorationStep> RAW_GENERATION = DecorationSteps.key(ResourceKey.sponge("raw_generation"));

    public static final DefaultedRegistryReference<DecorationStep> LAKES = DecorationSteps.key(ResourceKey.sponge("lakes"));

    public static final DefaultedRegistryReference<DecorationStep> LOCAL_MODIFICATIONS = DecorationSteps.key(ResourceKey.sponge("local_modifications"));

    public static final DefaultedRegistryReference<DecorationStep> UNDERGROUND_STRUCTURES = DecorationSteps.key(ResourceKey.sponge("underground_structures"));

    public static final DefaultedRegistryReference<DecorationStep> SURFACE_STRUCTURES = DecorationSteps.key(ResourceKey.sponge("surface_structures"));

    public static final DefaultedRegistryReference<DecorationStep> STRONGHOLDS = DecorationSteps.key(ResourceKey.sponge("strongholds"));

    public static final DefaultedRegistryReference<DecorationStep> UNDERGROUND_ORES = DecorationSteps.key(ResourceKey.sponge("underground_ores"));

    public static final DefaultedRegistryReference<DecorationStep> UNDERGROUND_DECORATION = DecorationSteps.key(ResourceKey.sponge("underground_decoration"));

    public static final DefaultedRegistryReference<DecorationStep> FLUID_SPRINGS = DecorationSteps.key(ResourceKey.sponge("fluid_springs"));

    public static final DefaultedRegistryReference<DecorationStep> VEGETAL_DECORATION = DecorationSteps.key(ResourceKey.sponge("vegetal_decoration"));

    public static final DefaultedRegistryReference<DecorationStep> TOP_LAYER_MODIFICATION = DecorationSteps.key(ResourceKey.sponge("top_layer_modification"));

    // @formatter:on

    private DecorationSteps() {
    }

    public static Registry<DecorationStep> registry() {
        return Sponge.game().registry(RegistryTypes.DECORATION_STEP);
    }

    private static DefaultedRegistryReference<DecorationStep> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.DECORATION_STEP, location).asDefaultedReference(Sponge::game);
    }
}
