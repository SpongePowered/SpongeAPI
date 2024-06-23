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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.math.vector.Vector3i;

/**
 * In some particle implementations, they can "follow" a source that moves over
 * several ticks such that a singular position is not enough information to follow.
 */
public interface PositionSource {

    /**
     * Creates {@link PositionSource} for provided position.
     *
     * @param position The position
     * @return The position source
     */
    static PositionSource of(Vector3i position) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(position);
    }

    /**
     * Creates {@link PositionSource} for provided position.
     *
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return The position source
     */
    static PositionSource of(int x, int y, int z) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(x, y, z);
    }

    /**
     * Creates {@link PositionSource} for provided entity.
     *
     * @param entity The entity
     * @return The position source
     */
    static PositionSource of(Entity entity) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(entity);
    }

    /**
     * Creates {@link PositionSource} for provided entity and vertical offset.
     *
     * @param entity The entity
     * @param yOffset The vertical offset
     * @return The position source
     */
    static PositionSource of(Entity entity, double yOffset) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(entity, yOffset);
    }

    interface Factory {

        PositionSource of(Vector3i position);

        PositionSource of(int x, int y, int z);

        PositionSource of(Entity entity);

        PositionSource of(Entity entity, double yOffset);
    }
}
