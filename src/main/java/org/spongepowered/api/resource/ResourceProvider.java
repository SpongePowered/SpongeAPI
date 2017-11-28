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

import com.google.common.collect.Streams;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public interface ResourceProvider {

    /**
     * Gets a loaded resource at the given path, or {@link Optional#empty()}
     * if it does not exist.
     *
     * @param path The path to the resource
     * @return The resource
     */
    Optional<Resource> getResource(ResourcePath path);

    /**
     * Returns all of the resources which exist.
     *
     * @return All of the resources
     */
    Collection<Resource> getResources();

    /**
     * Walks though the loaded {@link ResourcePath paths}, which are children
     * of the given path. The paths are traversed depth-first. Children will
     * include both directories and files.
     *
     * @param path The start path
     * @return A stream of resource paths
     */
    Stream<ResourcePath> walk(ResourcePath path);

    /**
     * Walks though the loaded {@link ResourcePath paths}, which are children
     * of the given path. The paths are traversed depth-first. Children will
     * include both directories and files.
     *
     * <p>The {@code maxDepth} parameter is used to limit the number of
     * directories that will be traversed.</p>
     *
     * @param path The start path
     * @param maxDepth The max number of directories to traverse
     * @return A stream of resource paths
     */
    Stream<ResourcePath> walk(ResourcePath path, int maxDepth);

    /**
     * Walks though loaded {@link Resource resources}, which are children of
     * the given path. The paths are traversed depth-first.
     *
     * @param path The start path
     * @return A stream of resources
     */
    default Stream<Resource> walkResources(ResourcePath path) {
        return walk(path).map(this::getResource).flatMap(Streams::stream);
    }

    /**
     * Walks though loaded {@link Resource resources}, which are children of
     * the given path. The paths are traversed depth-first.
     *
     * <p>The {@code maxDepth} parameter is used to limit the number of
     * directories that will be traversed.</p>
     *
     * @param path The start path
     * @param maxDepth The max number of directories to traverse
     * @return A stream of resources
     */
    default Stream<Resource> walkResources(ResourcePath path, int maxDepth) {
        return walk(path, maxDepth).map(this::getResource).flatMap(Streams::stream);
    }

}
