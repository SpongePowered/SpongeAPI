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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.Explosion;

import java.util.List;

/**
 * Called once an {@link Explosion} has a list of affected blocks and entities.
 */
public interface WorldOnExplosionEvent extends WorldExplosionEvent {

    /**
     * Gets the affected block positions of the explosion.
     *
     * @return A mutable list of the affected block positions
     */
    List<Vector3i> getAffectedBlockPositions();

    /**
     * Gets the affected entities of the explosion.
     *
     * @return A mutable list of the affected entities
     */
    List<Entity> getAffectedEntities();

    /**
     * Gets the original affected block positions of the explosion.
     *
     * @return An immutable list of the affected block positions
     */
    List<Vector3i> getOriginalAffectedBlockPositions();

    /**
     * Gets the original affected entities of the explosion.
     *
     * @return An immutable list of the affected entities
     */
    List<Entity> getOriginalAffectedEntities();
}
