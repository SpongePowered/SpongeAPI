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

import org.spongepowered.api.plugin.PluginContainer;

import java.util.Map;
import java.util.Optional;

public interface PackProvider {

    /**
     * Returns a map of pack ids to available packs. An available pack could be
     * active or not. The key in the returned map should correspond it its id.
     *
     * @return A collection of available packs.
     */
    Map<String, Pack> getPacks();

    /**
     * Gets the {@link Pack} defined from {@link PluginContainer#getSource()}.
     * The name of the pack will contain the plugin id.
     *
     * @param plugin The plugin instance or container.
     * @return The pack
     * @throws IllegalArgumentException if the object is not a plugin
     */
    Pack getPack(Object plugin);

    /**
     * Gets the pack by its name.
     *
     * @param name The pack's name.
     * @return The pack or empty if it doesn't exist
     */
    Optional<Pack> getPack(String name);

    /**
     * Registers a pack to be usable.
     *
     * @param packId The id of the pack
     * @param pack The pack to register
     */
    void registerPack(String packId, Pack pack);

    /**
     * Unregisters a pack by its name.
     *
     * @param packId The id of the pack
     * @return The pack which was unregistered or empty if it wasn't registered
     */
    Optional<Pack> unregisterPack(String packId);
}
