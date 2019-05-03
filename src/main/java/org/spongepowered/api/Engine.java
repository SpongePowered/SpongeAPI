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
package org.spongepowered.api;

import org.spongepowered.api.client.Client;
import org.spongepowered.api.resource.ResourceManager;
import org.spongepowered.api.resource.pack.PackRepository;
import org.spongepowered.api.scheduler.Scheduler;

import java.util.concurrent.Executor;

/**
 * Shared functionality between {@link Client} and {@link Server} engines.
 */
public interface Engine extends Executor {

    /**
     * Gets the {@link Scheduler} used to schedule sync tasks on this {@link Engine}.
     *
     * @return The sync scheduler
     */
    Scheduler getScheduler();

    /**
     * Gets the {@link ResourceManager} for the server instance. As of
     * Minecraft 1.13 there is only one instance of the resource manager per
     * server instance. It is not per-world.
     *
     * @return The resource manager
     */
    ResourceManager getResourceManager();

    /**
     * Gets the {@link PackRepository} for the game, which discovers and
     * activates resource and data packs.
     */
    PackRepository getPackRepository();

    /**
     * Checks if the {@link Thread#currentThread() current thread} is the main thread of the engine.
     *
     * @return {@code true} if main thread, {@code false} if not
     */
    boolean onMainThread();
}
