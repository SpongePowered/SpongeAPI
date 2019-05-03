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
import org.spongepowered.api.resource.pack.PackRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

/**
 * The resource manager is in charge of loading {@link Resource Resources}. It
 * does this using active {@link Pack Packs} from the {@link PackRepository}.
 */
public interface ResourceManager {

    /**
     * Get the known namespaces to the resource manager.
     *
     * @return The known namespaces
     */
    Set<String> getNamespaces();

    /**
     * Gets a loaded resource at the given path, or {@link Optional#empty()}
     * if it does not exist.
     *
     * <p>In the pack, the path will point to a resource. The resource should
     * be located roughly at {@code data/namespace/path}</p>
     *
     * @param path The path to the resource
     * @return The resource
     * @throws IOException If there was an error reading the resource
     * @throws FileNotFoundException If the resource does not exist.
     */
    Resource getResource(ResourcePath path) throws IOException, FileNotFoundException;

    /**
     * Returns all of the resources which exist in each {@link Pack}. Remember
     * to close all of the resources.
     *
     * @return All of the resources
     * @see #getResource(ResourcePath)
     * @throws IOException If there was an error reading any of the resources
     * @throws FileNotFoundException If no resources exist
     */
    List<Resource> getResources(ResourcePath path) throws IOException, FileNotFoundException;

    /**
     * Returns all {@link ResourcePath paths} within a directory from all the
     * resource domains.
     *
     * <p>This can be used for resources which can have multiple locations. For
     * example, {@code functions} and {@code loot_tables}.</p>
     *
     * <p>For example</p>
     * <pre>
     * manager.getResources("loot_tables", name -> name.endsWith(".json"));
     * </pre>
     *
     * @param path The path to search in
     * @param filter The file name filter
     * @return A collection of resource paths
     */
    Collection<ResourcePath> getPaths(String path, Predicate<String> filter);

    /**
     * Returns true if the given {@link ResourcePath} exists in the active
     * {@link Pack packs}.
     *
     * @param path The path to check
     * @return True if the path exists, false otherwise
     */
    boolean exists(ResourcePath path);

}
