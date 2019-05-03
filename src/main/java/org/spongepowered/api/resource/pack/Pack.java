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

import org.spongepowered.api.data.DataView;
import org.spongepowered.api.resource.Resource;
import org.spongepowered.api.resource.ResourceManager;
import org.spongepowered.api.resource.ResourcePath;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * A pack can contain several {@link Resource Resources}. Each pack is
 * independently loaded with a configured priority.
 */
public interface Pack {

    /**
     * Opens a new {@link InputStream} to the specified resource.
     *
     * @param type The resource type
     * @param path The path of the resource to open
     * @return The input stream
     * @throws IOException If the resource does not exist or another IOException occurs.
     */
    InputStream openStream(PackType type, ResourcePath path) throws IOException;

    /**
     * Recursively gets all the resources loaded from this pack. All namespaces
     * are considered.
     *
     * @param type The resource type
     * @param path The resource path
     * @param filter The file name filter
     * @return Collection of resources
     * @see ResourceManager#getPaths(String, Predicate)
     */
    Collection<ResourcePath> getPaths(PackType type, String path, Predicate<String> filter);

    /**
     * Checks if a resource exists in this pack.
     *
     * @param type The resource type
     * @param path THe path of the resource
     * @return True if the resource exists, false otherwise
     */
    boolean exists(PackType type, ResourcePath path);

    /**
     * Gets the metadata of this pack. The {@link DataView} represented is of
     * the pack.json file in the pack root. If the pack does not contain a
     * pack.json, {@link Optional#empty()} is returned.
     *
     * @return The metadata if it exists
     */
    Optional<DataView> getMetadata();

    /**
     * Gets the name of this pack which is displayed to the user.
     *
     * @return The name
     */
    String getName();

}
