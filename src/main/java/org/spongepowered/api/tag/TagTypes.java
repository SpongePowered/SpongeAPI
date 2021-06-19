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
package org.spongepowered.api.tag;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * Represents a type that a {@link Tag} can represent.
 */
@RegistryScopes(scopes = RegistryScope.GAME)
public final class TagTypes {

    // @formatter:off

    public static final DefaultedRegistryReference<TagType<BlockType>> BLOCK_TYPE = TagTypes.key(ResourceKey.sponge("block_type"));

    public static final DefaultedRegistryReference<TagType<EntityType<?>>> ENTITY_TYPE = TagTypes.key(ResourceKey.sponge("entity_type"));

    public static final DefaultedRegistryReference<TagType<FluidType>> FLUID_TYPE = TagTypes.key(ResourceKey.sponge("fluid_type"));

    public static final DefaultedRegistryReference<TagType<ItemType>> ITEM_TYPE = TagTypes.key(ResourceKey.sponge("item_type"));

    // @formatter:on
    private TagTypes() {
    }

    private static <T extends Taggable<T>> DefaultedRegistryReference<TagType<T>> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.TAG_TYPES, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
