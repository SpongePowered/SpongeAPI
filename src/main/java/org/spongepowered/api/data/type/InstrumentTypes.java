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
 * An enumeration of vanilla {@link InstrumentType}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class InstrumentTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<InstrumentType> BANJO = InstrumentTypes.key(ResourceKey.sponge("banjo"));

    public static final DefaultedRegistryReference<InstrumentType> BASS = InstrumentTypes.key(ResourceKey.sponge("bass"));

    public static final DefaultedRegistryReference<InstrumentType> BASE_DRUM = InstrumentTypes.key(ResourceKey.sponge("basedrum"));

    public static final DefaultedRegistryReference<InstrumentType> BELL = InstrumentTypes.key(ResourceKey.sponge("bell"));

    public static final DefaultedRegistryReference<InstrumentType> BIT = InstrumentTypes.key(ResourceKey.sponge("bit"));

    public static final DefaultedRegistryReference<InstrumentType> CHIME = InstrumentTypes.key(ResourceKey.sponge("chime"));

    public static final DefaultedRegistryReference<InstrumentType> COW_BELL = InstrumentTypes.key(ResourceKey.sponge("cow_bell"));

    public static final DefaultedRegistryReference<InstrumentType> DIDGERIDOO = InstrumentTypes.key(ResourceKey.sponge("didgeridoo"));

    public static final DefaultedRegistryReference<InstrumentType> FLUTE = InstrumentTypes.key(ResourceKey.sponge("flute"));

    public static final DefaultedRegistryReference<InstrumentType> GUITAR = InstrumentTypes.key(ResourceKey.sponge("guitar"));

    public static final DefaultedRegistryReference<InstrumentType> HARP = InstrumentTypes.key(ResourceKey.sponge("harp"));

    public static final DefaultedRegistryReference<InstrumentType> HAT = InstrumentTypes.key(ResourceKey.sponge("hat"));

    public static final DefaultedRegistryReference<InstrumentType> IRON_XYLOPHONE = InstrumentTypes.key(ResourceKey.sponge("iron_xylophone"));

    public static final DefaultedRegistryReference<InstrumentType> PLING = InstrumentTypes.key(ResourceKey.sponge("pling"));

    public static final DefaultedRegistryReference<InstrumentType> SNARE = InstrumentTypes.key(ResourceKey.sponge("snare"));

    public static final DefaultedRegistryReference<InstrumentType> XYLOPHONE = InstrumentTypes.key(ResourceKey.sponge("xylophone"));

    // SORTFIELDS:OFF

    // @formatter:on

    private InstrumentTypes() {
    }

    private static DefaultedRegistryReference<InstrumentType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.INSTRUMENT_TYPE, location).asDefaultedReference(Sponge::game);
    }
}
