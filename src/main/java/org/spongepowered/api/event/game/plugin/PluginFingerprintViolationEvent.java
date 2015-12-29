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
package org.spongepowered.api.event.game.plugin;

import org.spongepowered.api.event.Event;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Collection;

/**
 * A special event used when the {@link Plugin#certificateFingerprint()} doesn't match the certificate loaded from the JAR
 * file. You could use this to log a warning that the code that is running might not be yours, for example.
 */
public interface PluginFingerprintViolationEvent extends Event {

    /**
     * Gets the plugin.
     *
     * @return The plugin
     */
    PluginContainer getPlugin();

    /**
     * Gets the fingerprint the plugin is expecting to find.
     *
     * @return The expected fingerprint
     */
    String getExpectedFingerprint();

    /**
     * Gets the fingerprints found in the plugin's source jar.
     *
     * @return The found fingerprints
     */
    Collection<String> getFingerprints();

}
