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
package org.spongepowered.api.plugin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.asset.Asset;
import org.spongepowered.api.asset.AssetManager;
import org.spongepowered.plugin.meta.PluginDependency;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * A wrapper around a class marked with an {@link Plugin} annotation to retrieve
 * information from the annotation for easier use.
 */
public interface PluginContainer {

    /**
     * Gets the qualified ID of the {@link Plugin} within this container.
     *
     * @return The plugin ID
     * @see Plugin#id()
     */
    String getId();

    /**
     * Gets the name of the {@link Plugin} within this container.
     *
     * @return The plugin name, or {@link #getId()} if unknown
     * @see Plugin#name()
     */
    default String getName() {
        return getId();
    }

    /**
     * Gets the version of the {@link Plugin} within this container.
     *
     * @return The plugin version, or {@link Optional#empty()} if unknown
     * @see Plugin#version()
     */
    default Optional<String> getVersion() {
        return Optional.empty();
    }

    /**
     * Gets the description of the {@link Plugin} within this container.
     *
     * @return The plugin description, or {@link Optional#empty()} if unknown
     * @see Plugin#description()
     */
    default Optional<String> getDescription() {
        return Optional.empty();
    }

    /**
     * Gets the url or website of the {@link Plugin} within this container.
     *
     * @return The plugin url, or {@link Optional#empty()} if unknown
     * @see Plugin#url()
     */
    default Optional<String> getUrl() {
        return Optional.empty();
    }

    /**
     * Gets the authors of the {@link Plugin} within this container.
     *
     * @return The plugin authors, or empty if unknown
     * @see Plugin#authors()
     */
    default List<String> getAuthors() {
        return ImmutableList.of();
    }

    /**
     * Gets a {@link Set} of all dependencies of the {@link Plugin} within this
     * container.
     *
     * @return The plugin dependencies, can be empty
     * @see Plugin#dependencies()
     */
    default Set<PluginDependency> getDependencies() {
        return ImmutableSet.of();
    }

    /**
     * Gets the {@link PluginDependency} the plugin in this container has on
     * the plugin with the specified plugin ID.
     *
     * @param id The plugin ID of the dependency
     * @return The dependency, or {@link Optional#empty()} if unknown
     */
    default Optional<PluginDependency> getDependency(String id) {
        return Optional.empty();
    }

    /**
     * Retrieves the {@link Asset} of the specified name from the
     * {@link AssetManager} for this {@link Plugin}.
     *
     * @param name Name of asset
     * @return Asset if present, empty otherwise
     */
    default Optional<Asset> getAsset(String name) {
        return Sponge.getAssetManager().getAsset(this, name);
    }

    /**
     * Returns the source the plugin was loaded from.
     *
     * @return The source the plugin was loaded from or {@link Optional#empty()}
     *     if unknown
     */
    default Optional<Path> getSource() {
        return Optional.empty();
    }

    /**
     * Returns the created instance of {@link Plugin} if it is available.
     *
     * @return The instance if available
     */
    default Optional<?> getInstance() {
        return Optional.empty();
    }

    /**
     * Returns the assigned logger to this {@link Plugin}.
     *
     * @return The assigned logger
     */
    default Logger getLogger() {
        return LoggerFactory.getLogger(getId());
    }

}
