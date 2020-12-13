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

import java.util.Collection;
import java.util.Optional;

/**
 * The pack list keeps track of all the known {@link PackInfo}s and their
 * status.
 */
public interface PackList {

    /**
     * Gets the collection of all the known {@link PackInfo}s. The result is
     * immutable. To add more packs, register a {@link PackDiscoverer}.
     *
     * @return All the packs
     */
    Collection<PackInfo> all();

    /**
     * Gets the collection of {@link PackInfo}s which are not enabled.
     *
     * @return The disabled packs
     */
    Collection<PackInfo> disabled();

    /**
     * Gets the collection of {@link PackInfo}s which are enabled.
     *
     * @return The enabled packs
     */
    Collection<PackInfo> enabled();

    /**
     * Gets a {@link PackInfo} with the given name. If none exists,
     * {@link Optional#empty()} is returned.
     *
     * @param name The name of the pack
     * @return The pack info
     */
    Optional<PackInfo> get(String name);

}
