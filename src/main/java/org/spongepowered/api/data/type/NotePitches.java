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
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * An enumeration of vanilla {@link NotePitch}es.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class NotePitches {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<NotePitch> A1 = NotePitches.key(ResourceKey.sponge("a1"));

    public static final DefaultedRegistryReference<NotePitch> A2 = NotePitches.key(ResourceKey.sponge("a2"));

    public static final DefaultedRegistryReference<NotePitch> A_SHARP1 = NotePitches.key(ResourceKey.sponge("a_sharp1"));

    public static final DefaultedRegistryReference<NotePitch> A_SHARP2 = NotePitches.key(ResourceKey.sponge("a_sharp2"));

    public static final DefaultedRegistryReference<NotePitch> B1 = NotePitches.key(ResourceKey.sponge("b1"));

    public static final DefaultedRegistryReference<NotePitch> B2 = NotePitches.key(ResourceKey.sponge("b2"));

    public static final DefaultedRegistryReference<NotePitch> C1 = NotePitches.key(ResourceKey.sponge("c1"));

    public static final DefaultedRegistryReference<NotePitch> C2 = NotePitches.key(ResourceKey.sponge("c2"));

    public static final DefaultedRegistryReference<NotePitch> C_SHARP1 = NotePitches.key(ResourceKey.sponge("c_sharp1"));

    public static final DefaultedRegistryReference<NotePitch> C_SHARP2 = NotePitches.key(ResourceKey.sponge("c_sharp2"));

    public static final DefaultedRegistryReference<NotePitch> D1 = NotePitches.key(ResourceKey.sponge("d1"));

    public static final DefaultedRegistryReference<NotePitch> D2 = NotePitches.key(ResourceKey.sponge("d2"));

    public static final DefaultedRegistryReference<NotePitch> D_SHARP1 = NotePitches.key(ResourceKey.sponge("d_sharp1"));

    public static final DefaultedRegistryReference<NotePitch> D_SHARP2 = NotePitches.key(ResourceKey.sponge("d_sharp2"));

    public static final DefaultedRegistryReference<NotePitch> E1 = NotePitches.key(ResourceKey.sponge("e1"));

    public static final DefaultedRegistryReference<NotePitch> E2 = NotePitches.key(ResourceKey.sponge("e2"));

    public static final DefaultedRegistryReference<NotePitch> F1 = NotePitches.key(ResourceKey.sponge("f1"));

    public static final DefaultedRegistryReference<NotePitch> F2 = NotePitches.key(ResourceKey.sponge("f2"));

    public static final DefaultedRegistryReference<NotePitch> F_SHARP0 = NotePitches.key(ResourceKey.sponge("f_sharp0"));

    public static final DefaultedRegistryReference<NotePitch> F_SHARP1 = NotePitches.key(ResourceKey.sponge("f_sharp1"));

    public static final DefaultedRegistryReference<NotePitch> F_SHARP2 = NotePitches.key(ResourceKey.sponge("f_sharp2"));

    public static final DefaultedRegistryReference<NotePitch> G0 = NotePitches.key(ResourceKey.sponge("g0"));

    public static final DefaultedRegistryReference<NotePitch> G1 = NotePitches.key(ResourceKey.sponge("g1"));

    public static final DefaultedRegistryReference<NotePitch> G_SHARP0 = NotePitches.key(ResourceKey.sponge("g_sharp0"));

    public static final DefaultedRegistryReference<NotePitch> G_SHARP1 = NotePitches.key(ResourceKey.sponge("g_sharp1"));

    // SORTFIELDS:OFF

    // @formatter:on

    private NotePitches() {
    }

    private static DefaultedRegistryReference<NotePitch> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.NOTE_PITCH, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
