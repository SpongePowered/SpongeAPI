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
package org.spongepowered.api.util.metric;

import org.spongepowered.api.util.Tristate;
import org.spongepowered.plugin.PluginContainer;

/**
 * Provides information about whether a server has granted permission for
 * server metric data to be transmitted on a per plugin basis.
 *
 * <p>This manager is {@code @Inject}able into plugin classes.</p>
 */
public interface MetricsConfigManager {

    /**
     * Gets the current <em>global</em> state of collection. The collection state determines
     * how data collection should be handled.
     *
     * Global state determines how an undefined state for a specific plugin should be handled.
     * If a plugin has a state specified then it will override the global state.
     *
     * {@link Tristate#TRUE} Permits data collection
     * {@link Tristate#FALSE} Disallows data collection, this has been explicitly set
     * {@link Tristate#UNDEFINED} Disallows data collection, this is set by default
     *
     * @return The global state of collection
     */
    Tristate getGlobalCollectionState();

    /**
     * Gets the current state of collection for the specified plugin. The collection state
     * determines how data collection should be handled.
     *
     * {@link Tristate#TRUE} Permits data collection
     * {@link Tristate#FALSE} Disallows data collection, this has been explicitly set
     * {@link Tristate#UNDEFINED} Inherit from {@link MetricsConfigManager#getGlobalCollectionState()}, this is set by default
     *
     * @param container The {@link PluginContainer}
     * @return The current collection state
     */
    Tristate getCollectionState(final PluginContainer container);

}
