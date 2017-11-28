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
package org.spongepowered.api.resource;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The resource manager is in charge of loading {@link Resource Resources} and
 * {@link Pack Data Packs}. On the client, there can also be resource packs.
 *
 * Packs are stacked on top of each other, so they will override and replace
 * resources in packs which are a lower priority.
 */
public interface ResourceManager extends ResourceProvider, PackProvider {

    /**
     * Returns a list of currently active packs. The returned list is mutable,
     * but changes will not be applied. To apply the changes, use
     * {@link #reload(List)}.
     *
     * @return The list of active packs.
     */
    List<Pack> getActivePacks();

    /**
     * Gets the resources at the given path from all active packs
     *
     * @param path The path of the resource.
     * @return A collection of resources
     */
    Collection<Resource> getResources(ResourcePath path);

    /**
     * Schedules a reload of resources from active packs.
     *
     * @return A future for the task
     */
    CompletableFuture<Void> reload();

    /**
     * Schedules a reload of resources, using the packs from {@code packs}
     *
     * @param packs The packs to reload with
     * @return A future for the task
     */
    CompletableFuture<Void> reload(List<Pack> packs);

    ResourceType getResourceType();
}
