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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.resource.Resource;
import org.spongepowered.api.resource.ResourcePath;
import org.spongepowered.api.util.Nameable;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * A resource pack or data pack can contain several {@link Resource resources}.
 * A pack con contain both assets and data.
 *
 * @see <a href=http://minecraft.gamepedia.com/Resource_pack#Contents>Minecraft Wiki/Resource Packs</a>
 */
public interface Pack extends Nameable, Closeable {

    /**
     * Creates a new pack from a file. The pack's name will be the file's name.
     *
     * @param path The path to the file to turn into a pack
     * @return The supplier to create a new pack.
     */
    static Supplier<Pack> fromPath(Path path) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).fromPath(path);
    }

    /**
     * Creates a new pack from a plugin's source.
     *
     * @param pluginContainer The plugin
     * @return The supplier to create a new pack
     * @see PluginContainer#getSource()
     */
    static Supplier<Pack> fromPlugin(PluginContainer pluginContainer) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).fromPlugin(pluginContainer);
    }

    /**
     * Gets a resource from this pack if it exists. No other packs will be
     * queried.
     *
     * @param type The type of pack to query
     * @param path The domain named path
     * @return The resource
     * @see PackTypes
     */
    InputStream openStream(PackType type, ResourcePath path) throws IOException;

    /**
     * Finds all the {@link ResourcePath}s in this pack matching the
     * prefix and filter, and within the given depth.
     *
     * @param type   The type of pack resource to find
     * @param prefix The prefix of the path
     * @param depth  The depth to search
     * @param filter The filter every path must match
     * @return A collection of matching paths
     * @see PackTypes
     */
    Collection<ResourcePath> find(PackType type, String prefix, int depth, Predicate<String> filter);

    /**
     * Tests if this pack contains an entry at the given {@link ResourcePath}.
     *
     * @param type The pack type to query
     * @param path The resource path
     * @return True if it exists, false if it does not
     * @see PackTypes
     */
    boolean exists(PackType type, ResourcePath path);

    /**
     * Gets the namespaces known by this pack.
     * <p>
     * TODO: Does this need to be exposed?
     *
     * @param type The pack type to query
     * @return The set of namespaces
     * @see PackTypes
     */
    Set<String> getNamespaces(PackType type);

    /**
     * Gets the metadata of this pack. The {@link DataView} represented is of
     * the pack.json file in the pack root. If the pack does not contain a
     * pack.json, {@link Optional#empty()} is returned.
     *
     * @param name The name of the metadata section
     * @return The metadata if it exists
     */
    Optional<DataView> getMetadata(String name) throws IOException;

    interface Factory {

        Supplier<Pack> fromPath(Path path);

        Supplier<Pack> fromPlugin(PluginContainer pluginContainer);

    }
}
