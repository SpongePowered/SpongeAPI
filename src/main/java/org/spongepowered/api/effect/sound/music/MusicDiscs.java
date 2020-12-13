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
package org.spongepowered.api.effect.sound.music;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class MusicDiscs {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<MusicDisc> BLOCKS = MusicDiscs.key(ResourceKey.sponge("blocks"));

    public static final DefaultedRegistryReference<MusicDisc> CAT = MusicDiscs.key(ResourceKey.sponge("cat"));

    public static final DefaultedRegistryReference<MusicDisc> CHIRP = MusicDiscs.key(ResourceKey.sponge("chirp"));

    public static final DefaultedRegistryReference<MusicDisc> FAR = MusicDiscs.key(ResourceKey.sponge("far"));

    public static final DefaultedRegistryReference<MusicDisc> MALL = MusicDiscs.key(ResourceKey.sponge("mall"));

    public static final DefaultedRegistryReference<MusicDisc> MELLOHI = MusicDiscs.key(ResourceKey.sponge("mellohi"));

    public static final DefaultedRegistryReference<MusicDisc> MUSIC_DISC_11 = MusicDiscs.key(ResourceKey.sponge("11"));

    public static final DefaultedRegistryReference<MusicDisc> MUSIC_DISC_13 = MusicDiscs.key(ResourceKey.sponge("13"));

    public static final DefaultedRegistryReference<MusicDisc> PIGSTEP = MusicDiscs.key(ResourceKey.sponge("pigstep"));

    public static final DefaultedRegistryReference<MusicDisc> STAL = MusicDiscs.key(ResourceKey.sponge("stal"));

    public static final DefaultedRegistryReference<MusicDisc> STRAD = MusicDiscs.key(ResourceKey.sponge("strad"));

    public static final DefaultedRegistryReference<MusicDisc> WAIT = MusicDiscs.key(ResourceKey.sponge("wait"));

    public static final DefaultedRegistryReference<MusicDisc> WARD = MusicDiscs.key(ResourceKey.sponge("ward"));

    // SORTFIELDS:OFF

    // @formatter:on

    private MusicDiscs() {
    }

    private static DefaultedRegistryReference<MusicDisc> key(final ResourceKey location) {
        return RegistryKey.<MusicDisc>of(Registries.MUSIC_DISC.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
