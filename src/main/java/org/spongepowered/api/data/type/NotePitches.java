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
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of vanilla {@link NotePitch}es.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class NotePitches {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<NotePitch> A1 = NotePitches.key(ResourceKey.sponge("A1"));

    public static final DefaultedRegistryReference<NotePitch> A2 = NotePitches.key(ResourceKey.sponge("A2"));

    public static final DefaultedRegistryReference<NotePitch> A_SHARP1 = NotePitches.key(ResourceKey.sponge("A_SHARP1"));

    public static final DefaultedRegistryReference<NotePitch> A_SHARP2 = NotePitches.key(ResourceKey.sponge("A_SHARP2"));

    public static final DefaultedRegistryReference<NotePitch> B1 = NotePitches.key(ResourceKey.sponge("B1"));

    public static final DefaultedRegistryReference<NotePitch> B2 = NotePitches.key(ResourceKey.sponge("B2"));

    public static final DefaultedRegistryReference<NotePitch> C1 = NotePitches.key(ResourceKey.sponge("C1"));

    public static final DefaultedRegistryReference<NotePitch> C2 = NotePitches.key(ResourceKey.sponge("C2"));

    public static final DefaultedRegistryReference<NotePitch> C_SHARP1 = NotePitches.key(ResourceKey.sponge("C_SHARP1"));

    public static final DefaultedRegistryReference<NotePitch> C_SHARP2 = NotePitches.key(ResourceKey.sponge("C_SHARP2"));

    public static final DefaultedRegistryReference<NotePitch> D1 = NotePitches.key(ResourceKey.sponge("D1"));

    public static final DefaultedRegistryReference<NotePitch> D2 = NotePitches.key(ResourceKey.sponge("D2"));

    public static final DefaultedRegistryReference<NotePitch> D_SHARP1 = NotePitches.key(ResourceKey.sponge("D_SHARP1"));

    public static final DefaultedRegistryReference<NotePitch> D_SHARP2 = NotePitches.key(ResourceKey.sponge("D_SHARP2"));

    public static final DefaultedRegistryReference<NotePitch> E1 = NotePitches.key(ResourceKey.sponge("E1"));

    public static final DefaultedRegistryReference<NotePitch> E2 = NotePitches.key(ResourceKey.sponge("E2"));

    public static final DefaultedRegistryReference<NotePitch> F1 = NotePitches.key(ResourceKey.sponge("F1"));

    public static final DefaultedRegistryReference<NotePitch> F2 = NotePitches.key(ResourceKey.sponge("F2"));

    public static final DefaultedRegistryReference<NotePitch> F_SHARP0 = NotePitches.key(ResourceKey.sponge("F_SHARP0"));

    public static final DefaultedRegistryReference<NotePitch> F_SHARP1 = NotePitches.key(ResourceKey.sponge("F_SHARP1"));

    public static final DefaultedRegistryReference<NotePitch> F_SHARP2 = NotePitches.key(ResourceKey.sponge("F_SHARP2"));

    public static final DefaultedRegistryReference<NotePitch> G0 = NotePitches.key(ResourceKey.sponge("G0"));

    public static final DefaultedRegistryReference<NotePitch> G1 = NotePitches.key(ResourceKey.sponge("G1"));

    public static final DefaultedRegistryReference<NotePitch> G_SHARP0 = NotePitches.key(ResourceKey.sponge("G_SHARP0"));

    public static final DefaultedRegistryReference<NotePitch> G_SHARP1 = NotePitches.key(ResourceKey.sponge("G_SHARP1"));

    // SORTFIELDS:OFF

    // @formatter:on

    private NotePitches() {
    }

    private static DefaultedRegistryReference<NotePitch> key(final ResourceKey location) {
        return RegistryKey.of(Registries.NOTE_PITCH, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
