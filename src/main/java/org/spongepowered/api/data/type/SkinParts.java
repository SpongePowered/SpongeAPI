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
package org.spongepowered.api.data.type;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of vanilla {@link SkinPart}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class SkinParts {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<SkinPart> CAPE = SkinParts.key(ResourceKey.sponge("cape"));

    public static final DefaultedRegistryReference<SkinPart> HAT = SkinParts.key(ResourceKey.sponge("hat"));

    public static final DefaultedRegistryReference<SkinPart> JACKET = SkinParts.key(ResourceKey.sponge("jacket"));

    public static final DefaultedRegistryReference<SkinPart> LEFT_PANTS_LEG = SkinParts.key(ResourceKey.sponge("left_pants_leg"));

    public static final DefaultedRegistryReference<SkinPart> LEFT_SLEEVE = SkinParts.key(ResourceKey.sponge("left_sleeve"));

    public static final DefaultedRegistryReference<SkinPart> RIGHT_PANTS_LEG = SkinParts.key(ResourceKey.sponge("right_pants_leg"));

    public static final DefaultedRegistryReference<SkinPart> RIGHT_SLEEVE = SkinParts.key(ResourceKey.sponge("right_sleeve"));

    // SORTFIELDS:OFF

    // @formatter:on

    private SkinParts() {
    }

    private static DefaultedRegistryReference<SkinPart> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.SKIN_PART, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
