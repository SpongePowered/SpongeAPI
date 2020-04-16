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

import org.spongepowered.api.resource.pack.Pack;
import org.spongepowered.api.util.CloseableList;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * The resource manager is in charge of loading {@link Resource Resources} and
 * {@link Pack Data Packs}. On the client, there can also be resource packs.
 * <p>
 * Packs are stacked on top of each other, so they will override and replace
 * resources in packs which are a lower priority.
 */
public interface ResourceManager {

    /**
     * Gets a loaded {@link Resource resource} at the given path, or throws an
     * exception if it doesn't exist.
     *
     * <p>Resource implements {@link Closeable}, so remember to close it. Example:</p>
     *
     * <pre>
     *     try (Resource res = resourceManager.load(path)) {
     *         InputStream in = res.getInputStream();
     *     }
     * </pre>
     *
     * @param path The path to the resource
     * @return The resource
     * @throws IOException                   If the resource could not be read
     * @throws java.io.FileNotFoundException If the file does not exist
     */
    Resource load(ResourcePath path) throws IOException;

    /**
     * Gets all loaded {@link Resource resources} at the given path from all
     * loaded {@link Pack packs}.
     *
     * <p>
     * All the resources in the list need to be closed. To assist in this, you
     * can wrap the entire list inside a try-with-resources block. Example:</p>
     *
     * <pre>
     *     try (CloseableList&lt;Resource&gt; resources = resourceManager.loadAll(path)) {
     *         for (Resource res : resources) {
     *             InputStream in = res.getInputStream();
     *         }
     *     }
     * </pre>
     *
     * @param path The path to the resource
     * @return The list of all resources at the path
     * @throws IOException                   If a resource could not be read
     * @throws java.io.FileNotFoundException If there are no resources at the path
     */
    CloseableList<Resource> loadAll(ResourcePath path) throws IOException;

    /**
     * Finds all the {@link ResourcePath resource paths} from all namespaces
     * with the given path prefix and matches the filter {@link Predicate}.
     *
     * @param pathPrefix The prefix of the paths
     * @param pathFilter The filter all paths must pass
     * @return The list of matching paths
     */
    Collection<ResourcePath> find(String pathPrefix, Predicate<String> pathFilter);

}
