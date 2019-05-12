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

import org.spongepowered.api.Engine;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Manages the {@link PackInfo packs} which are known to the game. Use this
 * class to get specific packs, as well as enable and disable packs from
 * loading on the next call to {@link Engine#reloadResources()}.
 */
public interface PackRepository {

    /**
     * Refreshes all the providers in the repository.
     */
    void refresh();

    /**
     * Sets the active packs to be used when reloading resources. Calls to this
     * should be followed by {@link Engine#reloadResources()} in order to take
     * effect.
     *
     * @param packs The active packs
     * @see Engine#reloadResources()
     */
    void setEnabledPacks(List<PackInfo> packs);

    /**
     * Returns a collection of all available packs. An available pack could be
     * enabled or not.
     *
     * @return A collection of available packs.
     */
    Collection<PackInfo> getAllPacks();

    /**
     * Gets the list of packs which are not enabled.
     *
     * @return The disabled packs
     */
    Collection<PackInfo> getAvailablePacks();

    /**
     * Returns a collection of enabled packs.
     *
     * @return The enabled packs
     */
    List<PackInfo> getEnabledPacks();

    /**
     * Gets the {@link Pack} defined from the plugin container. The name of the
     * pack will contain the plugin id.
     *
     * @param plugin The plugin container.
     * @return The pack
     */
    PackInfo getPack(PluginContainer plugin);

    /**
     * Gets the pack by its name.
     *
     * @param name The pack's name.
     * @return The pack or empty if it doesn't exist
     */
    Optional<PackInfo> getPack(String name);

}
