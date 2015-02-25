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
package org.spongepowered.api;

/**
 * Top to bottom order of the lifecycle.
 */
public enum GameState {
    /**
     * During this state, each {@link org.spongepowered.api.plugin.Plugin} instance
     * has been created.
     */
    CONSTRUCTION,

    /**
     * All plugin initialization should be completed. All plugins
     * initialization should be complete.
     */
    LOAD_COMPLETE,

    /**
     * Plugins are able to access a default logger instance and access
     * configuration files.
     */
    PRE_INITIALIZATION,

    /**
     * Plugins should finish any work needed to become functional. Commands
     * should be registered at this stage.
     */
    INITIALIZATION,

    /**
     * Plugins have been initialized and should be ready for action. Loggers,
     * configurations, and third party plugin API's should be prepared for
     * interaction.
     */
    POST_INITIALIZATION,

    /**
     * The {@link Server} instance exists, but worlds have not yet loaded.
     */
    SERVER_ABOUT_TO_START,

    /**
     * The server instance exists and worlds are loaded.
     */
    SERVER_STARTING,

    /**
     * The server is fully loaded and ready to accept clients. All worlds are
     * loaded and all plugins have been loaded.
     */
    SERVER_STARTED,

    /**
     * Server is stopping for any reason. This occurs prior to world saving.
     */
    SERVER_STOPPING,

    /**
     * The server has stopped saving and no players are connected. Any changes
     * to the worlds are not saved.
     */
    SERVER_STOPPED
}
