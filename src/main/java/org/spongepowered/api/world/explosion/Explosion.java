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
package org.spongepowered.api.world.explosion;

import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Optional;
import org.spongepowered.api.entity.explosive.Explosive;
import org.spongepowered.api.world.World;

/**
 * Represents an explosion in a {@link World}.
 */
public interface Explosion {

    /**
     * Gets the world the explosion will occur in.
     *
     * @return The world
     */
    World getWorld();

    /**
     * Gets the source {@link Explosive} of this explosion.
     *
     * @return The source explosive, if present
     */
    Optional<Explosive> getSourceExplosive();

    /**
     * Gets the radius of this explosion.
     *
     * @return The radius
     */
    float getRadius();

    /**
     * Gets a copy of the explosion's origin.
     *
     * @return A copy of the origin
     */
    Vector3d getOrigin();

    /**
     * Gets whether the affected blocks have a chance to catch on fire.
     *
     * @return Whether the affected blocks can catch on fire
     */
    boolean canCauseFire();

    /**
     * Gets whether the explosion will play a smoke effect.
     *
     * @return Whether the explosion will play smoke
     */
    boolean shouldPlaySmoke();

    /**
     * Gets whether the affected blocks should be destroyed on explosion.
     *
     * @return Whether the affected blocks should be destroyed
     */
    boolean shouldBreakBlocks();

    /**
     * If true, blocks will be set to BlockTypes.AIR and items dropped.
     * If false, blocks will be unaffected.
     *
     * @param destroy Whether the affected blocks should be destroyed
     */
    void shouldBreakBlocks(boolean destroy);
}
