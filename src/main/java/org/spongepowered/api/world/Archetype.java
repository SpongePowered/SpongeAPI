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

import org.spongepowered.api.data.SerializableDataHolder;

import java.util.Optional;

/**
 * A {@link org.spongepowered.api.data.DataHolder.Mutable DataHolder} which has no attachment to any particular world allowing
 * it to be used as a blueprint to create multiple copies of its containing
 * data.
 */
public interface Archetype<S extends LocatableSnapshot<S>, E> extends SerializableDataHolder.Mutable {

    /**
     * Creates a new instance based on this archetype at the given location.
     *
     * @param location The location to create the new instance at
     * @return The created type, if successful
     */
    Optional<E> apply(Location location);

    /**
     * Creates a new immutable snapshot based on this archetype.
     *
     * @param location The location for the snapshot to be specified as at
     * @return The snapshot
     */
    S toSnapshot(Location location);

    @Override
    Archetype<S, E> copy();

}
