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
import org.spongepowered.api.registry.RegistryTypes;

public final class DripstoneSegments {

    public static final DefaultedRegistryReference<DripstoneSegment> TIP_MERGE = DripstoneSegments.key(ResourceKey.sponge("tip_merge"));

    public static final DefaultedRegistryReference<DripstoneSegment> TIP = DripstoneSegments.key(ResourceKey.sponge("tip"));

    public static final DefaultedRegistryReference<DripstoneSegment> FRUSTUM = DripstoneSegments.key(ResourceKey.sponge("frustum"));

    public static final DefaultedRegistryReference<DripstoneSegment> MIDDLE = DripstoneSegments.key(ResourceKey.sponge("middle"));

    public static final DefaultedRegistryReference<DripstoneSegment> BASE = DripstoneSegments.key(ResourceKey.sponge("base"));

    private DripstoneSegments() {
    }

    private static DefaultedRegistryReference<DripstoneSegment> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.DRIPSTONE_SEGMENT, location).asDefaultedReference(() -> Sponge.game().registries());
    }

}
