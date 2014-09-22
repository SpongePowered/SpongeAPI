/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.event.state;

import org.apache.logging.log4j.Logger;
import org.spongepowered.api.GameState;

import java.io.File;

/**
 * Represents {@link GameState#PRE_INITIALIZATION} event.
 */
public interface PreInitializationEvent extends StateEvent {

    /**
     * Gets a logger pre-configured to use the Plugin's ID.
     *
     * @return A Logger for the plugin
     */
    public Logger getPluginLog();

    /**
     *
     * @return Plugin Specific Configuration file for smaller plugins that do
     *         not need an entire directory
     */
    public File getSuggestedConfigurationFile();

    /**
     *
     * @return Plugin specific Configuration directory for plugins that need
     *         more than a single config file
     */
    public File getSuggestedConfigurationDirectory();

    /**
     *
     * @return the config folder
     */
    public File getConfigurationDirectory();

}
