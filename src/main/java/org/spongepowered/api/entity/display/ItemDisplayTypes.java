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
package org.spongepowered.api.entity.display;

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
public final class ItemDisplayTypes {

    // @formatter:off
    // SORTFIELDS:OFF
    public static final DefaultedRegistryReference<ItemDisplayType> FIRSTPERSON_LEFTHAND = ItemDisplayTypes.key(ResourceKey.sponge("firstperson_lefthand"));

    public static final DefaultedRegistryReference<ItemDisplayType> FIRSTPERSON_RIGHTHAND = ItemDisplayTypes.key(ResourceKey.sponge("firstperson_righthand"));

    public static final DefaultedRegistryReference<ItemDisplayType> FIXED = ItemDisplayTypes.key(ResourceKey.sponge("fixed"));

    public static final DefaultedRegistryReference<ItemDisplayType> GROUND = ItemDisplayTypes.key(ResourceKey.sponge("ground"));

    public static final DefaultedRegistryReference<ItemDisplayType> GUI = ItemDisplayTypes.key(ResourceKey.sponge("gui"));

    public static final DefaultedRegistryReference<ItemDisplayType> HEAD = ItemDisplayTypes.key(ResourceKey.sponge("head"));

    public static final DefaultedRegistryReference<ItemDisplayType> NONE = ItemDisplayTypes.key(ResourceKey.sponge("none"));

    public static final DefaultedRegistryReference<ItemDisplayType> THIRDPERSON_LEFTHAND = ItemDisplayTypes.key(ResourceKey.sponge("thirdperson_lefthand"));

    public static final DefaultedRegistryReference<ItemDisplayType> THIRDPERSON_RIGHTHAND = ItemDisplayTypes.key(ResourceKey.sponge("thirdperson_righthand"));

    // SORTFIELDS:OFF
    // @formatter:on
    private ItemDisplayTypes() {
    }

    public static Registry<ItemDisplayType> registry() {
        return Sponge.game().registry(RegistryTypes.ITEM_DISPLAY_TYPE);
    }

    private static DefaultedRegistryReference<ItemDisplayType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.ITEM_DISPLAY_TYPE, location).asDefaultedReference(Sponge::game);
    }
}
