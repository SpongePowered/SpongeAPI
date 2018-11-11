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
package org.spongepowered.api.asset;

import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.resource.ResourceManager;

import java.util.Optional;

/**
 * The AssetManager offers a convenient way to easily retrieve resources from
 * Sponge {@link Plugin}s. The asset manager will attempt to find the
 * asset of the specified name at: <code>assets/&lt;plugin_id&gt;</code>
 *
 * @deprecated The asset manager was unable to provide assets which are not on
 * the classpath. Additionally, it was limited to providing the URL to an
 * asset, which might not have been useful in some situations.
 *
 * <p>Use the more powerful {@link ResourceManager} instead. It allows you to
 * add resources from local files as well as on-the-fly generation.</p>
 */
@Deprecated
public interface AssetManager {

    /**
     * Returns the {@link Asset} of the specified name for the specified
     * {@link Plugin} instance.
     *
     * @param plugin Plugin instance
     * @param name Name of resource to retrieve
     * @return Asset if present, empty otherwise
     */
    Optional<Asset> getAsset(PluginContainer plugin, String name);

    /**
     * Returns the {@link Asset} of the specified name within the domain of the
     * implementation. This method will typically call
     * {@link #getAsset(PluginContainer, String)} using a dummy
     * {@link PluginContainer} for the SpongeAPI implementation.
     *
     * @param name Name of resource to retrieve
     * @return Asset if present, empty otherwise
     */
    Optional<Asset> getAsset(String name);

}
