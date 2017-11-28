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

import org.spongepowered.api.event.cause.Cause;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * The resource manager is in charge of loading {@link Resource Resources} and
 * {@link Pack Data Packs}. On the client, there can also be resource packs.
 *
 * Packs are stacked on top of each other, so they will override and replace
 * resources in packs which are a lower priority.
 */
public interface ResourceManager {

    /**
     * Returns a mutable list of active packs. Active packs are loaded and
     * determine which resources to use. The order of this list determines
     * priority, which decides which resource {@link #getResource} will return.
     *
     * <p>Add, remove, and rearrange items in this list to change the priority
     * of the packs. Changes will take effect after {@link #reload()}
     * is called.</p>
     *
     * <p><b>Note:</b> the default pack will always have the lowest priority.
     * Afterwards are packs provided by plugins. They will be applied whether
     * this list is empty or not.</p>
     *
     * @return The list of active packs
     */
    List<Pack> getActivePacks();

    /**
     * Returns a collection of available packs. An available pack is not
     * currently loaded and must be made active in order to load resources.
     *
     * @return A collection of available packs.
     */
    Collection<Pack> getAvailablePacks();

    /**
     * Gets a loaded resource at the given path, or {@link Optional#empty()}
     * if it does not exist.
     *
     * <p>A path should be prefixed with a domain name. If one is not provided,
     * {@code minecraft} will be used instead. For example, {@code minecraft:}</p>
     *
     * <p>In the pack, the path will point to a resource. The resource should
     * be located roughly at {@code /$assets/domain/$path}</p>
     *
     * TODO use CatalogKey (SpongeAPI#1655)
     *
     * @param path The path, including domain, to the resource
     * @return The resource
     */
    Optional<Resource> getResource(String path);

    /**
     * Reloads the resources from packs found in {@link #getActivePacks()}.
     *
     * @param cause The cause of the reload
     */
    void reload(Cause cause);
}
