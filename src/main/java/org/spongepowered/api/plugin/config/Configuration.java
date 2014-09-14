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
package org.spongepowered.api.plugin.config;

import java.io.File;

/**
 * Used to access and modify configs.
 */
public interface Configuration extends ConfigObject {

    /**
     * Gets the file this configuration is saved to.
     * 
     * @return The config file
     */
    File getFile();

    /**
     * Gets the name of this configuration.
     * 
     * @return The config name
     */
    String getName();

    /**
     * Gets whether or not this config exists on the file system.
     * It will be created once it needs to be accessed.
     * 
     * @return Whether the config exists
     */
    boolean exists();

    /**
     * Save the config to the file system.
     * 
     * @return True if successful, false otherwise.
     */
    boolean save();

    /**
     * Loads the config from the file system. Will return true if the file has changed.
     * If it hasn't changed or an IOExceptoin occurs, return false
     * 
     * @return True if it changed, false if not or an IOException occurs.
     */
    boolean load();

}
