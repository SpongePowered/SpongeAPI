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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.ResettableBuilder;

import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * A pack can contain several {@link Resource Resources}.
 */
public interface Pack extends ResourceProvider {

    /**
     * Creates a new {@link Builder} instance.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the name of this pack which is displayed to the user.
     *
     * @return The name
     */
    Text getName();

    /**
     * Gets the metadata of this pack. The {@link DataView} represented is of
     * the pack.json file in the pack root. If the pack does not contain a
     * pack.json, {@link Optional#empty()} is returned.
     *
     * @return The metadata if it exists
     */
    Optional<DataView> getMetadata();

    /**
     * Gets all the resources loaded from this pack. Depending on the pack
     * implementation, the contents of the collection may not reflect what the
     * pack contains.
     *
     * <p>If the pack is lazy-initialized, it is possible for the collection to
     * be empty.</p>
     *
     * @return List of loaded resources
     */
    Collection<Resource> getAllResources();

    /**
     * A builder for a {@link Pack}.
     */
    interface Builder extends ResettableBuilder<Pack, Builder> {

        /**
         * Sets the name of this pack as it will appear in chat.
         *
         * @param name The name
         * @return This builder
         */
        Builder name(Text name);

        /**
         * Sets the metadata for this pack.
         *
         * @param metadata The metadata
         * @return This builder
         */
        Builder metadata(DataView metadata);

        /**
         * Adds a static {@link Resource} resource to the {@link Pack}.
         *
         * @param path The path
         * @param resource The data for the resource
         * @return This builder
         */
        Builder resource(ResourcePath path, ResourceData resource);

        /**
         * Specifies static {@link Resource}s to include in the {@link Pack}.
         * Content is loaded along-with the pack. The resources themselves
         * cannot be changed, but the contents are able to be reloaded.
         *
         * @param resources The resources
         * @return This builder
         */
        Builder resources(Map<ResourcePath, ResourceData> resources);

        /**
         * Provides a {@link Resource} list to include in the pack. The
         * resources are loaded when the pack is loaded. Resources can be added
         * or removed as needed.
         *
         * @param resources The resources to load
         * @return This builder
         */
        Builder resources(Supplier<Map<ResourcePath, ResourceData>> resources);

        /**
         * Uses the given path to provide the resources, as well as the
         * metadata and name of pack if not yet provided.
         *
         * <p>The path can be either a directory or a zip file.</p>
         *
         * @param path The path to a folder or zip
         * @return This builder
         */
        Builder from(Path path);

        /**
         * Creates a new instance of {@link Pack}.
         *
         * @return A new pack
         */
        Pack build();
    }
}
