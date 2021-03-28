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
package org.spongepowered.api.world.difficulty;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * A list of difficulties that Minecraft provides in vanilla.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class Difficulties {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<Difficulty> EASY = Difficulties.key(ResourceKey.sponge("easy"));

    public static final DefaultedRegistryReference<Difficulty> HARD = Difficulties.key(ResourceKey.sponge("hard"));

    public static final DefaultedRegistryReference<Difficulty> NORMAL = Difficulties.key(ResourceKey.sponge("normal"));

    public static final DefaultedRegistryReference<Difficulty> PEACEFUL = Difficulties.key(ResourceKey.sponge("peaceful"));

    // SORTFIELDS:OFF

    // @formatter:on

    private Difficulties() {
    }

    private static DefaultedRegistryReference<Difficulty> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.DIFFICULTY, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
