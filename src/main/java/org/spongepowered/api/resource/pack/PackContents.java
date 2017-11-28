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

import org.spongepowered.api.resource.Resource;
import org.spongepowered.api.resource.ResourcePath;
import org.spongepowered.api.util.Nameable;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Represents the container that stores {@link Resource resources} for retrieval.
 */
public interface PackContents extends Nameable, AutoCloseable {

    /**
     * Gets a {@link Resource resource} within a {@link ResourcePath path} per
     * {@link PackType type}.
     *
     * <p><strong>If a resource is returned, be aware that is requires closing
     * when you have finished working with the resource.</strong></p>
     *
     * @param type The type
     * @param path The domain named path
     * @return The resource
     */
    Optional<Resource> resource(PackType type, ResourcePath path) throws IOException;

    /**
     * Gets a {@link Resource resource} within a {@link ResourcePath path} per
     * {@link PackType type}.
     *
     * <p><strong>Ensure that you close the resource once you have finished working
     * with it!</strong></p>
     *
     * @param type The type
     * @param path The domain named path
     * @return The resource
     */
    Resource requireResource(PackType type, ResourcePath path) throws IOException;

    /**
     * Finds all the {@link ResourcePath}s in this pack matching the
     * prefix and filter, and within the given depth.
     *
     * @param type The type
     * @param namespace The namespace to search
     * @param prefix The prefix of the path
     * @param depth The depth to search
     * @param filter The filter every path must match
     * @return A collection of matching paths
     * @see PackType
     */
    Collection<ResourcePath> paths(PackType type, String namespace, String prefix, int depth, Predicate<String> filter);

    /**
     * Tests if this pack contains an entry at the given {@link ResourcePath}.
     *
     * @param type The type
     * @param path The resource path
     * @return True if it exists, false if it does not
     * @see PackType
     */
    boolean exists(PackType type, ResourcePath path);

    /**
     * Gets the {@link String namespaces} per {@link PackType type}.
     *
     * @param type The type
     * @return The set of namespaces
     */
    Set<String> namespaces(PackType type);

    @Override
    void close();

}
