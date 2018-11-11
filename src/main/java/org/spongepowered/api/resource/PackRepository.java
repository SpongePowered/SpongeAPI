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

import java.util.Collection;
import java.util.Optional;

public interface PackRepository {

    /**
     * Sets the active packs to be used when reloading resources. Calls to this
     * should be followed by {@link ReloadableResourceManager#reload()}.
     *
     * @param packs The active packs
     * @see ReloadableResourceManager#reload()
     */
    void setActivePacks(Collection<PackInfo> packs);

    /**
     * Returns a collection of all available packs. An available pack could be
     * enabled or not.
     *
     * @return A collection of available packs.
     */
    Collection<PackInfo> getAllPacks();

    /**
     * Returns a collection of the disabled packs. Disabled packs are present,
     * but not used in the {@link ResourceManager}. Resources can still be
     * accessed using {@link PackInfo#getPack()}.
     *
     * @return The disabled packs
     */
    Collection<PackInfo> getDisabledPacks();

    /**
     * Returns a collection of enabled packs.
     *
     * @return The enabled packs
     */
    Collection<PackInfo> getEnabledPacks();

    /**
     * Gets the {@link Pack} defined from {@link PluginContainer#getSource()}.
     * The name of the pack will contain the plugin id.
     *
     * @param plugin The plugin instance or container.
     * @return The pack
     * @throws IllegalArgumentException if the object is not a plugin
     */
    PackInfo getPack(Object plugin);

    /**
     * Gets the pack by its name.
     *
     * @param name The pack's name.
     * @return The pack or empty if it doesn't exist
     */
    Optional<PackInfo> getPack(String name);

}
