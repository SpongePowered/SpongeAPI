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
package org.spongepowered.api.event.world;

import org.spongepowered.api.Server;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.plugin.PluginEvent;
import org.spongepowered.api.event.server.ServerEvent;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.world.World;

/**
 * Base event for when a {@link World} is loaded.
 */
public interface LoadWorldEvent extends GameEvent, CauseTracked, Cancellable {

    /**
     * Gets the target {@link World}.
     *
     * @return The target world
     */
    World getTargetWorld();

    /**
     * Called when a {@link PluginContainer} loads a {@link World} level.
     */
    interface SourcePlugin extends LoadWorldEvent, PluginEvent { }

    /**
     * Called when a {@link Server} loads a {@link World} level.
     */
    interface SourceServer extends LoadWorldEvent, ServerEvent { }

}
