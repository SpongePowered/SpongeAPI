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
package org.spongepowered.api.packs;

import org.spongepowered.api.Nameable;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.event.cause.Cause;

import java.util.Collection;
import java.util.Optional;

/**
 * A pack can contain several {@link Resource Resources}.
 */
public interface Pack extends Nameable {

    /**
     * Gets the metadata of this pack. The {@link DataView} represented is of
     * the pack.json file in the pack root. If the pack does not contain a
     * pack.json, {@link Optional#empty()} is returned.
     *
     * @return The metadata if it exists
     */
    Optional<DataView> getMetadata();

    /**
     * Gets all the resources loaded from this pack. If the pack is not
     * currently active, this list will be empty. Depending on the pack
     * implementation, the contents of the collection may not reflect what the
     * pack contains.
     *
     * <p>If the pack is lazy-initialized, it is possible for the collection to
     * be empty.</p>
     *
     * @return List of loaded resources
     */
    Collection<Resource> getLoadedResources();

    /**
     * Gets a resource from this pack if it exists. No other packs will be
     * queried.
     *
     * @param path The domain named path
     * @return The resource
     */
    Optional<Resource> getResource(String path);

    /**
     * Called when the resource manager reloads. This should be used to clean
     * up any stray resources so a fresh start can be made.
     *
     * @param cause The cause of the reload
     */
    void onReload(Cause cause);
}
