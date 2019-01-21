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
package org.spongepowered.api.event.resource;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.resource.Pack;
import org.spongepowered.api.resource.PackRepository;
import org.spongepowered.api.resource.ReloadableResourceManager;
import org.spongepowered.api.resource.Resource;

/**
 * Base interface for resource reloading events.
 */
public interface ResourceReloadEvent extends ResourceEvent, Cancellable {

    /**
     * Called before the {@link ReloadableResourceManager} is reloaded. At this
     * point, the {@link PackRepository#getEnabledPacks() enabled packs} can be
     * added or removed from.
     */
    interface Pre extends ResourceReloadEvent {

        /**
         * Gets the {@link PackRepository} used to reload the resources.
         * {@link Pack packs} and order can be changed using this instance.
         *
         * @return The pack repository.
         */
        PackRepository getPackRepository();

    }

    /**
     * Called after the {@link ReloadableResourceManager} is reloaded. When a
     * {@link Resource} is reloaded, this event should be used to obtain the
     * new file.
     */
    interface Post extends ResourceReloadEvent {

    }
}
