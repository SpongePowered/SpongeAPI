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
package org.spongepowered.api.resource.pack;

import org.spongepowered.api.Engine;
import org.spongepowered.plugin.PluginContainer;

import java.util.Collection;
import java.util.Optional;

/**
 * Holds all the {@link Pack packs} that are known to an {@link Engine}.
 */
public interface PackRepository {

    /**
     * @return The {@link Pack packs} as an unmodifiable {@link Collection}.
     */
    Collection<Pack> all();

    /**
     * @return The disabled {@link Pack packs} as an unmodifiable {@link Collection}.
     */
    Collection<Pack> disabled();

    /**
     * @return The enabled {@link Pack packs} as an unmodifiable {@link Collection}.
     */
    Collection<Pack> enabled();

    /**
     * @param id The id of the pack
     * @return The {@link Pack} or {@link Optional#empty()} if not found
     */
    Optional<Pack> pack(String id);

    /**
     * @param container The {@link PluginContainer container}
     * @return The {@link PluginContainer plugin's} {@link Pack}
     */
    Pack pack(PluginContainer container);
}
