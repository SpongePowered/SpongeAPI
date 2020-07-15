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
package org.spongepowered.api.world;

import org.spongepowered.api.Server;
import org.spongepowered.math.vector.Vector3i;

/**
 * Represents anything with a location.
 */
@FunctionalInterface
public interface Locatable {

    /**
     * Gets the location of the source.
     *
     * @return The location
     */
    Location<?> getLocation();

    /**
     * Gets the location of the source as a {@link ServerLocation}.
     *
     * <p>For ease of use, we provide this as a quick way to not have to map
     * out the optional in {@link Location#}. Calling this when the source is
     * not on the {@link Server} will result in a hard crash, do so at your
     * own peril.</p>
     *
     * @return The location
     */
    default ServerLocation getServerLocation() {
        final Location<?> location = this.getLocation();
        if (!(location instanceof ServerLocation)) {
            throw new RuntimeException("Attempt made to query for a server sided location on the client!");
        }

        return (ServerLocation) location;
    }

    /**
     * Gets the world that this source resides in.
     *
     * @return The World
     */
    default World<?> getWorld() {
        return this.getLocation().getWorld();
    }

    default Vector3i getBlockPosition() {
        return this.getLocation().getBlockPosition();
    }
}
