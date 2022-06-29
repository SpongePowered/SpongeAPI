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
package org.spongepowered.api.entity;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryTypes;

public final class EntityCategories {

    //@formatter:off

    public static final DefaultedRegistryReference<EntityCategory> MONSTER = EntityCategories.key(ResourceKey.sponge("monster"));

    public static final DefaultedRegistryReference<EntityCategory> CREATURE = EntityCategories.key(ResourceKey.sponge("creature"));

    public static final DefaultedRegistryReference<EntityCategory> AMBIENT = EntityCategories.key(ResourceKey.sponge("ambient"));

    public static final DefaultedRegistryReference<EntityCategory> WATER_CREATURE = EntityCategories.key(ResourceKey.sponge("water_creature"));

    // TODO UNDERGROUND_WATER_CREATURE

    public static final DefaultedRegistryReference<EntityCategory> WATER_AMBIENT = EntityCategories.key(ResourceKey.sponge("water_ambient"));

    public static final DefaultedRegistryReference<EntityCategory> MISCELLANEOUS = EntityCategories.key(ResourceKey.sponge("misc"));

    // TODO AXOLOTLS

    //@formatter:on

    private EntityCategories() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

    private static DefaultedRegistryReference<EntityCategory> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.ENTITY_CATEGORY, location).asDefaultedReference(Sponge::game);
    }
}
