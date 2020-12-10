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
package org.spongepowered.api.registry;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.data.type.MatterType;

/**
 * All {@link RegistryKey registries} provided by this API.
 */
public final class Registries {

    // @formatter:off

    public static final RegistryKey<MatterType> MATTER_TYPE = Registries.spongeKey("matter_type");

    // @formatter:on

    private static final ResourceKey MINECRAFT_ROOT = ResourceKey.minecraft("root");
    private static final ResourceKey SPONGE_ROOT = ResourceKey.sponge("root");

    private static <V> RegistryKey<V> minecraftKey(final String key) {
        return RegistryKey.of(Registries.MINECRAFT_ROOT, ResourceKey.minecraft(key));
    }

    private static <V> RegistryKey<V> spongeKey(final String key) {
        return RegistryKey.of(Registries.SPONGE_ROOT, ResourceKey.sponge(key));
    }
}