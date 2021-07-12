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
package org.spongepowered.api.world.schematic;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.entity.BlockEntityType;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.world.biome.Biome;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class PaletteTypes {

    // @formatter:off

    // SORTFIELDS:ON
    /**
     * A type of {@link PaletteType} that refers to a localized mapping of
     * {@link Biome biomes} for individualized usage. Traditionally the
     * palette will generate {@code integer ids} in the order in which a
     * {@link Biome biome} is registered via {@link Palette.Mutable#orAssign (Object)}
     */
    public static final DefaultedRegistryReference<PaletteType<Biome, Biome>> BIOME_PALETTE = PaletteTypes.key(ResourceKey.sponge("biome_palette"));

    /**
     * A type of {@link PaletteType} that refers to a localized mapping of
     * {@link BlockState block states} for individualized usage. Traditionally the
     * palette will generate {@code integer ids} in the order in which a
     * {@link BlockState biome} is registered via {@link Palette.Mutable#orAssign (Object)}
     */
    public static final DefaultedRegistryReference<PaletteType<BlockState, BlockType>> BLOCK_STATE_PALETTE = PaletteTypes.key(ResourceKey.sponge("block_state_palette"));

    public static final DefaultedRegistryReference<PaletteType<BlockEntityType, BlockEntityType>> BLOCK_ENTITY_PALETTE = PaletteTypes.key(ResourceKey.sponge("block_entity_type_palette"));

    // SORTFIELDS:OFF

    // @formatter:on

    private PaletteTypes() {
    }

    private static <T, R> DefaultedRegistryReference<PaletteType<T, R>> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.PALETTE_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
