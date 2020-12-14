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
 * An enumeration of vanilla {@link StructureMode}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class StructureModes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Corner mode allows for an easier and automatic size calculation while
     * saving or loading structures.
     */
    public static final DefaultedRegistryReference<StructureMode> CORNER = StructureModes.key(ResourceKey.sponge("corner"));

    /**
     * Data mode can only be used during natural generation.
     *
     * <p>They mark the location to run a function specified by its metadata
     * input, which can only be used for relevant structures.</p>
     *
     * <p>The structure block is removed afterwards.</p>
     *
     * <p>This mode is the default mode when a structure block is first
     * placed.</p>
     */
    public static final DefaultedRegistryReference<StructureMode> DATA = StructureModes.key(ResourceKey.sponge("data"));

    /**
     * Load mode allows a player to load and rotate saved structure files.
     */
    public static final DefaultedRegistryReference<StructureMode> LOAD = StructureModes.key(ResourceKey.sponge("load"));

    /**
     * Save mode allows a player to highlight a structure in the world and
     * save it to a file.
     */
    public static final DefaultedRegistryReference<StructureMode> SAVE = StructureModes.key(ResourceKey.sponge("save"));

    // SORTFIELDS:OFF

    // @formatter:on

    private StructureModes() {
    }

    private static DefaultedRegistryReference<StructureMode> key(final ResourceKey location) {
        return RegistryKey.of(Registries.STRUCTURE_MODE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
