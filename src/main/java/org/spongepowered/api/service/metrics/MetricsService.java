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
package org.spongepowered.api.service.metrics;

import io.prometheus.client.CollectorRegistry;
import org.spongepowered.plugin.PluginContainer;

/**
 * The service can be used to register additional {@link CollectorRegistry} instances for scraping by prometheus.
 *
 * Implementations can chose to scrape Prometheus' global default registry, however plugins should register their own registry. No name or label rules are enforced, however it is advisable
 * to introduce a plugin specific prefix to plugin specific metrics.
 */
public interface MetricsService {
    /**
     * Registers an additional {@link CollectorRegistry} to be scraped. Time series returned by the {@link io.prometheus.client.Collector} will be namespaced by the plugin to prevent name clashes.
     * The standard Prometheus collectors ({@link io.prometheus.client.Gauge}, {@link io.prometheus.client.Counter}, ...) are thread safe and thus safe for
     * scraping from any thread. If you use custom collector implementations or make use of the provided {@link org.spongepowered.api.service.metrics.pullgauge.PullGauge} interface, make sure your
     * implementation is safe to be called from any thread or add your registry with the asyncCapable parameter set to false.
     *
     * @param plugin the owning plugin
     * @param registry the registry to be scraped
     * @param asyncCapable whether the collectors in the given registry can by scraped outside of the server main thread
     */
    void addCollectorRegistry(PluginContainer plugin, CollectorRegistry registry, boolean asyncCapable);

    /**
     * Removes the given {@link CollectorRegistry} from scraping.
     *
     * @param plugin the owning plugin
     * @param registry the registry to be removed from scraping
     */
    void removeCollectorRegistry(PluginContainer plugin, CollectorRegistry registry);

    /**
     * Removes all {@link CollectorRegistry} instances owned by the given plugin from scaping.
     *
     * @param plugin the owning plugin
     */
    void removeAllCollectorRegistries(PluginContainer plugin);
}
