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
package org.spongepowered.api.item.recipe.smithing;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.ENGINE)
public final class TrimMaterials {

    public static final DefaultedRegistryReference<TrimMaterial> AMETHYST = TrimMaterials.key(ResourceKey.minecraft("amethyst"));

    public static final DefaultedRegistryReference<TrimMaterial> COPPER = TrimMaterials.key(ResourceKey.minecraft("copper"));

    public static final DefaultedRegistryReference<TrimMaterial> DIAMOND = TrimMaterials.key(ResourceKey.minecraft("diamond"));

    public static final DefaultedRegistryReference<TrimMaterial> EMERALD = TrimMaterials.key(ResourceKey.minecraft("emerald"));

    public static final DefaultedRegistryReference<TrimMaterial> GOLD = TrimMaterials.key(ResourceKey.minecraft("gold"));

    public static final DefaultedRegistryReference<TrimMaterial> IRON = TrimMaterials.key(ResourceKey.minecraft("iron"));

    public static final DefaultedRegistryReference<TrimMaterial> LAPIS = TrimMaterials.key(ResourceKey.minecraft("lapis"));

    public static final DefaultedRegistryReference<TrimMaterial> NETHERITE = TrimMaterials.key(ResourceKey.minecraft("netherite"));

    public static final DefaultedRegistryReference<TrimMaterial> QUARTZ = TrimMaterials.key(ResourceKey.minecraft("quartz"));

    public static final DefaultedRegistryReference<TrimMaterial> REDSTONE = TrimMaterials.key(ResourceKey.minecraft("redstone"));

    public static final DefaultedRegistryReference<TrimMaterial> RESIN = TrimMaterials.key(ResourceKey.minecraft("resin"));

    private TrimMaterials() {
    }

    public static Registry<TrimMaterial> registry() {
        return Sponge.server().registry(RegistryTypes.TRIM_MATERIAL);
    }

    private static DefaultedRegistryReference<TrimMaterial> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.TRIM_MATERIAL, location).asScopedReference();
    }
}
