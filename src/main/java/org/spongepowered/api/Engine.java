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

import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.registry.RegistryHolder;
import org.spongepowered.api.resource.Resource;
import org.spongepowered.api.resource.ResourceManager;
import org.spongepowered.api.resource.pack.Pack;
import org.spongepowered.api.resource.pack.PackContents;
import org.spongepowered.api.resource.pack.PackRepository;
import org.spongepowered.api.scheduler.Scheduler;

import java.util.concurrent.CompletableFuture;

/**
 * Shared functionality between {@link Client} and {@link Server} engines.
 */
public interface Engine extends RegistryHolder {

    /**
     * Gets the {@link Game} that launched this engine;
     *
     * @return The game
     */
    Game game();

    /**
     * Gets the {@link CauseStackManager} for handling the current event cause
     * stack and context information.
     *
     * @return The cause stack manager
     */
    CauseStackManager causeStackManager();

    /**
     * @return The {@link PackRepository pack repository}
     */
    PackRepository packRepository();

    /**
     * @return The {@link ResourceManager resource manager}
     */
    ResourceManager resourceManager();

    /**
     * Gets the {@link Scheduler} used to schedule sync tasks on this {@link Engine}.
     *
     * @return The sync scheduler
     */
    Scheduler scheduler();

    /**
     * Checks if the {@link Thread#currentThread() current thread} is the main thread of the engine.
     *
     * @return {@code true} if main thread, {@code false} if not
     */
    boolean onMainThread();

    /**
     * Rediscovers all {@link Resource resources} within all {@link Pack pack's} {@link PackContents contents}.
     *
     * <p>On the server, the future will always be completed.</p>
     *
     * @return A future that completes when reloading is complete
     */
    CompletableFuture<Void> reloadResources();
}
